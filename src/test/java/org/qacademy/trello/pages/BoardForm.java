package org.qacademy.trello.pages;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.qacademy.core.ui.AbstractPage;

public class BoardForm extends AbstractPage {

    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement titleTextInputField;

    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement createBoardButton;

    @FindBy(css = ".window-overlay .window")
    private WebElement windowOverlay;

    public Board createNewBoard(final Map<BoardFields, String> data) {
        EnumMap<BoardFields, ISteps> boardSteps = new EnumMap<>(BoardFields.class);
        boardSteps.put(BoardFields.TITLE, () -> action.setValue(titleTextInputField, data.get(BoardFields.TITLE)));
        for (BoardFields key : data.keySet()) {
            boardSteps.get(key).run();
        }
        action.click(createBoardButton);
        wait.until(ExpectedConditions.invisibilityOf(windowOverlay));
        return new Board();
    }
}
