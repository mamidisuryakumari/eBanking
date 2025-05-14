Feature: Add payee feature
 @AddPayeeorbeneficiary
  Scenario: Verify that the user can add a payee to the account.
    Given I am on the home page
    And I clicks on user menu
    And I should be navigated to the user login page
    And I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanya@123       |
    And I should be navigated to the user dashboard page
    When I clicks on add link
    Then I should be navigated to the add payee page
    When I add following payee account details
      | Account Number         | 520143070 |
      | Confirm Account Number | 520143070 |
      | Account Holder Name    | kumar M   |
    Then I should see the message "Payee or beneficiary account details have been added"
    And I should be navigated to the manage payee page