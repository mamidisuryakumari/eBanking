Feature: Cashier forgot password

  Scenario: Verify that the cashier can reset their password using the forgot Password option
    Given I am on the home page
    When I navigate to login page as a cashier
    And I go to the cashier forgot Password page
    Then I should be navigated to the cashier forgot password page
    When I enter cashier forgot password details
      | E-mail address   | cashier@gmail.com |
      | Mobile number    | 5897456321        |
      | New Password     | cashier222        |
      | Confirm Password | cashier222        |
    Then I should see cashier Password changed successfully
    When I go to home page
    When I navigate to login page as a cashier
    And I log in with valid cashier credentials
    | EmployeeId | cashier222 |
    Then I should be navigated to the cashier dashboard page