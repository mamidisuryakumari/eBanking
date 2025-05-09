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
    Then I should see logout link
    When I click on logout link
    Then I should see ready to leave pop up
    When I clicks on logout button
    Then I should be navigated to the user login page