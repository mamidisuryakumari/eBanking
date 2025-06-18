Feature: Cashier update feature

  Scenario: Verify that the cashier can update their change password
    Given I am on the home page
    When I navigate to cashier login page as a cashier
    And I log in with cashier valid credentials
      | EmployeeId | cashier222 |
      | Password   | cashier222 |
    Then I should be navigated to the cashier dashboard page
    When I go to the cashier change password page
    Then I should be navigated to the cashier change password page
    When I change the cashier password with the following details
      | New Password     | cashier@222 |
      | Confirm Password | cashier@222 |
    Then I should see success message Your password successfully changed
    When I go to home page
    And I navigate to admin login page as a cashier
    And I log in with valid cashier employeeId and Password