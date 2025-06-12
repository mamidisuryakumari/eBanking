Feature: Transaction History feature
@TransactionHistory
Scenario: Verify that the user's available balance matches the transaction balance
  Given I am on the home page
  When I go to user login page
  And I log in with valid credentials
    | Email Address | kumari@gmail.com |
    | Password      | kumari123        |
  Then I should be navigated to the user dashboard page
  When I go to the transaction history page
 And I calculate the transaction balance from the history
  Then the calculated transaction balance should match the available balance displayed
    