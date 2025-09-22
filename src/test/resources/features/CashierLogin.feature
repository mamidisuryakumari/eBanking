Feature: Cashier login

  @Cashierlogin @happy-path @Regression
  Scenario: Verify that the cashier log in with a valid employee id and password
    Given I am on the home page
    When I navigate to cashier login page as a cashier
    And I log in with cashier valid credentials
      | EmployeeId | cashier222 |
      | Password   |  cashier@222  |
    Then I should be navigated to the cashier dashboard page

