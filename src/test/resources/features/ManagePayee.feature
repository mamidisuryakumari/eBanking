Feature: Manage Payee feature 

 @deletePayee @happy-path
  Scenario: Verify that the user can delete a payee from the account.
   Given I am on the home page
    When I go to user login page
    And I log in with valid credentials
      | Email Address | 8178kumar@gmail.com |
      | Password      | kumar123            |
    Then I should be navigated to the user dashboard page
    When I go to manage payee page
    And  I deletes the payee details
    Then I should see the data deleted successfully
   
    
     @MoneyTransferToPayee @happy-path
  Scenario: Verify that the user can transfer money to a payee's account.
    Given I am on the home page
    When I go to user login page
    And I log in with valid credentials
      | Email Address | kumari@gmail.com |
      | Password      | kumari123            |
    Then I should be navigated to the user dashboard page
     When I go to manage payee page
    When I go to the transfer amount page 
    And  I money transfers to the payee's account
    Then I should see the Transaction details have been updated successfully

   