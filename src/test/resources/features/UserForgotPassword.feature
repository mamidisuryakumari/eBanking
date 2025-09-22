Feature: User forgot password

  @Regression
  Scenario: Verify that the user can reset their password using the forgot Password option
    Given I am on the home page
    When I navigate to login page as a user
    And I go to the forgot Password page
    Then I should be navigated to the user forgot password page
    When I enter forgot password details
      | E-mail address   | rahul12@gmail.com |
      | Mobile number    | 9575157584        |
      | New Password     | rahul@12          |
      | Confirm Password | rahul@12          |
    Then I should see Password changed successfully
    When I go to home page
    When I navigate to login page as a user
    And I log in with valid email address and new password
    Then I should be navigated to the user dashboard page
