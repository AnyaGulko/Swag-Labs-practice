package ru.ingver.autotest.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.NullSource;
import ru.ingver.autotest.pages.AuthorizationPage;

import static ru.ingver.autotest.utils.RandomUtils.getUserName;

public class AuthorizationFormTests extends TestBase{
    AuthorizationPage authorizationPage = new AuthorizationPage();
    final static String TEST_PASSWORD = "secret_sauce";
    final static String TEST_BLOCKED_USER = "locked_out_user";
    String userName = getUserName();

    @Tag("BLOCKER")
    @CsvFileSource(resources = "/test_data/successfulAuthorizationTest.csv")
    @ParameterizedTest(name = "Успешная авторизация с логином {0} и паролем {1}")
    @DisplayName("Успешная авторизация")
    void successfulAuthorizationTest(String name, String password) {
        authorizationPage.openAuthorizationPage()
                .setUserName(name)
                .setPassword(password)
                .pressLoginButton();
        authorizationPage.checkHomeScreen();
    }


    @Tag("HIGH")
    @NullSource
    @ParameterizedTest(name = "Авторизация с пустым логином и паролем")
    @DisplayName("Обработка ошибки при авторизации с пустыми полями")
    void errorWithEmptyFieldsTest(String empty) {
        authorizationPage.openAuthorizationPage()
                .setUserName(empty)
                .setPassword(empty)
                .pressLoginButton();

        authorizationPage.errorWithEmptyFields();
    }

    @Test
    @Tag("LOW")
    @DisplayName("Обработка ошибки при авторизации с незаполненным паролем")
    void errorWithEmptyFieldPasswordTest() {
        authorizationPage.openAuthorizationPage()
                .setUserName(userName)
                .pressLoginButton();

        authorizationPage.errorWithEmptyFieldPassword();
    }

    @Test
    @Tag("LOW")
    @DisplayName("Обработка ошибки при авторизации с незаполненным логином")
    void errorWithEmptyFieldUsernameTest() {
        authorizationPage.openAuthorizationPage()
                .setPassword(TEST_PASSWORD)
                .pressLoginButton();

        authorizationPage.errorWithEmptyFieldUsername();
    }

    @Test
    @Tag("HIGH")
    @DisplayName("Обработка ошибки при авторизации под заблокированным пользователем")
    void blockedUserAuthorizationErrorsTest() {
        authorizationPage.openAuthorizationPage()
                .setUserName(TEST_BLOCKED_USER)
                .setPassword(TEST_PASSWORD)
                .pressLoginButton();

        authorizationPage.errorAuthorizationForBlockedUser();
    }


}
