package org.qacademy.core.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAction {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriverAction(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void setValue(final WebElement element, final String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public void click(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitVisibility(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibility(final By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getValue(final By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    public boolean isExistingSelector(final By element) {
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(element);
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return true;
    }
}
