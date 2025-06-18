package com.eBanking.stepDefinitions;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.cashier.CashierChangePasswordPage;
import com.eBanking.ui.pages.cashier.CashierDashboardPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CashierChangePasswordSteps {
    private TestContext context;
    private CashierDashboardPage cashierDashboardPage;
    private CashierChangePasswordPage cashierChangePasswordPage;

    public CashierChangePasswordSteps(TestContext context) {
        this.context = context;
        this.cashierDashboardPage = new CashierDashboardPage(context);
        this.cashierChangePasswordPage = new CashierChangePasswordPage(context);
    }

    @When("I go to the cashier change password page")
    public void iGoToTheCashierChangePasswordPage() {
        try {
            cashierDashboardPage.navigateToCashierChangePasswordPage();
            log.info("Navigated to cashier password page successfully");
        } catch (Exception e) {
            log.error("Failed to navigate to cashier password page", e.getMessage());
            throw e;
        }
    }

    @Then("I should be navigated to the cashier change password page")
    public void iShouldBeNavigatedToTheCashierChangePasswordPage() {
        try {
            String actualCashierPasswordPageTitle = cashierChangePasswordPage.getCashierChangePasswordPageTitle();
            String expectedCashierPasswordPageTitle = PropertiesManager.getProperty("cashier.change.password.page.title");
            assertEquals(expectedCashierPasswordPageTitle, actualCashierPasswordPageTitle);
            log.info("Cashier password page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: Cashier password page title is mismatched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the cashier change password page", e.getMessage());
            throw e;
        }
    }

    @When("I change the cashier password with the following details")
    public void ChangeCashierPassword(DataTable dataTable) {
        try {
            var changePasswordDetails = dataTable.asMap();
            cashierChangePasswordPage.cashierChangePassword(context.getCashierPassword(),
                    changePasswordDetails.get("New Password"),
                    changePasswordDetails.get("Confirm Password"));
            log.info("Change password details entered successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering change password details", e.getMessage());
            throw e;
        }
    }

    @Then("I should see success message Your password successfully changed")
    public void iShouldSeeSuccessMessage() {
        try {
            String actualChangePasswordAlertText = cashierChangePasswordPage.getChangePasswordAlertText();
            String expectedChangePasswordAlertText = PropertiesManager.getProperty("Cashier.change.password.alert.text");
            assertEquals(expectedChangePasswordAlertText, actualChangePasswordAlertText);
            log.info("Cashier change password text is matched");
            cashierChangePasswordPage.acceptChangePasswordAlert();
        } catch (AssertionError e) {
            log.error("Assertion failed: cashier change password text is mismatched ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while seeing cashier change password text");
            throw e;
        }
    }
}
