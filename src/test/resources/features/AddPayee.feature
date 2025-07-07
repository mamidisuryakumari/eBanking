Feature: Add payee feature
  @AddPayeeorbeneficiary @happy-path
  Scenario: Verify that the user can add a payee to the account.
    Given I am on the home page
    When I navigate to login page as a user
    And I log in with valid credentials
      | Email Address | rahul12@gmail.com |
      | Password      | rahul@12         |
    Then I should be navigated to the user dashboard page
    When I go to manage payee page
    Then I should be navigated to the user manage payee page
    When I go to home page
    When I navigate to login page as a Admin
    Then I am on admin login page
    When I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    Then I should be navigated to the admin dashboard page
    When I go to approved account request page
    When I compare manage payee and approved account holder
    And I navigated to the admin account holder details page
    When I go to home page
    When I navigate to login page as a user
    And I login with userName and password
    Then I should be navigated to the user dashboard page
    Then I go to the add payee page
    When I add payee account details
    Then I should see Payee account details have been added successfully



    
