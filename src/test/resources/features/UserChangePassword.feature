Feature: Change password

  @ChangePassword
  Scenario: Verify that the user can successfully change their password from the user profile
    Given I am on the home page
    When I go to user login page
    And I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanya123         |
    Then I should be navigated to the user dashboard page
    When I go to the change password page
    Then I should be navigated to the change password page
    When I enter change password details
      | Current password | dhanya123 |
      | New password     | dhanyas123  |
      | Confirm password | dhanyas123  |
    Then I should see password changed successfully
