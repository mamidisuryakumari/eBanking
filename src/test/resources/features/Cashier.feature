Feature: Cashier login

  @Cashierlogin
  Scenario: Verify that the cashier log in with a valid employee id and password
    Given I am on the home page
    When I navigate to cashier login page as a cashier
    And I log in with cashier valid credentials
      | EmployeeId | ${EmployeeId} |
      | Password   | ${Password}   |
    Then I should be navigated to the cashier dashboard page