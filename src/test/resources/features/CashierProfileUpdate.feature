Feature: Cashier update feature

  Scenario: Verify that the cashier can update their profile
    Given I am on the home page
    When I navigate to cashier login page as a cashier
    And I log in with cashier valid credentials
      | EmployeeId | cashier222  |
      | Password   | cashier@222 |
    Then I should be navigated to the cashier dashboard page
    When I go to the cashier profile page
    Then I should be navigated to the cashier profile page
    When I update following below cashier profile details
      | First Name | Cashier${random} |
      | Address    | Nandivada        |
    Then I should see success message cashier detail has been updated
