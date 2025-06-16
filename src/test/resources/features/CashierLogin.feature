Feature: Cashier login

  @Cashierlogin
  Scenario: Verify that the cashier log in with a valid employee id and password
    Given I am on the home page
    When I navigate to cashier login page as a cashier
    And I log in with cashier valid credentials
      | EmployeeId | cashier222 |
      | Password   |  cashier@222  |
    Then I should be navigated to the cashier dashboard page

    Scenario: Verify that the cashier deposits amount to the user account
      When I go to the cashier account holder details page
      Then I should be navigated to the cashier account holder details page
      When I search for the user account
      And  I go the cashier details of user page
      Then I should be navigated to the cashier details of user page
      When I deposit the amount
      Then I should see the transaction done successfully