Feature: Profile update feature

  Scenario: Verify that the user can successfully update their profile
    Given I am on the home page
    When I navigate to login page as a user
    And I log in with valid credentials
      | Email Address | rahul12@gmail.com |
      | Password      | rahul12           |
    Then I should be navigated to the user dashboard page
    When I go to the user profile page
    Then I should see the user profile page
    When I enter user profile update details
      | Last Name    | Kumar${random}  |
      | Mobile Number | ${mobileNumber} |
    Then I should see profile updated successfully
