package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.CashierDetailsPage;
import com.eBanking.ui.pages.admin.CashierUpdateDetailsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
@Slf4j
public class CashierUpdateDetailsSteps {
	
	private TestContext context;
	private CashierUpdateDetailsPage cashierUpdateDetailsPage;
	private CashierDetailsPage cashierDetailsPage;
	
	public CashierUpdateDetailsSteps(TestContext context) {
		this.context = context;
		this.cashierUpdateDetailsPage = new CashierUpdateDetailsPage(context);
		this.cashierDetailsPage = new CashierDetailsPage(context);
	}
	
	 @When("I navigate to the cashier update details page")
	 public void iNavigateToTheCashierUpdateDetailsPage() {
		 try {
			cashierDetailsPage.navigateToupdateCashierDetailsPage();
			log.info("Navigated to the cashier update details page successfully");
		} catch (Exception e) {
			 log.error("An exception error occured while navigating to the cashier update details page" , e.getMessage());
			throw e;
		}
	 }
	   @Then("I should be on the cashier update details page")
	   public void iShouldBeOnTheCashierUpdateDetailsPage() {
		  try {
			String actualCashierUpdateDetailsText = cashierUpdateDetailsPage.getUpdateCashiertext();
			String expectedCashierUpdateDetailsText = PropertiesManager.getProperty("cashier.update.details.text");
			assertEquals(expectedCashierUpdateDetailsText, actualCashierUpdateDetailsText);
			  log.info("Cashier update details text is matched");
		}catch (AssertionError e) {
			  log.error("Assertion failed: Cashier update details text is mismatched" , e.getMessage());
			throw e;
		} catch (Exception e) {
			  log.error("An exception error occured while verifying the cashier update details text", e.getMessage());
			throw e;
		} 
	   }
	   @When("I update the cashier details")
	   public void iUpdateTheCashierDetails() {
		   try {
			cashierUpdateDetailsPage.updateCashierDetails();
			   log.info("Cashier details updated successfully");
		} catch (Exception e) {
			   log.error("An exceptio error occured while updating cashier details" ,e.getMessage());
			throw e;
		}
		   
	   }
	   @Then("I should see a confirmation message that the cashier details updated successfully")
	   public void iShouldSeeConfirmationMessageThatTheCashierDetailsUpdatedSuccessfully() {
		   try {
			String actualCashierDetailsUpdatedMsg = cashierUpdateDetailsPage.getCashierUpdateDetailstextAlert();
			String expectedCashierDetailsUpdatedMsg = PropertiesManager.getProperty("cashier.update.alert.msg");
			assertEquals(expectedCashierDetailsUpdatedMsg, actualCashierDetailsUpdatedMsg);
			   log.info("Cashier update details message is matched");
			cashierDetailsPage.acceptCashierDeleteAlertMsg();
		} catch (AssertionError e) {
			   log.error("Assertion failed:Cashier update details message is mismatched", e.getMessage());
			throw e;
		}catch (Exception e) {
			   log.error("An exception error occured while verifying update details message" , e.getMessage());
			throw e;
		}
	   }

}
