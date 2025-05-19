package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.user.ManagePayeePage;
import com.eBanking.ui.pages.user.UserTransactionHistoryPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserTransactionHistory {
	
	private static final Logger logger = LoggerFactory.getLogger(UserTransactionHistory.class);
	
	ManagePayeePage managePayeePage = new ManagePayeePage();
	UserTransactionHistoryPage userTransactionHistoryPage = new UserTransactionHistoryPage();
	
	 @When("I go to transaction history page")
	 public void iGoToTransactionHistoryPage() {
		 try {
		managePayeePage.iNavigatedToTransactionHistoryPage();
		String actualTransactionHistoryText = userTransactionHistoryPage.getTransactionHistoryText();
		String exceptedTransactionHistoryText = PropertiesManager.getProperty("transactionHistory.page.title");
		assertEquals(exceptedTransactionHistoryText, actualTransactionHistoryText);
		logger.info("Transaction history text is matched");
		} catch (AssertionError ae) {
			logger.error("Assertion failed:transaction history text is mismatched" ,ae);
			throw ae;
		}catch (Exception e) {
			logger.error("An exception error occured while verifying transaction history text");
			throw e;
		}
	 }
	 
	 @Then("I should see money debited from the user account")
	 public void iShouldSeeMoneyDebitedFromTheUserAccount() {
	     try {
	         String transactionStatus = userTransactionHistoryPage.getLatestTransactionStatus(); 
	         String expectedStatus = PropertiesManager.getProperty("exceptedTransaction.status");
	         assertEquals(expectedStatus, transactionStatus);
	         logger.info("Money has been successfully debited from the user account.");
	     } catch (AssertionError ae) {
		logger.error("Assertion failed: transaction status is metched" ,ae);
		throw ae;
		}catch (Exception e) {
	         logger.error("An exception error occured while verify money debit transaction", e);
	         throw e;
	        
	     }
	 }


}
