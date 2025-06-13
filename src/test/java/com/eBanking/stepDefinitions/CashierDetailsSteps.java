package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import com.eBanking.ui.pages.admin.CashierDetailsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Slf4j
public class CashierDetailsSteps {


    private final TestContext context;
    private AdminDashBoardPage adminDashBoardPage;
    private CashierDetailsPage cashierDetailsPage;

    public CashierDetailsSteps(TestContext context) {
        this.context = context;
        this.adminDashBoardPage = new AdminDashBoardPage(context);
        this.cashierDetailsPage = new CashierDetailsPage(context);
    }

    @When("I navigate to the cashier details page")
    public void iNavigateToTheCashierDetailsPage() {
        try {
            adminDashBoardPage.navigateToCashierDetailsPage();
            log.info("Navigated to the cashier details apge successfully");
        } catch (Exception e) {
            log.error("An exception error occured while navigatinh to the cashier details page", e.getMessage());
            throw e;
        }
    }

    @Then("I should be on the cashier details page")
    public void iShouldBeOnTheCashierDetailsPage() {
        try {
            String actualCashierDetailsText = cashierDetailsPage.getDetailsCashierText();
            String expectedCashierDetailsText = PropertiesManager.getProperty("cashier.details.text");
            assertEquals(expectedCashierDetailsText, actualCashierDetailsText);
            log.info("Cashier details text is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: cashier details text is mismatched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while verifying cashier details page text", e.getMessage());
            throw e;
        }
    }

    @When("I delete the cashier")
    public void iDeleteTheCashier() {
        try {
            cashierDetailsPage.deleteCashier();
            log.info("Cashier deleted successfully");
        } catch (Exception e) {
            log.error("An exception error occured while deleting the cashier", e.getMessage());
            throw e;
        }
    }

    @Then("I should see a confirmation message that the cashier was deleted successfully")
    public void iShouldSeeConfirmationMessage() {
        try {
            String actualCashierdeleteAlerMsg = cashierDetailsPage.getCashierDeleteAlertMsg();
            String expectedCashierdeleteAlerMsg = PropertiesManager.getProperty("delete.cashier.alert.msg");
            assertEquals(expectedCashierdeleteAlerMsg, actualCashierdeleteAlerMsg);
            log.info("Cashier delete alert message is matched");
            cashierDetailsPage.acceptCashierDeleteAlertMsg();
        } catch (AssertionError e) {
            log.error("Assertion failed : cashier delete alert message is matched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while seeing cashier alert message", e.getMessage());
            throw e;
        }
    }

    @When("I search the cashier")
    public void iSearchTheCashier() {
        try {
            cashierDetailsPage.searchCashier();
            log.info("Cashier search parformed successfully");
        } catch (Exception e) {
            log.error("An error occured while searching the cashier",e.getMessage());
            throw e;
        }
    }

    @Then("I should see No matching records found")
    public void iShouldSeeNoMatchingRecordsFound() {
        try {
            String actualText = cashierDetailsPage.getNoMatchingRecordText();
            String expectedText = "No matching records found";
            assertEquals(expectedText, actualText);
        } catch (AssertionError e) {
            log.error("Assertion failed");
            throw e;
        }catch (Exception e) {
            log.error("An error occurred while verifying the 'No matching records found' message", e.getMessage());
            throw e;
        }
    }

}
