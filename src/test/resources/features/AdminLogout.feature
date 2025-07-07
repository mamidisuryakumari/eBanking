Feature: Admin login feature

  Scenario: Verify that the admin can logout successfully

    Given I am on the home page
    When I navigate to admin login page as a admin
    Then I am on admin login page
    When I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin@123        |
    Then I should be navigated to the admin dashboard page
    When I click on the admin logout link
    Then I should see the admin logout confirmation popup
    When I click on the admin logout button
    Then I should be admin logged out successfully
    And I should be navigated to the admin login page