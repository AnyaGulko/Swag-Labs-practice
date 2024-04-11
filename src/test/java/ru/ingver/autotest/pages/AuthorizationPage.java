package ru.ingver.autotest.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {
    private final SelenideElement username = $("#user-name"),
            password = $("#password"),
            appLogo = $(".app_logo"),
            loginButton = $("#login-button"),
            errorMessage = $(".error-message-container.error");


    public AuthorizationPage openAuthorizationPage() {
        open("");
        return this;
    }

    public AuthorizationPage setUserName(String value) {
        username.setValue(value);
        return this;
    }

    public AuthorizationPage setPassword(String value) {
        password.setValue(value);
        return this;
    }

    public void pressLoginButton() {
        loginButton.pressEnter();
    }

    public void checkHomeScreen() {
        appLogo.shouldHave(Condition.text("Swag Labs"));
    }

    private AuthorizationPage errorInputField(SelenideElement locator, Condition value) {
        $(locator)
                .shouldHave(cssValue("border-bottom-color", "rgba(226, 35, 26, 1)"))
                .shouldBe(value)
                .sibling(0)
                .shouldHave(cssClass("error_icon"));
        return this;
    }

    private AuthorizationPage errorMessageContainer(SelenideElement locator, String value) {
        SelenideElement div = $(locator);
        div.shouldHave(cssValue("background-color", "rgba(226, 35, 26, 1)"));
        div.$("button")
                .shouldHave(cssClass("error-button")).shouldHave(visible)
                .shouldHave(attribute("data-test", "error-button"));
        div.$("h3")
                .shouldHave(attribute("data-test", "error"))
                .shouldHave(text(value));
        return this;
    }

    public AuthorizationPage errorWithEmptyFields() {
        return errorInputField(username, empty)
                .errorInputField(password, empty)
                .errorMessageContainer(errorMessage, "Epic sadface: Username is required");
    }

    public AuthorizationPage errorWithEmptyFieldPassword() {
        return errorInputField(username, not(empty))
                .errorInputField(password, empty)
                .errorMessageContainer(errorMessage, "Epic sadface: Password is required");
    }

    public AuthorizationPage errorWithEmptyFieldUsername() {
        return errorInputField(username, empty)
                .errorInputField(password, not(empty))
                .errorMessageContainer(errorMessage, "Epic sadface: Username is required");
    }

    public AuthorizationPage errorAuthorizationForBlockedUser() {
        return errorInputField(username, not(empty))
                .errorInputField(password, not(empty))
                .errorMessageContainer(errorMessage, "Epic sadface: Sorry, this user has been locked out.");
    }
}
