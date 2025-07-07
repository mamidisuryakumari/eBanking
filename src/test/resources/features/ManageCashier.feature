Feature: Manage Cashier

  Background:
    Given I am on the home page
    And I go to the admin login page
    And I am on admin login page
    And I log in to admin with valid credentials
      | Email Address | admin@gmail.com |
      | Password      | admin123        |
    And I should be navigated to the admin dashboard page

  @AddCashier @happy-path
  Scenario: Verify that admin can add a cashier
    When I navigate to the add cashier page
    Then I should be on the add cashier page
    When I add the following cashier details
      | First Name    | Dhanya_${random}           |
      | Last Name     | M                          |
      | Mobile Number | ${random}                  |
      | Email         | dhanya_${random}@gmail.com |
      | Date of Birth | 17031990                   |
      | Emp ID        | cashier_${random}          |
      | Address       | D.no-2-2-1, Nandivada      |
      | Password      | cashier128                 |
    Then I should see a confirmation message that the cashier was added successfully

  @AddAndDeleteCashier @happy-path
  Scenario: Verify that admin can delete a cashier
    When I navigate to the add cashier page
    Then I should be on the add cashier page
    When I add the following cashier details
      | First Name    | Dhanya_${random}           |
      | Last Name     | M                          |
      | Mobile Number | ${random}                  |
      | Email         | dhanya_${random}@gmail.com |
      | Date of Birth | 17031990                   |
      | Emp ID        | cashier_${random}          |
      | Address       | D.no-2-2-1, Nandivada      |
      | Password      | cashier128                 |
    Then I should see a confirmation message that the cashier was added successfully
    When I go to admin dashboard page
    Then I should be navigated to the admin dashboard page
    When I navigate to the cashier details page
    Then I should be on the cashier details page
    When I delete the cashier
    Then I should see a confirmation message that the cashier was deleted successfully
    When I search the cashier
    Then I should see No matching records found

  @updateCashier
  Scenario: Verify that admin can upadate the cashier details
    When I navigate to the add cashier page
    Then I should be on the add cashier page
    When I add the following cashier details
      | First Name    | Dhanya_${random}           |
      | Last Name     | M                          |
      | Mobile Number | ${random}                  |
      | Email         | dhanya_${random}@gmail.com |
      | Date of Birth | 17031990                   |
      | Emp ID        | cashier_${random}          |
      | Address       | D.no-2-2-1, Nandivada      |
      | Password      | cashier128                 |
    Then I should see a confirmation message that the cashier was added successfully
    When I go to admin dashboard page
    Then I should be navigated to the admin dashboard page
    When I navigate to the cashier details page
    Then I should be on the cashier details page
    When I navigate to the cashier update details page
    Then I should be on the cashier update details page
    When I update the cashier details
    Then I should see a confirmation message that the cashier details updated successfully

