package ru.ingver.autotest.main.tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ingver.autotest.common.TestBase;
import ru.ingver.autotest.main.pages.Card;
import ru.ingver.autotest.main.pages.MainPage;
import ru.ingver.autotest.main.pages.SortingType;

import java.util.List;
import java.util.stream.Stream;

public class MainTests extends TestBase {
    private final MainPage mainPage = new MainPage();

    @Test
    @Disabled("BUG-123456 Не прожимается кнопка в карточке товара")
    @Tag("HIGH")
    @DisplayName("Изменение счетчика корзины после добавления товаров")
    void addToCart() {
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

    static Stream<Arguments> sorting() {
        return Stream.of(
                Arguments.of(SortingType.NAME_ASC, getNameAscData()),
                Arguments.of(SortingType.NAME_DESC, getNameDescData()),
                Arguments.of(SortingType.PRICE_ASC, getPriceAscData()),
                Arguments.of(SortingType.PRICE_DESC, getPriceDescData())
        );
    }

    @Tag("HIGH")
    @DisplayName("Сортировка товаров")
    @MethodSource
    @ParameterizedTest
    void sorting(SortingType sortingType, List<Card> expectedCards) {
        mainPage.openMainPageAsStandartUser().setSortingType(sortingType);
        List<SelenideElement> actualCards = mainPage.getCards();
        for (int i = 0; i < actualCards.size(); i++) {
            SelenideElement actualCard = actualCards.get(i);
            Card expectedCard = expectedCards.get(i);

            mainPage.cardShouldHaveTitle(actualCard, expectedCard.getTitle())
                    .cardShouldHaveDescription(actualCard, expectedCard.getDescription())
                    .cardShouldHavePrice(actualCard, expectedCard.getPrice())
                    .cardShouldHaveImageUrl(actualCard, expectedCard.getImgUrl());
        }
    }


    //region test data
    private static List<Card> getNameAscData() {
        return List.of(
                new Card(
                        "Sauce Labs Backpack",
                        "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                        "$29.99",
                        "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"
                ),
                new Card(
                        "Sauce Labs Bike Light",
                        "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                        "$9.99",
                        "/static/media/bike-light-1200x1500.37c843b0.jpg"
                ),
                new Card(
                        "Sauce Labs Bolt T-Shirt",
                        "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                        "$15.99",
                        "/static/media/bolt-shirt-1200x1500.c2599ac5.jpg"
                ),
                new Card(
                        "Sauce Labs Fleece Jacket",
                        "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                        "$49.99",
                        "/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"
                ),
                new Card(
                        "Sauce Labs Onesie",
                        "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                        "$7.99",
                        "/static/media/red-onesie-1200x1500.2ec615b2.jpg"
                ),
                new Card(
                        "Test.allTheThings() T-Shirt (Red)",
                        "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
                        "$15.99",
                        "/static/media/red-tatt-1200x1500.30dadef4.jpg"
                )
        );
    }

    private static List<Card> getNameDescData() {
        return List.of(
                new Card(
                        "Test.allTheThings() T-Shirt (Red)",
                        "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
                        "$15.99",
                        "/static/media/red-tatt-1200x1500.30dadef4.jpg"
                ),
                new Card(
                        "Sauce Labs Onesie",
                        "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                        "$7.99",
                        "/static/media/red-onesie-1200x1500.2ec615b2.jpg"
                ),
                new Card(
                        "Sauce Labs Fleece Jacket",
                        "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                        "$49.99",
                        "/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"
                ),
                new Card(
                        "Sauce Labs Bolt T-Shirt",
                        "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                        "$15.99",
                        "/static/media/bolt-shirt-1200x1500.c2599ac5.jpg"
                ),
                new Card(
                        "Sauce Labs Bike Light",
                        "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                        "$9.99",
                        "/static/media/bike-light-1200x1500.37c843b0.jpg"
                ),
                new Card(
                        "Sauce Labs Backpack",
                        "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                        "$29.99",
                        "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"
                )


        );
    }

    private static List<Card> getPriceAscData() {
        return List.of(
                new Card(
                        "Sauce Labs Onesie",
                        "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                        "$7.99",
                        "/static/media/red-onesie-1200x1500.2ec615b2.jpg"
                ),
                new Card(
                        "Sauce Labs Bike Light",
                        "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                        "$9.99",
                        "/static/media/bike-light-1200x1500.37c843b0.jpg"
                ),
                new Card(
                        "Sauce Labs Bolt T-Shirt",
                        "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                        "$15.99",
                        "/static/media/bolt-shirt-1200x1500.c2599ac5.jpg"
                ),
                new Card(
                        "Test.allTheThings() T-Shirt (Red)",
                        "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
                        "$15.99",
                        "/static/media/red-tatt-1200x1500.30dadef4.jpg"
                ),

                new Card(
                        "Sauce Labs Backpack",
                        "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                        "$29.99",
                        "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"
                ),
                new Card(
                        "Sauce Labs Fleece Jacket",
                        "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                        "$49.99",
                        "/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"
                )
        );
    }

    private static List<Card> getPriceDescData() {
        return List.of(
                new Card(
                        "Sauce Labs Fleece Jacket",
                        "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                        "$49.99",
                        "/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"
                ),
                new Card(
                        "Sauce Labs Backpack",
                        "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                        "$29.99",
                        "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"
                ),
                new Card(
                        "Sauce Labs Bolt T-Shirt",
                        "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                        "$15.99",
                        "/static/media/bolt-shirt-1200x1500.c2599ac5.jpg"
                ),
                new Card(
                        "Test.allTheThings() T-Shirt (Red)",
                        "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
                        "$15.99",
                        "/static/media/red-tatt-1200x1500.30dadef4.jpg"
                ),
                new Card(
                        "Sauce Labs Bike Light",
                        "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                        "$9.99",
                        "/static/media/bike-light-1200x1500.37c843b0.jpg"
                ),
                new Card(
                        "Sauce Labs Onesie",
                        "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                        "$7.99",
                        "/static/media/red-onesie-1200x1500.2ec615b2.jpg"
                )
        );
    }
    //endregion
}
