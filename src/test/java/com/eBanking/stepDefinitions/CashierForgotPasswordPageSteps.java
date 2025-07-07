package com.eBanking.stepDefinitions;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.cashier.CashierDashboardPage;
import com.eBanking.ui.pages.cashier.CashierForgotPasswordPage;
import com.eBanking.ui.pages.cashier.CashierLoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CashierForgotPasswordPageSteps {

    private TestContext context;
    private CashierLoginPage cashierLoginPage;
    private CashierDashboardPage cashierDashboardPage;
    private CashierForgotPasswordPage cashierForgotPasswordPage;

    public CashierForgotPasswordPageSteps(TestContext context) {
        this.context = context;
        this.cashierDashboardPage = new CashierDashboardPage(context);
        this.cashierForgotPasswordPage = new CashierForgotPasswordPage(context);
        this.cashierLoginPage = new CashierLoginPage(context);
    }

    @When("I go to the cashier forgot Password page")
    public void iGoToTheCashierForgotPasswordPage() {
        try {
            cashierLoginPage.navigateToTheForgotPasswordPage();
            log.info("Navigate to the cashier forgot password page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the forgot password page", e.getMessage());
            throw e;
        }
    }

    @Then("I should be navigated to the cashier forgot password page")
    public void iShouldBeNavigatedToTheCashierForgotPasswordPage() {
        try {
            String actualCashierForgotPasswordText = cashierForgotPasswordPage.getForgotPasswordText();
            String expectedCashierForgotPasswordText = PropertiesManager.getProperty("cashier.forgot.password.text");
            assertEquals(expectedCashierForgotPasswordText, actualCashierForgotPasswordText);
            log.info("Cashier forgot password text is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: Cashier forgot password text is mismatched ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while verifying Cashier forgot password text", e.getMessage());
            throw e;
        }
    }

    @When("I enter cashier forgot password details")
    public void iEnterCashierForgotPasswordDetails(DataTable dataTable) {
        try {
            Map<String, String> cashierForgotPasswordDetails = dataTable.asMap();
            cashierForgotPasswordPage.forgotPassword(cashierForgotPasswordDetails.get("E-mail address"),
                    cashierForgotPasswordDetails.get("Mobile number"),
                    cashierForgotPasswordDetails.get("New Password"),
                    cashierForgotPasswordDetails.get("Confirm Password"));
            log.info("Enter cashier forgot password details successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering cashier forgot password details");
            throw e;
        }
    }

    @Then("I should see cashier Password changed successfully")
    public void iShouldSeeCashierPasswordChangedSuccessfully() {
        try {
            String actualCashierForgotPasswordAlertText = cashierForgotPasswordPage.getCashierForgotPasswordAlertText();
            String expectedCashierForgotPasswordAlertText = PropertiesManager.getProperty("cashier.forgot.password.alert.text");
            assertEquals(expectedCashierForgotPasswordAlertText, actualCashierForgotPasswordAlertText);
            log.info("Cashier forgot password alert text is matched");
            cashierForgotPasswordPage.acceptCashierForgotPasswordAlert();
        } catch (AssertionError e) {
            log.error("Assertion failed:Cashier forgot password alert text is mismatched ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while verifying cashier forgot password alert text", e.getMessage());
            throw e;
        }
    }

    @When("I log in with valid cashier credentials")
    public void iLogInWithValidCashierEmailAddressAndNewPassword(DataTable dataTable) {
        try {
            var cashierDetails = dataTable.asMap();
            cashierLoginPage.loginCashier(cashierDetails.get("EmployeeId"), context.getCashierNewPassword());
            log.info("Cashier log in with email address and new password successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while logging with email address and new password", e.getMessage());
            throw e;
        }
    }

}
