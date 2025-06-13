Feature: Login feature

 @UserLogin
  Scenario: Verify that the user can log in with a valid username and password.
    Given I am on the home page
    When I navigate to page as a user
    And I log in with valid credentials
      | Email Address | kumari@gmail.com |
      | Password      | kumari123        |
    Then I should be navigated to the user dashboard page



 

  @ForgotPassword
  Scenario: Verify that the user can reset their password using the forgot Password option
    Given I am on the home page
    When I navigate to page as a user
    And I go to the forgot Password page
    Then I should be navigated to the user forgot password page
    When I enter forgot password details
      | E-mail address   | dileepk@gmail.com |
      | Mobile number    |        9963512345 |
      | New Password     | dileepk123        |
      | Confirm Password | dileepk123        |
    Then I should see Password changed succesfully
