package com.eBanking.stepDefinitions;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.cashier.CashierAccountHolderDetailsPage;
import com.eBanking.ui.pages.cashier.CashierDashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;


import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j

public class CashierAccountHolderDetailsPageSteps {
    private TestContext context;
    private CashierDashboardPage cashierDashboardPage;
    private CashierAccountHolderDetailsPage cashierAccountHolderDetailsPage;

    public CashierAccountHolderDetailsPageSteps(TestContext context) {
        this.context = context;
        this.cashierDashboardPage = new CashierDashboardPage(context);
        this.cashierAccountHolderDetailsPage = new CashierAccountHolderDetailsPage(context);
    }

    @When("I go to the cashier account holder details page")
    public void iGoToTheCashierAccountHolderDetailsPage() {
        try {
            cashierDashboardPage.navigatedToTheAccountHolderDetailsPage();
            log.info("Navigated to the account holder details page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the account holder details page", e.getMessage());
            throw e;
        }
    }

    @Then("I should be navigated to the cashier account holder details page")
    public void iShouldBeNavigatedToTheCashierAccountHolderDetailsPage() {
try{
    String actualCashierAccountHolderDetailsPageTitle = cashierAccountHolderDetailsPage.getCashierAccountHolderDetailsPageTitle();
    String expectedCashierAccountHolderDetailsPageTitle = PropertiesManager.getProperty("Cashier.AccountHolder.Details.page.Title");
    assertEquals(actualCashierAccountHolderDetailsPageTitle, expectedCashierAccountHolderDetailsPageTitle);
    log.info("Cashier account holder details page title is matched");
} catch (AssertionError e) {
    log.error("Cashier account holder details page title is mismatched" , e.getMessage());
    throw  e;
} catch (Exception e) {
   log.error("An exception error occurred while verifying the cashier account holder details page title", e.getMessage());
   throw  e;
}}

    @When("I search for the user account")
    public void iSearchForTheUserAccount() {
try {
    cashierAccountHolderDetailsPage.searchUserAccount();
    log.info("User account searched successfully");
} catch (Exception e) {
    log.error("An exception error occurred while searching the user account", e.getMessage());
    e.getMessage();
}
    }
}
