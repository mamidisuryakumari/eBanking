Feature: Create Account feature

  @CreateUserAccount @happyPath
  Scenario: Verify that the user can open a new account.
    Given I am on the home page
    When I navigate to login page as a user
    And I go to registration page
    And I add user registration details:
      | First Name    | Kumar_${random}           |
      | Last Name     | M                         |
      | Email Address | Kumar_${random}@gmail.com |
      | Mobile Number |                9963553645 |
      | Password      | kumar123                |
    Then I should see user registration message as You have successfully registered with us
    When I login with userName and password
    Then I should be navigated to the user dashboard page
    When I go to the account Details page
    And I enters the following account details
      | Address Proof ID Number | ${aadharCard}                 |
      | PAN Card ID Number      | ${panNumber}                  |
      | Address                 | D.No 12-39, Colony, Nandivada |
      | Date of birth           | 25-11-1991                    |
   Then I should see success message as Details succesfully submitted.
