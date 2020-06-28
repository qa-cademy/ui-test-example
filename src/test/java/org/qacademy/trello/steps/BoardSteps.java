package org.qacademy.trello.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.qacademy.core.Environment;
import org.qacademy.trello.pages.Board;
import org.qacademy.trello.pages.BoardFields;
import org.qacademy.trello.pages.BoardForm;
import org.qacademy.trello.pages.CloseBoard;
import org.qacademy.trello.pages.Dashboard;
import org.qacademy.trello.pages.Login;
import org.qacademy.trello.pages.MenuBoard;
import org.qacademy.trello.pages.MenuMoreBoard;

import static org.testng.Assert.assertFalse;

public class BoardSteps {

    private Login login;
    private Dashboard dashboard;
    private BoardForm boardForm;
    private Board board;
    private MenuBoard menuBoard;
    private MenuMoreBoard menuMoreBoard;
    private CloseBoard closeBoard;

    public BoardSteps(final Login login, final Dashboard dashboard, final BoardForm boardForm,
                      final Board board, final MenuBoard menuBoard, final MenuMoreBoard menuMoreBoard,
                      final CloseBoard closeBoard) {
        this.login = login;
        this.dashboard = dashboard;
        this.boardForm = boardForm;
        this.board = board;
        this.menuBoard = menuBoard;
        this.menuMoreBoard = menuMoreBoard;
        this.closeBoard = closeBoard;
    }

    @Given("I Log in with {string} user")
    public void iLogInWithUser(String user) {
        String userNameKey = String.format("trello.credentials.%s.username", user);
        String passwordKey = String.format("trello.credentials.%s.password", user);
        login.loginAs(Environment.getInstance().getValue(userNameKey), Environment.getInstance().getValue(passwordKey));
    }

    @And("I create a board with:")
    public void iCreateABoardWith(final Map<BoardFields, String> dataTable) {
        dashboard.clickAddBoard();
        boardForm.createNewBoard(dataTable);
    }

    @When("I close Board")
    public void iCloseBoard() {
        board.clickShowMenu();
        menuBoard.clickInLinkMore();
        menuMoreBoard.selectLinkCloseBoard();
    }

    @And("I delete Board")
    public void iDeleteBoard() {
        closeBoard.selectPermanentlyCloseBoard();
    }

    @Then("I should not see the board {string}")
    public void iShouldNotSeeTheBoard(final String titleBoard) {
        dashboard.clickBtnHeaderBoard();
        assertFalse(dashboard.doIsExistBoard(titleBoard));
    }
}
