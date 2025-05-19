package com.eBanking.stepDefinitions;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.user.ManagePayeePage;
import com.eBanking.ui.pages.user.TransferAmountPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferAmountSteps extends Page{
	
	private static Logger logger = LoggerFactory.getLogger(TransferAmountSteps.class);
	ManagePayeePage managePayeePage = new ManagePayeePage();
	TransferAmountPage transferAmountPage = new TransferAmountPage();
	
	
	@When("I go to the transfer amount page")
	public void iGoToTheTransferAmountPage() {
		try {
			managePayeePage.searchPayeeName(PropertiesManager.getProperty("MoneyTransferToPayee"))
			.iNavigatedToTranferAmountPage();
			String actualTransferAmountText = transferAmountPage.getTransferAmountText();
			String exceptedTransferAmountText = PropertiesManager.getProperty("transferAmount.text");
			assertEquals(exceptedTransferAmountText, actualTransferAmountText);
			logger.info("Tranfer amount text is matched");
		}catch (AssertionError ae) {
			logger.error("Assertion failed : transfer amount text is mismatched" , ae);
		}catch (Exception e) {
			logger.error("An exception error occured while verifying transfer amount text" ,e);
		}
		
	}
	
	@When("I money transfers to the payee's account")
	public void moneyTranferToPayeeAccount() {
		try {
			transferAmountPage.trasferAmount(PropertiesManager.getProperty("transferAmount"));
			logger.info("Money transfer to the payees account successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while transfer money to payee account" , e);
			throw e;
		}
	}
    @Then("I should see the Transaction details have been updated successfully")
    public void iShouldSeeTheTransactionDetailsUpdatedSuccessfully() {
    	try {
			String actualTransactionUpadtedSuccessMsg = transferAmountPage.getTransferamountalertMsg();
			String exceptedTransactionUpadtedSuccessMsg = PropertiesManager.getProperty("transferAmount.success.msg");
			assertEquals(exceptedTransactionUpadtedSuccessMsg, actualTransactionUpadtedSuccessMsg);
			logger.info("Transaction updated message is matched");
			transferAmountPage.acceptTransactionDetails();
		}catch (AssertionError ae) {
			logger.error("Assertion failed: Transaction updated message is mismatched" , ae);
			throw ae;
		} catch (Exception e) {
			logger.error("An exception error occured while verifying transaction updated alert message" ,e);
			throw e;
		}
    }

}
