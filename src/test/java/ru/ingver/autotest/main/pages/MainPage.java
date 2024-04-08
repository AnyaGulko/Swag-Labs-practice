package ru.ingver.autotest.main.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.ingver.autotest.auth.pages.AuthorizationPage;

import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement SELECT_CONTAINER = $("select.product_sort_container"),
            INVENTORY_LIST = $("div.inventory_list");

    private final By INVENTORY_ITEM = By.cssSelector("div.inventory_item"),
            INVENTORY_ITEM_IMG = By.cssSelector("img.inventory_item_img"),
            INVENTORY_ITEM_NAME = By.cssSelector("div.inventory_item_name"),
            INVENTORY_ITEM_DESC = By.cssSelector("div.inventory_item_desc"),
            INVENTORY_ITEM_PRICE = By.cssSelector("div.inventory_item_price");

    public MainPage openMainPage() {
        new AuthorizationPage()
                .openAuthorizationPage()
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .pressLoginButton();
        return this;
    }

    public void setSortingType(SortingType sortingType) {
        switch (sortingType) {
            case NAME_ASC -> SELECT_CONTAINER.selectOptionByValue("az");
            case NAME_DESC -> SELECT_CONTAINER.selectOptionByValue("za");
            case PRICE_ASC -> SELECT_CONTAINER.selectOptionByValue("lohi");
            case PRICE_DESC -> SELECT_CONTAINER.selectOptionByValue("hilo");
        }
    }

    public List<SelenideElement> getCards() {
        return INVENTORY_LIST.$$(INVENTORY_ITEM);
    }

    public MainPage cardShouldHaveTitle(SelenideElement card, String title) {
        card.$(INVENTORY_ITEM_NAME).shouldHave(text(title));
        return this;
    }

    public MainPage cardShouldHaveDescription(SelenideElement card, String description) {
        card.$(INVENTORY_ITEM_DESC).shouldHave(text(description));
        return this;
    }

    public MainPage cardShouldHavePrice(SelenideElement card, String price) {
        card.$(INVENTORY_ITEM_PRICE).shouldHave(text(price));
        return this;
    }

    public void cardShouldHaveImageUrl(SelenideElement card, String imgUrl) {
        card.$(INVENTORY_ITEM_IMG).shouldHave(attribute("src", Configuration.baseUrl + imgUrl));
    }
}
