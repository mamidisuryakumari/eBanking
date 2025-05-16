Feature: Logout feature

Scenario: Verify that the user can successfully log out
Given I am on the home page
    When I clicks on user menu
    Then I should be navigated to the user login page
    When I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    Then I should be navigated to the user dashboard page
    When I clicks on image
    And  I click on logout link
    Then I should see ready to leave pop up
    When I clicks on logout button
    Then I should be navigated to the user login page
    
    
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