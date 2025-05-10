Feature: Profile update feature

Scenario: Verify that the user can successfully update their profile
Given I am on the home page
    And I clicks on user menu
    And I should be navigated to the user login page
    And I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And I should be navigated to the user dashboard page
    When I