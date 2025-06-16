Feature: Admin profile update

  Background: Given I am on the home page
    When I navigate to admin login page as a admin
    And I am on admin login page
    And I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin@123       |
    And I should be navigated to the admin dashboard page

  Scenario: Verify admin can update their profile
    When I go to the admin profile page
    Then I am on the admin profile page
    When I update admin profile details
      | Admin Name         | admin${random}  |
      | Admin MobileNumber | ${mobileNumber} |
    Then I should see profile has been updated successfully

