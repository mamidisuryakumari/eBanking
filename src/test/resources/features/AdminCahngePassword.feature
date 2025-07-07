Feature: Admin Change password

  @AdminChangePassword @happy-path
  Scenario:  Admin can change their password
    Given I am on the home page
    When I navigate to admin login page as a admin
    Then I am on admin login page
    When I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin@123        |
    Then I should be navigated to the admin dashboard page
    When I go to the admin change password page
    Then I am on the change password page
    When I enter change the password details
      | New password     | admin123  |
      | Confirm password | admin123  |
    Then I should see Your password successfully changed
    When I go to home page
    And I navigate to admin login page as a admin
    And I log in with valid admin credentials
    Then I should be navigated to the admin dashboard page

