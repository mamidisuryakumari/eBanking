Feature: Create Account feature
 @Accountopening
  Scenario: Verify that the user can open a new account.
    Given I am on the home page
    And I clicks on user menu
    And I should be navigated to the user login page
    And I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And I should be navigated to the user dashboard page
    When I clicks on the Account Opening option
    Then I should be navigated to the account Details page
    When I enters the following account details
      | Address Proof ID Number |                  123578942365 |
      | PAN Card ID Number      | WERTF1234A                    |
      | Address                 | D.No 12-39, Colony, Nandivada |
      | Date of birth           | 12-11-1990                    |
    Then I see a message "Account opened successfully"