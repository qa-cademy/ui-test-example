package org.qacademy.trello.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.qacademy.core.Environment;
import org.qacademy.core.ui.AbstractPage;


public class Login extends AbstractPage {

    @FindBy(css = "[name='user']")
    private WebElement userNameTextField;

    @FindBy(css = "[name='password']")
    private WebElement passwordTextField;

    @FindBy(css = "#login")
    private WebElement loginButton;

    public Dashboard loginAs(final String userName, final String password) {
        browser.get(Environment.getInstance().getValue("trello.url"));
        action.setValue(userNameTextField, userName);
        action.setValue(passwordTextField, password);
        action.click(loginButton);
        return new Dashboard();
    }
}

