Feature: Admin profile update 

Background: Given I am on the home page
    And I go to the admin login page
    And I am on admin login page
    And I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    And I should be navigated to the admindashboard page

Scenario: Verify admin can update their profile
When I go to the admin profile page
Then I am on the admin profile page
When I upate admin profile 
Then I should see profile has been updated successfully

