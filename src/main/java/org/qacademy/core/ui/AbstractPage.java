package org.qacademy.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver browser;
    protected WebDriverWait wait;
    protected WebDriverAction action;

    protected AbstractPage() {
        this.browser = DriverManager.getInstance().getDriver();
        this.wait = new WebDriverWait(browser, 30);
        this.action = new WebDriverAction(browser, wait);
        PageFactory.initElements(this.browser, this);
    }
}
