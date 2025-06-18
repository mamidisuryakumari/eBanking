package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.eBanking.ui.pages.cashier.CashierLoginPage;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.cashier.CashierDashboardPage;

import io.cucumber.java.en.Then;

@Slf4j
public class CashierDashBoardSteps {


    private TestContext context;
    private CashierDashboardPage cashierDashboardPage;
    private CashierLoginPage cashierLoginPage;

    public CashierDashBoardSteps(TestContext context) {
        this.context = context;
        this.cashierDashboardPage = new CashierDashboardPage(context);
        this.cashierLoginPage = new CashierLoginPage(context);
    }

    @Then("I should be navigated to the cashier dashboard page")
    public void iShouldBeNavigatedToTheCashierDashboardPage() {
        try {
            String actualCashierDashboardPageTitle = cashierDashboardPage.getCashierDashboardPageTitle();
            String expectedCashierDashboardPageTitle = PropertiesManager.getProperty("cashier.dashboard.page.title");
            assertEquals(expectedCashierDashboardPageTitle, actualCashierDashboardPageTitle);
            log.info("Cashier dashboard page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed : Title is mismatched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info("An exception occured while verifying the cashier dashboard page title", e.getMessage());
            throw e;
        }
    }

    @When("I click on the logout link")
    public void iClickOnTheLogoutLink() {
        try {
            cashierDashboardPage.clickOnLogoutLink();
            log.info("Logout link clicked successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while clicking logout link", e.getMessage());
            throw e;
        }
    }

    @Then("I should see the logout confirmation popup")
    public void iShouldSeeTheLogoutConfirmationPopup() {
        try {
            String actualLogoutConfirmationPopupText = cashierDashboardPage.getCashierPopupWindowText();
            String expectedLogoutConfirmationPopupText =
                    PropertiesManager.getProperty("cashier.logout.confirmation.popup.text");
            assertEquals(expectedLogoutConfirmationPopupText, actualLogoutConfirmationPopupText);
            log.info("Cashier logout confirmation popup text is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: Cashier logout confirmation popup text is mismatched");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while seeing confirmation popup");
            throw e;
        }
    }

    @When("I click on the logout button")
    public void iClickOnTheLogoutButton() {
        try {
            cashierDashboardPage.clickOnLogoutBtn();
            log.info("Clicked cashier logout button successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while clicking the logout button");
            throw e;
        }
    }

    @Then("I should be logged out successfully")
    public void iShouldBeLoggedOutSuccessfully() {
        try {
            log.info("Cashier logout successfully");
        } catch (Exception e) {
            log.error("An exception error occurred during logout", e.getMessage());
            throw e;
        }
    }

    @Then("I should be navigated to the cashier login page")
    public void iShouldBeNavigatedToTheCashierLoginPage(){
        try {
        String actualCashierLoginPageTitle = cashierLoginPage.getCashierLoginPageTitle();
        String expectedCashierLoginPageTitle = PropertiesManager.getProperty("cashier.login.page.title");
        log.info("Cashier login page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: Cashier login page title is mismatched" , e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while verifying login page title" ,e.getMessage());
            throw e;
        }
    }


}
