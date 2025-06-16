package com.eBanking.stepDefinitions;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.cashier.CashierAccountHolderDetailsPage;
import com.eBanking.ui.pages.cashier.CashierUserDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CashierUserDetailsPageSteps {
    private TestContext context;
    private CashierAccountHolderDetailsPage cashierAccountHolderDetailsPage;
    private CashierUserDetailsPage cashierUserDetailsPage;


    public CashierUserDetailsPageSteps(TestContext context) {
        this.context = context;
        this.cashierUserDetailsPage = new CashierUserDetailsPage(context);
        this.cashierAccountHolderDetailsPage = new CashierAccountHolderDetailsPage(context);
    }

    @When("I go the cashier user details page")
    public void iGoTheCashierUserDetailsPage() {
        try {
            cashierAccountHolderDetailsPage.navigateToCashierUserDetailsPage();
            log.info("Navigated to cashier user details page successfully");
        } catch (Exception e) {
            log.error("An exception error occured while navigating to the cashier user details page", e.getMessage());
            throw e;
        }
    }

    @Then("I should be navigated to the cashier user details page")
    public void iShouldBeNavigatedToTheCashierDetailsOfUserPage() {
        try {
            String actualCashierUserDetailsText = cashierUserDetailsPage.getUserDetailsText();
            String expectedCashierUserDetailsText = PropertiesManager.getProperty("cashier.user.details.text");
            assertEquals(actualCashierUserDetailsText, expectedCashierUserDetailsText);
            log.info("Cashier user details text is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: Cashier user details text is mismatched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the cashier details page", e.getMessage());
            throw e;
        }
    }

    @When("I click on deposit button")
    public void iClickOnDepositButton() {
        try {
            cashierUserDetailsPage.clickOnDepositBtn();
            log.info("Deposit button clicked successfully");
        } catch (Exception e) {
            log.error("An exception error occured while clicking the deposit button", e.getMessage());
            throw e;
        }
    }

    @Then("I should see cashier 'Take Action' model window popup opened")
    public void iShouldSeeCashierTakeActionModelPopupOpened() {
        try {
            String actualTakeActionPopupWindowText = cashierUserDetailsPage.getTakeActionPopupWindowText();
            String expectedTakeActionPopupWindowText =PropertiesManager.getProperty("cashier.take.action.popup.window.text");
            assertEquals(actualTakeActionPopupWindowText, expectedTakeActionPopupWindowText);
            log.info("Cashier take action popup window title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: Cashier take action popup window title is mis matched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while seeing popup window", e.getMessage());
            throw e;
        }
    }

    @When("I enter the amount and select the transaction type")
    public void iEnterTheAmountAndSelectTheTransactionType() {
        try {
            cashierUserDetailsPage.enterAmountAndSelectTransactionType(PropertiesManager.getProperty("deposit.amount"),
                    PropertiesManager.getProperty("transaction.type.value"));
            log.info("Entered amount ans select transaction type successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering amount", e.getMessage());
            throw e;
        }
    }

    @Then("I should see the success message as Transaction done successfully")
    public void iShouldSeeTheTransactionDoneSuccessfully() {
        try {
            String actualTransactionSuccessMsg = cashierUserDetailsPage.getTransactionSuccessAlertMsg();
            String expectedTransactionSuccessMsg = PropertiesManager.getProperty("Transaction.success.msg");
            assertEquals(actualTransactionSuccessMsg, expectedTransactionSuccessMsg);
            log.info("Transaction message is matched");
            cashierUserDetailsPage.acceptTransactionSuccessAlertMsg();
        } catch (AssertionError e) {
            log.error("Assertion failed: transaction message is mis matched ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing transaction success message", e.getMessage());
            throw e;
        }
    }

    @When("I click on withdrawal button")
    public void iClickOnWithdrawalButton(){
try{
    cashierUserDetailsPage.clickOnWithdrawalBtn();
    log.info("Withdrawal button clicked successfully");
} catch (Exception e) {
    log.error("An exception error occured while clicking withdrawal button" , e.getMessage());
    throw  e;
}
    }
    @Then("I should see cashier withdrawal 'Take Action' model window popup opened")
    public void iShouldSeeCashierWithdrawalTakeActionModelPopupOpened() {
        try {
            String actualTakeActionPopupWindowText = cashierUserDetailsPage.getWithdrawalTakeActionPopupWindowText();
            String expectedTakeActionPopupWindowText = PropertiesManager.getProperty("cashier.take.action.popup.window.text");
            assertEquals(actualTakeActionPopupWindowText, expectedTakeActionPopupWindowText);
            log.info("Cashier take action popup window title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: Cashier take action popup window title is mis matched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while seeing popup window", e.getMessage());
            throw e;
        }
    }
    @When("I enter the withdrawal amount")
    public void iEnterTheAmount(){
try {
    cashierUserDetailsPage.enterWithdrawalAmount(PropertiesManager.getProperty("withdrawal.amount"));
    log.info("Entered withdrawal amonut successfully");
} catch (Exception e) {
log.error("An exception error occured while entering withdrawal amount" ,e.getMessage());
throw  e;
}
    }

}
