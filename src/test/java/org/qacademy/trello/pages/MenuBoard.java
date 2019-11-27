package org.qacademy.trello.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.qacademy.core.ui.AbstractPage;

public class MenuBoard extends AbstractPage {

    @FindBy(css = ".board-menu-navigation-item-link.js-open-more")
    private WebElement linkMore;

    public MenuMoreBoard clickInLinkMore() {
        action.waitVisibility(linkMore);
        action.click(linkMore);
        return new MenuMoreBoard();
    }
}
