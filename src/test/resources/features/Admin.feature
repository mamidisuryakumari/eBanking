Feature: Admin login

  @AdminLogin
  Scenario: Verify admin log in with valid email address and password
    Given Admin is on the home page
    When Admin navigate to the admin login page
    And Admin log in with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    Then Admin should be navigated to the admindashboard page

  @AccountApproval
  Scenario: Verify Account Approval
    Given Admin is on the home page
    When Admin navigate to the admin login page
    And Admin log in with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    Then Admin should be navigated to the admindashboard page
    When Admin navigate to the admin new account request page
    And Admin navigated to admin account holder details page
    And Admin approv the request
    Then Admin should see approve request successfully
