package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.user.ManagePayeePage;
import com.eBanking.ui.pages.user.UserDashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
@Slf4j
public class ManagePayeeSteps {

	private TestContext context;
	UserDashboardPage userDashboardPage;
	ManagePayeePage managePayeePage;
	
	public ManagePayeeSteps(TestContext context) {
		this.context = context;
		this.userDashboardPage = new UserDashboardPage(context);
		this.managePayeePage = new ManagePayeePage(context);
	}
	
	@When("I go to manage payee page")
	public void managePayee() {
		try {
			userDashboardPage.navigatedToManagePayee();
			managePayeePage.managePayeeAccountHolderList();
			log.info("Navigate to manage payee page successfully");
		} catch (Exception e) {
			log.error("An exception error occured while navigating to manage payee page", e);
			throw e;
		}

	}

	@When("I deletes the payee details")
	public void deletePayee() {
		try {
			managePayeePage.searchPayeeName(PropertiesManager.getProperty("MoneyTransferToPayee"))
			.deletePayee();
			log.info("Delete payee details successfully");
		} catch (Exception e) {
			log.error("An exception error occured while delete payee details", e);
			throw e;
		}
	}

	@Then("I should see the data deleted successfully")
	public void iShouldSeeTheDataDeletedSuccessfully() {
		try {
			String actualDeleteSuccessMsg = managePayeePage.deleteSuccessMsg();
			String exceptedDeleteSuccessMsg = PropertiesManager.getProperty("deletePayee.success.msg");
			assertEquals(exceptedDeleteSuccessMsg, actualDeleteSuccessMsg);
			log.info("Data deleted successfully");
			managePayeePage.acceptdeleteMsg();
		} catch (AssertionError ae) {
			log.error("Assertion failed : verify delete success message", ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception error occured while verifying delete success message", e);
			throw e;
		}
	}

@Then("I should be navigated to the user manage payee page")
	public void iShouldBeNavigatedToTheUserManagePayeePage() {
	try {
		String actualManagePayeeText = managePayeePage.getManagePayeeText();
		String exceptedManagePayeeText = PropertiesManager.getProperty("managePayee.text");
		assertEquals(exceptedManagePayeeText, actualManagePayeeText);
		log.info("Manage payee text is matched");
	} catch (AssertionError ae) {
		log.error("Assertion failed: manage payee text is mismatched", ae);
		throw ae;
	} catch (Exception e) {
		log.error("An exception error occured while navigating to the manage payee page");
		throw  e;
	}
}

}
