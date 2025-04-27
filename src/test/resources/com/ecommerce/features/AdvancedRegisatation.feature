Feature: Advanced registration form

@registerform
  Scenario: Verify advanced registration form  
  Given I am on advanced registration form page
    When I add below values in advanced registration form
      | FieldName | Value                   |
      | UserName  | Surya                   |
      | Password  | kumari@123              |
      | Email     | kumari.mudila@gmail.com |
    And I click on register button
    Then I should see registration successfull pop up message