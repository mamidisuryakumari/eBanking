Feature: Create Account feature

  @Accountopening
  Scenario: Verify that the user can open a new account.
    Given I am on the home page
    When I go to user login page
    And I log in with valid credentials
      | Email Address | 1486surya@gmail.com |
      | Password      | surya123            |
    Then I should be navigated to the user dashboard page
    When I go to the account Details page
    And I enters the following account details
      | Address Proof ID Number |                  123578942368 |
      | PAN Card ID Number      | WERTE1234A                    |
      | Address                 | D.No 12-39, Colony, Nandivada |
      | Date of birth           | 25-11-1991                    |
    Then I should see account opening successfully
