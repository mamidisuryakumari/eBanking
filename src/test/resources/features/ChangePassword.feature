Feature: Change password

Scenario: Verify that the user can successfully change their password
Given I am on the home page
    When I clicks on user menu
    Then I should be navigated to the user login page
    When I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    Then I should be navigated to the user dashboard page
    When I change the password from profile menu
    Then I should be navigated to the change password page
    When I enter following details
    |Current password| dhanya@123|
    |New password| dhanya123|
    |Confirm password|dhanya123|
    
    