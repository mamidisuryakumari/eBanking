Feature: Admin login
@AdminLogin
  Scenario: Verify admin log in with valid email address and password
    Given Admin is on the home page
    When Admin click on admin menu
    Then Admin should be navigated to login page
    When Admin log in with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    Then Admin should be navigated to admindashboard page
 @AccountApproval   
 Scenario: Verify Account Approval
  Given Admin is on the home page
    When Admin click on admin menu
    Then Admin should be navigated to login page
    When Admin log in with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    Then Admin should be navigated to admindashboard page
    When Admin click on new account request menu
    Then Admin should be navigated to admin page
    When Admin approv the request
    Then Admin should see approve request successful message