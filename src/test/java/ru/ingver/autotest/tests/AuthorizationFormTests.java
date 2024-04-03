package ru.ingver.autotest.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.ingver.autotest.pages.AuthorizationPage;

import static com.codeborne.selenide.Selenide.sleep;

public class AuthorizationFormTests extends TestBase{
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Tag("BLOCKER")
    @CsvFileSource(resources = "/test_data/successfulAuthorizationTest.csv")
    @ParameterizedTest(name = "Успешная авторизация с логином {0} и паролем {1}")
    @DisplayName("Успешная авторизация")
    void successfulAuthorizationTest (String name, String password){
        authorizationPage.openAuthorizationPage()
                .setUserName(name)
                .setPassword(password)
                .pressLoginButton();
        authorizationPage.checkHomeScreen();
        sleep(3000);
    }
}
