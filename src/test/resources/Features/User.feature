Feature: User Functionality

  @Userregistration
  Scenario: Verify user can register successfully
    Given User is on the home page
    When User registers with the following details
      | First Name    | Dileep           |
      | Last Name     | Kumar            |
      | Email Address | dileepk@gmail.com |
      | Mobile Number |       9963512345 |
      | Password      | dileep@123       |
    Then User should see a registration successful message

  @UserLogin 
  Scenario: Verify user login is successful
    Given User is on the home page
    When User log in with valid credentials
      | Email Address | dileepk@gmail.com |
      | Password      | dileep@123        |
    Then User should be navigated to dashboard page
    
