 Feature: check

@AccountApproval1
  Scenario: Verify admin approve the request
    When I go to home page
    Then I am on the home page
   When I navigate to admin login page as a admin
    Then I am on admin login page
    When I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    Then I should be navigated to the admindashboard page
    When I go to the new account request page
    Then I am on new account request page
    When I go to the account holder details page
 #   Then I am on account holder details page
    When I approve the request
    Then I should see approve request success message as Remark has been updated
