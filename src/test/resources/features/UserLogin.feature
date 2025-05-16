Feature: Login feature

  @Userregistration
  Scenario: Verify that the user can successfully register.
    Given I am on the home page
    When I navigate to user login page
    And I go to registration page
    And I add user registration details:
      | First Name    | Kumar           |
      | Last Name     | M               |
      | Email Address | kumar@gmail.com |
      | Mobile Number |      9963553645 |
      | Password      | kumar123        |
    Then I should see user registered successfully

  @UserLogin
  Scenario: Verify that the user can log in with a valid username and password.
    Given I am on the home page
    When I go to user login page
    And I log in with valid credentials
      | Email Address | 8178kumar@gmail.com |
      | Password      | kumar123            |
    Then I should be navigated to the user dashboard page
