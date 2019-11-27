package org.qacademy.trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.qacademy.core.ui.AbstractPage;

public class CloseBoard extends AbstractPage {

    @FindBy(css = "a.quiet.js-delete")
    private WebElement linkPermanentlyDeleteBoard;

    @FindBy(css = "input.js-confirm.full.negate")
    private WebElement buttonConfirmDelete;

    public void selectPermanentlyCloseBoard() {
        action.click(linkPermanentlyDeleteBoard);
        action.click(buttonConfirmDelete);
        By boardNotFoundMessage = By.xpath("//*[contains(text(),\"Board not found\")]");
        action.waitVisibility(boardNotFoundMessage);
    }
}
