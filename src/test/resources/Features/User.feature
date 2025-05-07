Feature: User Functionality

  @Userregistration
  Scenario: Verify user can register successfully
    Given User is on the home page
    When User click on user menu
    Then User should be navigated to login page
    When User click on create an account link
    Then User should be navigated to registration page
    When User registers with the following details
      | First Name    | Dhanya            |
      | Last Name     | Sri               |
      | Email Address | dhanyas@gmail.com |
      | Mobile Number |        9963512345 |
      | Password      | dhanyas@123       |
    Then User should see a registration successful message

  @UserLogin
  Scenario: Verify user login is successful
    Given User is on the home page
    When User click on user menu
    Then User should be navigated to login page
    When User log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    Then User should be navigated to dashboard page

  @Accountopening
  Scenario: Verify account opening
    Given User is on the home page
    When User click on user menu
    Then User should be navigated to login page
    When User log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    Then User should be navigated to dashboard page
    When the user clicks on the Account Opening option
    Then the user should be navigated to the Account Details page
    When the user enters the following account details
      | Address Proof ID Number |                  123578942365 |
      | PAN Card ID Number      | WERTF1234A                    |
      | Address                 | D.No 12-39, Colony, Nandivada |
      | Date of birth           | 12-11-1990                    |
    Then the user should see a message "Account opened successfully"

  @AddPayeeorbeneficiary
  Scenario: Verify Add Payee or beneficiary
    Given User is on the home page
    When User click on user menu
    Then User should be navigated to login page
    When User log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    Then User should be navigated to dashboard page
    When the user add following payye account details
      | Account Number         |    520143070 |
      | Confirm Account Number |    520143070 |
      | Account Holder Name    | kumar M |
    Then the user should see a message Payee or beneficiary Account detail has been added

    @deletePayee
    Scenario: Verify delete payee
    Given User is on the home page
    When User click on user menu
    Then User should be navigated to login page
    When User log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    Then User should be navigated to dashboard page
    When User delete payee details
    Then User should see message data deleted 
    
    @MoneyTraferToPayee
    Scenario: Verify money transfer to payee
    Given User is on the home page
    When User click on user menu
    Then User should be navigated to login page
    When User log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    Then User should be navigated to dashboard page
    When User money transfer to the payee
    Then the user should see the message "Transaction details have been updated successfully"