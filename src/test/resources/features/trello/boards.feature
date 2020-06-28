
Feature: Delete board in Trello

  Background:
    Given I Log in with "owner" user
    And I create a board with:
      | Title | Chelsea board |

  Scenario: I delete a board as owner user
    When I close Board
    And I delete Board
    Then I should not see the board "Chelsea board"
