Feature: Login feature 

  @Userregistration
  Scenario: Verify that the user can successfully register.
    Given I am on the home page
    When I clicks on user menu
    Then I should be navigated to the user login page
    When I clicks on create an account link
    Then I should be navigated to the user registration page
    When I registers with the following details
      | First Name    | Dhanya            |
      | Last Name     | Sri               |
      | Email Address | dhanyas@gmail.com |
      | Mobile Number |        9963512345 |
      | Password      | dhanyas@123       |
    Then I should see a message You have successfully registered with us

  @UserLogin
  Scenario: Verify that the user can log in with a valid username and password.
    Given I am on the home page
    When I clicks on user menu
    Then I should be navigated to the user login page
    When I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanya@123       |
    Then I should be navigated to the user dashboard page
    
    @ForgotPassword
    Scenario: Verify that the user can reset their password using the forgot Password option
    Given I am on the home page
    When I clicks on user menu
    Then I should be navigated to the user login page
    When I clicks on forgot Password link
    Then I should be navigated to the user forgot password page
    When I enter following details
    |E-mail address| dhanyas@gmail.com|
    |Mobile number | 9963512345 |
    |New Password | dhanya@123|
    |Confirm Password| dhanya@123|
    Then I should see a message "Your Password succesfully changed"

 

 

 

 


