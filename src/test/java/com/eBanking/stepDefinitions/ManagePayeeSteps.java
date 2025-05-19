package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.user.ManagePayeePage;
import com.eBanking.ui.pages.user.UserDashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagePayeeSteps extends Page {

	private static Logger logger = LoggerFactory.getLogger(ManagePayeeSteps.class);
	UserDashboardPage userDashboardPage = new UserDashboardPage();
	ManagePayeePage managePayeePage = new ManagePayeePage();
	
	
	@When("I go to manage payee page")
	public void managePayee() {
		try {
			userDashboardPage.iNavigatedToManagePayee();

			String actualManagePayeeText = managePayeePage.getManagePayeeText();
			String exceptedManagePayeeText = PropertiesManager.getProperty("managePayee.text");
			assertEquals(exceptedManagePayeeText, actualManagePayeeText);
			logger.info("Manage payee text is matched");
		} catch (AssertionError ae) {
			logger.error("Assertion failed: manage payee text is mismatched", ae);
			throw ae;
		} catch (Exception e) {
			logger.error("An exception error occured while navigating to manage payee page", e);
			throw e;
		}

	}

	@When("I deletes the payee details")
	public void deletePayee() {
		try {
			managePayeePage.searchPayeeName(PropertiesManager.getProperty("MoneyTransferToPayee"))
			.deletePayee();
			logger.info("Delete payee details successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while delete payee details", e);
			throw e;
		}
	}

	@Then("I should see the data deleted successfully")
	public void iShouldSeeTheDataDeletedSuccessfully() {
		try {
			String actualDeleteSuccessMsg = managePayeePage.deleteSuccessMsg();
			String exceptedDeleteSuccessMsg = PropertiesManager.getProperty("deletePayee.success.msg");
			assertEquals(exceptedDeleteSuccessMsg, actualDeleteSuccessMsg);
			logger.info("Data deleted successfully");
			managePayeePage.acceptdeleteMsg();
		} catch (AssertionError ae) {
			logger.error("Assertion failed : verify delete success message", ae);
			throw ae;
		} catch (Exception e) {
			logger.error("An exception error occured while verifying delete success message", e);
			throw e;
		}
	}
}
