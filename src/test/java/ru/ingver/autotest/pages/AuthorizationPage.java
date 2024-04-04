package ru.ingver.autotest.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {
    private final SelenideElement USERNAME = $("#user-name"),
            PASSWORD = $("#password"),
            APP_LOGO = $(".app_logo"),
            LOGIN_BUTTON = $("#login-button"),
            ERROR_MESSAGE = $(".error-message-container.error");


    public AuthorizationPage openAuthorizationPage() {
        open("");
        return this;
    }

    public AuthorizationPage setUserName(String value) {
        USERNAME.setValue(value);
        return this;
    }

    public AuthorizationPage setPassword(String value) {
        PASSWORD.setValue(value);
        return this;
    }

    public void pressLoginButton() {
        LOGIN_BUTTON.pressEnter();
    }

    public void checkHomeScreen() {
        APP_LOGO.shouldHave(Condition.text("Swag Labs"));
    }

    private AuthorizationPage errorInputField(SelenideElement locator, String value) {
        $(locator)
                .shouldHave(cssValue("border-bottom-color", "rgba(226, 35, 26, 1)"))
                .shouldHave(attribute("placeholder", value))
                .sibling(0)
                .shouldHave(cssClass("error_icon"));
        return this;
    }

    private AuthorizationPage errorMessageContainer(SelenideElement locator, String value) {
        SelenideElement div = $(locator);
        div.shouldHave(cssValue("background-color", "rgba(226, 35, 26, 1)"));
        div.$("button")
                .shouldHave(cssClass("error-button"))
                .shouldHave(attribute("data-test", "error-button"));
        div.$("h3")
                .shouldHave(attribute("data-test", "error"))
                .shouldHave(text(value));
        return this;
    }

    public AuthorizationPage errorWithEmptyFields() {
        return errorInputField(USERNAME, "Username")
                .errorInputField(PASSWORD, "Password")
                .errorMessageContainer(ERROR_MESSAGE, "Epic sadface: Username is required");
    }

}
