Feature: Amount deposit and Withdrawal

  Background:
    Given I am on the home page
    When I navigate to cashier login page as a cashier
    And I log in with cashier valid credentials
      | EmployeeId | cashier222  |
      | Password   | cashier@222 |
    Then I should be navigated to the cashier dashboard page

  Scenario: Verify that the cashier deposits amount to the user account
    When I go to the cashier account holder details page
    Then I should be navigated to the cashier account holder details page
    When I search for the user account
    And  I go the cashier user details page
    Then I should be navigated to the cashier user details page
    When I click on deposit button
    Then I should see cashier 'Take Action' model window popup opened
    When I enter the amount and select the transaction type
    Then I should see the success message as Transaction done successfully

  Scenario: Verify that the cashier withdrawal amount from the user account
    When I go to the cashier account holder details page
    Then I should be navigated to the cashier account holder details page
    When I search for the user account
    And  I go the cashier user details page
    Then I should be navigated to the cashier user details page
    When I click on withdrawal button
    Then I should see cashier withdrawal 'Take Action' model window popup opened
    When I enter the withdrawal amount
    Then I should see the success message as Transaction done successfully