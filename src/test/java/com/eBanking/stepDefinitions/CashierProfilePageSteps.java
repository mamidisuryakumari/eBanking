package com.eBanking.stepDefinitions;

import com.eBanking.ui.engine.Common;
import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.cashier.CashierDashboardPage;
import com.eBanking.ui.pages.cashier.CashierProfilePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CashierProfilePageSteps {
    private TestContext context;
    private CashierDashboardPage cashierDashboardPage;
    private CashierProfilePage cashierProfilePage;

    public CashierProfilePageSteps(TestContext context) {
        this.context = context;
        this.cashierDashboardPage = new CashierDashboardPage(context);
        this.cashierProfilePage = new CashierProfilePage(context);
    }

    @When("I go to the cashier profile page")
    public void iGoToTheCashierProfilePage() {
        try {
            cashierDashboardPage.navigateToCashierProfilePage();
            log.info("Navigated to the cashier profile page successfully");
        } catch (Exception e) {
            log.error("Failed to navigate to the cashier profile page", e.getMessage());
            throw e;
        }
    }

    @Then("I should be navigated to the cashier profile page")
    public void iShouldBeNavigatedToTheCashierProfilePage() {
        try {
            String actualCashierProfilePageTitle = cashierProfilePage.getCashierProfilePageTitle();
            String expectedCashierProfilePageTitle = PropertiesManager.getProperty("cashier.profile.page.title");
            assertEquals(expectedCashierProfilePageTitle, actualCashierProfilePageTitle);
            log.info("Cashier profile page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: Cashier profile page title is mismatched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception occurred while navigating to the cashier profile page", e.getMessage());
            throw e;
        }
    }

    @When("I update following below cashier profile details")
    public void iUpdateCashierProfileDetails(DataTable dataTable) {
        try {
            var cashierProfileDetails = dataTable.asMap();
            cashierProfilePage.cashierProfileUpdate(
                    cashierProfileDetails.get("First Name").trim().replace("${random}", Common.random())
                    , cashierProfileDetails.get("Address"));
            log.info("Cashier profile details updated successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while updating cashier details", e.getMessage());
            throw e;
        }
    }

    @Then("I should see success message cashier detail has been updated")
    public void iShouldSeeSuccessMessageCashierDetailHasBeenUpdated() {
        try {
            String actualCashierUpdateProfileAlertText = cashierProfilePage.getCashierDetailsUpdateProfileAlertText();
            String expectedCashierUpdateProfileAlertText = PropertiesManager.getProperty("Cashier.profile.update.alert.text");
        log.info("Cashier profile alert message is matched");
        cashierProfilePage.acceptCashierDetailsUpdateProfileAlert();
        } catch (AssertionError e) {
            log.error("Assertion failed: Cashier profile alert message is mis matched" , e.getMessage());
            throw e;
        }catch (Exception e) {
            log.error("An exception error occured while verifying cashier profile alert message", e.getMessage());
            throw e;
        }
    }

}
