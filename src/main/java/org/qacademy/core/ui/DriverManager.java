package org.qacademy.core.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.qacademy.core.Environment;

public final class DriverManager {

    private WebDriver browser;
    private static DriverManager ourInstance = new DriverManager();

    public static DriverManager getInstance() {
        return ourInstance;
    }

    private DriverManager() {
        final String browserName = Environment.getInstance().getValue("trello.browser").toUpperCase();
        browser = BrowserFactory.getDriverManager(DriverType.valueOf(browserName));
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return browser;
    }

}
