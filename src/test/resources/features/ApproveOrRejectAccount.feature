Feature: Admin approve and reject account

  Background: 
   Given I am on the home page
    When I navigate to page as a user
    And I go to registration page
    And I add user registration details:
      | First Name    | Kumar_${random}           |
      | Last Name     | M                         |
      | Email Address | Kumar_${random}@gmail.com |
      | Mobile Number |                9963553645 |
      | Password      | kumar123                |
    Then I should see user registration message as You have successfully registered with us
    When I login with userName and password
 #   Then I should be navigated to the user dashboard page
    When I go to the account Details page
    And I enters the following account details
      | Address Proof ID Number | ${aadharCard}                 |
      | PAN Card ID Number      | ${panNumber}                  |
      | Address                 | D.No 12-39, Colony, Nandivada |
      | Date of birth           | 25-11-1991                    |
   Then I should see success message as Details succesfully submitted.

  @AccountApproval
  Scenario: Verify admin approve the request
    When I go to home page
    Then I am on the home page
   When I navigate to admin login page as a admin
    Then I am on admin login page
    When I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    Then I should be navigated to the admindashboard page
    When I go to the new account request page
    Then I am on new account request page
    When I go to the account holder details page
 #   Then I am on account holder details page
    When I approve the request
    Then I should see approve request success message as Remark has been updated

  @AccountReject
  Scenario: Verify admin reject the request
    When I go to home page
    Then I am on the home page
    When I go to the admin login page
    Then I am on admin login page
    When I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    Then I should be navigated to the admindashboard page
    When I go to the new account request page
    Then I am on new account request page
    When I go to the account holder details page
    Then I am on account holder details page
    When I reject the request
    Then I should see reject request success message as Remark has been updated
