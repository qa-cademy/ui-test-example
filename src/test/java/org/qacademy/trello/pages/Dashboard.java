package org.qacademy.trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.qacademy.core.ui.AbstractPage;

public class Dashboard extends AbstractPage {

    private static final String CSS_BOARD_LINK = "a[title='%s']";

    @FindBy(css = "button[data-test-id='header-boards-menu-button'] > span")
    private WebElement boardsMenuButton;

    @FindBy(xpath = "//*[@class='icon-lg icon-member']/ancestor::div[contains(@class,'mod-no-sidebar')]"
            + "/descendant::*[@class='board-tile mod-add']")
    private WebElement createBoardButton;

    public BoardForm clickAddBoard() {
        action.click(createBoardButton);
        return new BoardForm();
    }

    public void clickBtnHeaderBoard() {
        action.click(boardsMenuButton);
    }

    public boolean doIsExistBoard(final String titleBoard) {
        By element = By.xpath(String.format(CSS_BOARD_LINK, titleBoard));
        return action.isExistingSelector(element);
    }
}
