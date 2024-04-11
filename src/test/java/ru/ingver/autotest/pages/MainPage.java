package ru.ingver.autotest.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.ingver.autotest.pages.components.SortingType;

import java.util.List;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement selectContainer = $("select.product_sort_container"),
            inventoryList = $("div.inventory_list");

    private final By inventoryItem = By.cssSelector("div.inventory_item"),
            inventoryItemImg = By.cssSelector("img.inventory_item_img"),
            inventoryItemName = By.cssSelector("div.inventory_item_name"),
            inventoryItemDesc = By.cssSelector("div.inventory_item_desc"),
            inventoryItemPrice = By.cssSelector("div.inventory_item_price"),
            buttonInventory = By.cssSelector("button.btn_inventory"),
            shoppingCartBadge = By.cssSelector("span.shopping_cart_badge");

    public MainPage openMainPageAsStandartUser() {
        new AuthorizationPage()
                .openAuthorizationPage()
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .pressLoginButton();
        return this;
    }

    public MainPage openMainPageAsErrorUser() {
        new AuthorizationPage()
                .openAuthorizationPage()
                .setUserName("error_user")
                .setPassword("secret_sauce")
                .pressLoginButton();
        return this;
    }

    public void setSortingType(SortingType sortingType) {
        switch (sortingType) {
            case NAME_ASC -> selectContainer.selectOptionByValue("az");
            case NAME_DESC -> selectContainer.selectOptionByValue("za");
            case PRICE_ASC -> selectContainer.selectOptionByValue("lohi");
            case PRICE_DESC -> selectContainer.selectOptionByValue("hilo");
        }
    }

    public List<SelenideElement> getCards() {
        return inventoryList.$$(inventoryItem);
    }

    public MainPage cardShouldHaveTitle(SelenideElement card, String title) {
        card.$(inventoryItemName).shouldHave(text(title));
        return this;
    }

    public MainPage cardShouldHaveDescription(SelenideElement card, String description) {
        card.$(inventoryItemDesc).shouldHave(text(description));
        return this;
    }

    public MainPage cardShouldHavePrice(SelenideElement card, String price) {
        card.$(inventoryItemPrice).shouldHave(text(price));
        return this;
    }

    public void cardShouldHaveImageUrl(SelenideElement card, String imgUrl) {
        card.$(inventoryItemImg).shouldHave(attribute("src", Configuration.baseUrl + imgUrl));
    }

    public MainPage buttonShouldHave(SelenideElement card, String text) {
        card.$(buttonInventory).shouldHave(text(text));
        return this;
    }

    public MainPage clickOnAddToCart(SelenideElement card) {
        card.$(buttonInventory).click(usingJavaScript());
        return this;
    }

    public void counterShouldNotExist() {
        $(shoppingCartBadge).shouldNot(exist);
    }

    public void counterShouldHave(int count) {
        $(shoppingCartBadge).shouldHave(text(String.valueOf(count)));
    }
}
