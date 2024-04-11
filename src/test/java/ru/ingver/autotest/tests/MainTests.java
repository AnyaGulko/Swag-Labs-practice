package ru.ingver.autotest.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ingver.autotest.pages.MainPage;
import ru.ingver.autotest.pages.components.Card;
import ru.ingver.autotest.pages.components.SortingType;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MainTests {
    private final MainPage mainPage = new MainPage();

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1200x1080";
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.savePageSource = false;
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void disposeWindow() {
        Selenide.closeWebDriver();
    }

    @Test
    @Disabled("BUG-123456 Не прожимается кнопка в карточке товара")
    @Tag("HIGH")
    @DisplayName("Изменение счетчика корзины после добавления товаров")
    void addToCartTest() {
        mainPage.openMainPageAsErrorUser()
                .counterShouldNotExist();

        List<SelenideElement> actualCards = mainPage.getCards();
        for (int index = 0; index < actualCards.size(); index++) {
            SelenideElement actualCard = actualCards.get(index);
            mainPage.buttonShouldHave(actualCard, "Add to cart")
                    .clickOnAddToCart(actualCard)
                    .buttonShouldHave(actualCard, "Remove")
                    .counterShouldHave(index + 1);
        }
    }

    static Stream<Arguments> productsSorting() {
        return Stream.of(
                arguments(named("В алфавитном порядке", SortingType.NAME_ASC)),
                arguments(named("В обратном алфавитном порядке", SortingType.NAME_DESC)),
                arguments(named("По возрастании цены", SortingType.PRICE_ASC)),
                arguments(named("По убыванию цены", SortingType.PRICE_DESC))
        );
    }

    @Tag("HIGH")
    @DisplayName("Сортировка товаров")
    @MethodSource("productsSorting")
    @ParameterizedTest(name = "{0}")
    void productsSortingTest(SortingType sortingType) {
        mainPage.openMainPageAsStandartUser().setSortingType(sortingType);
        List<SelenideElement> actualCards = mainPage.getCards();
        for (int i = 0; i < actualCards.size(); i++) {
            SelenideElement actualCard = actualCards.get(i);
            Card expectedCard = sortingType.getCards().get(i);

            mainPage.cardShouldHaveTitle(actualCard, expectedCard.getTitle())
                    .cardShouldHaveDescription(actualCard, expectedCard.getDescription())
                    .cardShouldHavePrice(actualCard, expectedCard.getPrice())
                    .cardShouldHaveImageUrl(actualCard, expectedCard.getImgUrl());
        }
    }
}
