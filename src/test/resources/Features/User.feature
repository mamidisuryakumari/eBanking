Feature: User Functionality

  @Userregistration
  Scenario: Verify that the user can successfully register.
    Given the user is on the home page
    When the user clicks on user menu
    Then the user should be navigated to the login page
    When the user clicks on create an account link
    Then the user should be navigated to the registration page
    When the user registers with the following details
      | First Name    | Dhanya            |
      | Last Name     | Sri               |
      | Email Address | dhanyas@gmail.com |
      | Mobile Number |        9963512345 |
      | Password      | dhanyas@123       |
    Then the user should see a registration successful message

  @UserLogin
  Scenario: Verify that the user can log in with a valid username and password.
    Given the user is on the home page
    When the user clicks on user menu
    Then the user should be navigated to the login page
    When the user log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    Then the user should be navigated to the dashboard page

  @Accountopening
  Scenario: Verify that the user can open a new account.
    Given the user is on the home page
    And the user clicks on user menu
    And the user should be navigated to the login page
    And the user log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And the user should be navigated to the dashboard page
    When the user clicks on the Account Opening option
    Then the user should be navigated to the Account Details page
    When the user enters the following account details
      | Address Proof ID Number |                  123578942365 |
      | PAN Card ID Number      | WERTF1234A                    |
      | Address                 | D.No 12-39, Colony, Nandivada |
      | Date of birth           | 12-11-1990                    |
    Then the user should see a message "Account opened successfully"

  @AddPayeeorbeneficiary
  Scenario: Verify that the user can add a payee to the account.
    Given the user is on the home page
    And the user clicks on user menu
    And the user should be navigated to the login page
    And the user log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And the user should be navigated to the dashboard page
    When the user add following payye account details
      | Account Number         | 520143070 |
      | Confirm Account Number | 520143070 |
      | Account Holder Name    | kumar M   |
    Then the user should see the message "Payee or beneficiary account details have been added"

  @deletePayee
  Scenario: Verify that the user can delete a payee from the account.
   Given the user is on the home page
    And the user clicks on user menu
    And the user should be navigated to the login page
    And the user log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And the user should be navigated to the dashboard page
    When the user deletes the payee details
    Then the user should see the message "Data deleted"

  @MoneyTraferToPayee
  Scenario: Verify that the user can transfer money to a payee's account.
   Given the user is on the home page
    And the user clicks on user menu
    And the user should be navigated to the login page
    And the user log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And the user should be navigated to the dashboard page
    When the user money transfers to the payee's account
    Then the user should see the message "Transaction details have been updated successfully"
@TransactionHistory
  Scenario: Verify that the user can view the transaction history.
 Given the user is on the home page
    And the user clicks on user menu
    And the user should be navigated to the login page
    And the user log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And the user should be navigated to the dashboard page
    When the user clicks on the transaction history 
    Then the user should see the transaction history
@TansactionReport                                     
  Scenario: Verify that the user can view the transaction report.
  Given the user is on the home page
    And the user clicks on user menu
    And the user should be navigated to the login page
    And the user log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And the user should be navigated to the dashboard page
    When the user clicks on the transaction report 
    Then the user should see the transaction report
