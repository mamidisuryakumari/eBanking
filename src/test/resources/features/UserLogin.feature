Feature: Login feature

  @Userregistration
  Scenario: Verify that the user can successfully register.
    Given I am on the home page
    When I navigate to user login page
    And I go to registration page
    And I add user registration details:
      | First Name    | Kumar                    |
      | Last Name     | M                        |
      | Email Address | user_${random}@gmail.com |
      | Mobile Number |               9963553645 |
      | Password      | user123                  |
    Then I should see user registered successfully
    When I login with userName and password
   # Then User is logged in successfully

  @UserLogin
  Scenario: Verify that the user can log in with a valid username and password.
    Given I am on the home page
    When I go to user login page
    And I log in with valid credentials
      | Email Address | <email>    |
      | Password      | <password> |
    Then I should be navigated to the user dashboard page

  @ForgotPassword
Scenario: Verify that the user can reset their password using the forgot Password option
    Given I am on the home page
    When I go to user login page
    And I go to the forgot Password page
    Then I should be navigated to the user forgot password page
    When I enter forgot password details
      | E-mail address   | dileepk@gmail.com  |
      | Mobile number    |       9963512345 |
      | New Password     | dileepk123        |
      | Confirm Password |dileepk123      |
    Then I should see Password changed succesfully
