Feature: Logout feature

  Scenario: Verify that the user can successfully log out
    Given I am on the home page
    When I navigate to page as a user
    And I log in with valid credentials
      | Email Address | kumari@gmail.com |
      | Password      | kumari123        |
    Then I should be navigated to the user dashboard page
    When I click on logout link
    Then I should see ready to leave confirmation pop up
    When I clicks on logout button
    Then I should see user logout successfully
    And I should be navigated to the user login page
    
   