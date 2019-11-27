package org.qacademy.trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.qacademy.core.ui.AbstractPage;

public class Board extends AbstractPage {

    @FindBy(css = ".js-show-sidebar")
    private WebElement linkShowMenu;

    public MenuBoard clickShowMenu() {
        By element = By.cssSelector("[class='board-menu js-fill-board-menu hide']");
        if (action.isExistingSelector(element)) {
            action.click(linkShowMenu);
        }
        return new MenuBoard();
    }

}
