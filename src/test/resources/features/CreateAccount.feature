Feature: Create Account feature

  @Accountopening
  Scenario: Verify that the user can open a new account.
    Given I am on the home page
    When I go to user login page
    And I log in with valid credentials
      | Email Address | 8178kumar@gmail.com |
      | Password      | kumar123            |
    Then I should be navigated to the user dashboard page
    When I go to the account Details page
    And I enters the following account details
      | Address Proof ID Number |                                                                        123578942368 |
      | Upload address proof    | C:\\Users\\kumar\\OneDrive\\Pictures\\Screenshots\\Screenshot 2025-04-27 125245.png |
      | Upload pan card         | C:\\Users\\kumar\\OneDrive\\Pictures\\Screenshots\\Screenshot 2025-04-27 125245.png |
      | PAN Card ID Number      | WERTF1234B                                                                          |
      | Address                 | D.No 12-39, Colony, Nandivada                                                       |
      | Date of birth           | 25-11-1991                                                                          |
    Then I should see account opening successfully
