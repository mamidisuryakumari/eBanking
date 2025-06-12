Feature: Profile update feature

  Scenario: Verify that the user can successfully update their profile
    Given I am on the home page
    When I go to user login page
    And I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanya123         |
    Then I should be navigated to the user dashboard page
    When I go to the user profile page
    Then I should see the user profile page
    When I enter user profile update details
      | First Name    | Dhanya Sri |
      | Last Name     | M          |
      | Mobile Number | 9963563555 |
    Then I should see profile updated successfully
