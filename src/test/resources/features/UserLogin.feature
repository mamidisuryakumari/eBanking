Feature: Login feature

  @UserLogin @happy-path
  Scenario: Verify that the user can log in with valid email address and password
    Given I am on the home page
    When I navigate to login page as a user
    And I log in with valid credentials
      | Email Address | rahul12@gmail.com |
      | Password      | rahul@12          |
    Then I should be navigated to the user dashboard page

    @LoginErrorCases
  Scenario Outline: Validate login with email id and password combinations
    Given I am on the home page
    When I navigate to login page as a user
    When I log in email address "<emailAddress>" and password "<password>"
    Then I should see the message "<expectedMessage>"
    Examples:
      | emailAddress      | password | expectedMessage                                                               |
     #| rahul12@gmail.com | rahul@12 | Dashboard                                                                     |
     | rahulgmail.com    | rahul@12 | Please include an '@' in the email address. 'uesrgmail.com' is missing an '@' |

      #| rahul12@gmail.com | rahul    | Invalid details                                                               |
      #| rahu@gmail.com    | rahul12  | Invalid details                                                               |
      |                     |          | Please fill out this field                                                    |





 


