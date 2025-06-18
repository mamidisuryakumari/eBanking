Feature: Cashier logout

  Scenario: Verify that the cashier can log out successfully
    Given I am on the home page
    When I navigate to cashier login page as a cashier
    And I log in with cashier valid credentials
      | EmployeeId | cashier222 |
      | Password   | cashier@222 |
    Then I should be navigated to the cashier dashboard page
    When I click on the logout link
    Then I should see the logout confirmation popup
    When I click on the logout button
    Then I should be logged out successfully
    And I should be navigated to the cashier login page