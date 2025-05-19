Feature: Add payee feature

  @AddPayeeorbeneficiary
  Scenario: Verify that the user can add a payee to the account.
    Given I am on the home page
    When I go to user login page
    And I log in with valid credentials
      | Email Address | 8178kumar@gmail.com |
      | Password      | kumar123            |
    Then I should be navigated to the user dashboard page
    Then I go to the add payee page
    When I add following payee account details
      | Account Number         |   873982407 |
      | Confirm Account Number |   873982407 |
      | Account Holder Name    | Rahul Kumar |
    Then I should see Payee account details have been added successfully
    
