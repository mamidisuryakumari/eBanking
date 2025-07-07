Feature: Transaction History feature
@TransactionHistory @happy-path
Scenario: Verify that the user's available balance matches the transaction balance
  Given I am on the home page
  When I navigate to admin login page as a user
  And I log in with valid credentials
    | Email Address | rahul12@gmail.com |
    | Password      | rahul12        |
  Then I should be navigated to the user dashboard page
  When I go to the transaction history page
 And I calculate the transaction balance from the history
  Then the calculated transaction balance should match the available balance displayed
    