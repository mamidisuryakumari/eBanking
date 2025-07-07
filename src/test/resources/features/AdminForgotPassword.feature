Feature: Admin forgot password

  @Adminforgotpassword @happy-path
  Scenario: Verify that the admin can reset their password using the forgot Password option
    Given I am on the home page
    When I navigate to login page as a admin
    And I go to the admin forgot Password page
    Then I should be navigated to the admin forgot password page
    When I enter forgot password details
      | E-mail address   | admin@gmail.com |
      | Mobile number    | 9128723772      |
      | New Password     | admin@123       |
      | Confirm Password | admin@123       |
    Then I should see admin Password changed successfully
    When I go to home page
    When I navigate to login page as a admin
    And I log in with valid admin email address and new password
    Then I should be navigated to the user dashboard page