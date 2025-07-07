Feature: Admin Login

  Scenario: Verify that the admin can log in  with valid username and password

    Given I am on the home page
    When I navigate to admin login page as a admin
    Then I am on admin login page
    When I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin@123        |
    Then I should be navigated to the admin dashboard page