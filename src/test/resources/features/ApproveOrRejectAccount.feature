Feature: Admin approve and reject account

  Background:
  Given I am on the home page
  When I navigate to admin login page as a admin
  Then I am on admin login page
  When I log in to admin with valid credentials
    | Email Address | admin@gmail.com |
    | Password      | admin@123        |
  Then I should be navigated to the admin dashboard page

  @AccountApproval @happy-path
  Scenario: Verify admin approve the request
    When I go to the new account request page
    Then I am on new account request page
    When I search an user account
    And I view the user account
    When I go to the account holder details page
   Then I am on account holder details page
    When I click on 'Take Action' button
    Then I should see 'Take Action' model window popup opened
    When I add below remarks:
    |Remarks | Approved|
    |Status  | Approved|
    |Initial Amount | 10000|
    Then I should see approve request success message as Remark has been updated
    When I search the user account and verify the account status
    Then I should see user account status is "Approved"


  @AccountReject @happy-path
  Scenario: Verify admin reject the request
    When I go to the new account request page
    Then I am on new account request page
    When I go to the account holder details page
    Then I am on account holder details page
    When I reject the request
    Then I should see reject request success message as Remark has been updated
