package ru.ingver.autotest.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;

public class TestBase {
    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1200x1080";
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.savePageSource = false;
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterAll
    static void disposeResources() {
        closeWebDriver();
    }

    @AfterEach
    void disposeWindow() {
        closeWindow();
    }
}
