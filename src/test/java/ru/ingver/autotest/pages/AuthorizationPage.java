package ru.ingver.autotest.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {
    private final SelenideElement USERNAME = $("#user-name");
    private final SelenideElement PASSWORD = $("#password");
    private final SelenideElement APP_LOGO = $(".app_logo");
    private final SelenideElement LOGIN_BUTTON = $("#login-button");

    public AuthorizationPage openAuthorizationPage(){
        open("");
        return this;
    }

    public AuthorizationPage setUserName(String value){
        USERNAME.setValue(value);
        return this;
    }

    public AuthorizationPage setPassword(String value){
        PASSWORD.setValue(value);
        return this;
    }

    public AuthorizationPage pressLoginButton(){
        LOGIN_BUTTON.pressEnter();
        return this;
    }

    public AuthorizationPage checkHomeScreen(){
        APP_LOGO.shouldHave(Condition.text("Swag Labs"));
        return this;
    }
}
