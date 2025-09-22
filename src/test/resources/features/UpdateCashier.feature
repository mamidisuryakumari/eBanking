Feature: Update cashier

  Background: 
    Given I am on the home page
    And I go to the admin login page
    And I am on admin login page
    And I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    And I should be navigated to the admin dashboard page

  @UpdateCashier1 @happy-path @Regression @Regression
  Scenario: Verify that admin can update the cashier details
    When I navigate to the cashier details page
    Then I should be on the cashier details page
    When I navigate to the cashier update details page
    Then I should be on the cashier update details page
    When I update the cashier details
    Then I should see a confirmation message that the cashier details updated successfully
