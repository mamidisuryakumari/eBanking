Feature: User Registration

  @UserRegistration @happy-path
  Scenario: Verify that the user can successfully register.
    Given I am on the home page
    When I navigate to login page as a User
    And I go to registration page
    And I add user registration details:
      | First Name    | Surya_${random}           |
      | Last Name     | M                         |
      | Email Address | surya_${random}@gmail.com |
      | Mobile Number | ${mobileNumber}           |
      | Password      | ${password}               |
    Then I should see user registration message as You have successfully registered with us
    When I login with userName and password
    Then I should be navigated to the user dashboard page