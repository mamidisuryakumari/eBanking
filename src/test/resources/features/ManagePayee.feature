Feature: Manage Payee feature 

 @deletePayee
  Scenario: Verify that the user can delete a payee from the account.
   Given I am on the home page
    And I clicks on user menu
    And I should be navigated to the user login page
    And I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And I should be navigated to the user dashboard page
    When I clicks on manage link
    Then I should be navigated to the manage payee page 
    When I deletes the payee details
    Then I should see the message "Data deleted"
    
     @MoneyTraferToPayee
  Scenario: Verify that the user can transfer money to a payee's account.
   Given I am on the home page
    And I clicks on user menu
    And I should be navigated to the user login page
    And I log in with valid credentials
      | Email Address | dhanyas@gmail.com |
      | Password      | dhanyas@123       |
    And I should be navigated to the user dashboard page
    When I clicks on the transfer link
    Then I should be navigated to the transfer amount page 
    When I money transfers to the payee's account
    Then I should see the message "Transaction details have been updated successfully"
    And I should be navigated to the manage payee page 