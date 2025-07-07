Feature: Change password

  @ChangePassword @happy-path
  Scenario: Verify that the user can successfully change their password from the user profile
    Given I am on the home page
    When I navigate to login page as a user
    And I log in with valid credentials
      | Email Address | rahul12@gmail.com |
      | Password      | rahul12           |
    Then I should be navigated to the user dashboard page
    When I go to the change password page
    Then I should be navigated to the change password page
    When I enter change password details
      | New password     | rahul@12  |
      | Confirm password | rahul@12  |
    Then I should see password changed successfully
    When I go to home page
    When I navigate to login page as a user
    And I log in with valid email address and new password
    Then I should be navigated to the user dashboard page