package org.qacademy.trello.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.qacademy.core.ui.AbstractPage;

public class MenuMoreBoard extends AbstractPage {

    @FindBy(xpath = "//a[contains(@class, 'js-close-board')]")
    private WebElement linkCloseBoard;

    @FindBy(css = ".js-open-settings")
    private WebElement linkSettingsBoard;

    @FindBy(css = "input.js-confirm.full.negate")
    private WebElement buttonConfirmClose;

    public CloseBoard selectLinkCloseBoard() {
        action.waitVisibility(linkCloseBoard);
        action.click(linkCloseBoard);
        action.waitVisibility(buttonConfirmClose);
        action.click(buttonConfirmClose);
        return new CloseBoard();
    }

}
