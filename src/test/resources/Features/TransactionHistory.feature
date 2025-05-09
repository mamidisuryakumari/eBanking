Feature: Transaction History feature
@TransactionHistory
  Scenario: Verify that the user can view the transaction history.
Given I am on the home page
    And I clicks on user menu
    And I should be navigated to the user login page
    And I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And I should be navigated to the user dashboard page
    When I clicks on the transaction history 
    Then I should be navigated to the transaction history page
    