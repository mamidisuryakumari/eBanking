package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.admin.AdminAccountholderDetailsPage;
import com.eBanking.ui.pages.admin.AdminNewAccountRequestPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminAccountholderDetailsSteps extends Page {

	private static Logger logger = LoggerFactory.getLogger(AdminAccountholderDetailsSteps.class);

	AdminNewAccountRequestPage adminNewAccountRequestPage = new AdminNewAccountRequestPage();
	AdminAccountholderDetailsPage adminAccountholderDetailsPage = new AdminAccountholderDetailsPage();

	@When("Admin navigated to admin account holder details page")
	public void adminNavigateToAdminAccountHolderDetailsPage() {
		try {
			adminNewAccountRequestPage.adminNavigateToAccountHolderDetailsPage();
			String actualAdminAccountholderDetailsPageTitle = adminAccountholderDetailsPage
					.getAdminAccountholderDetailsPage();
			String exceptedAdminAccountholderDetailsPageTitle = PropertiesManager
					.getProperty("admin.AccountHolderDetails.page.title");
			assertEquals(exceptedAdminAccountholderDetailsPageTitle, actualAdminAccountholderDetailsPageTitle);
			logger.info("Admin navigated to adimn holder details page successfully");
		} catch (AssertionError ae) {
			logger.error("Assertion failed : admin account holder details page title is mismatched");
		} catch (Exception e) {
			logger.error("An exception error occured while navigating to admin account holder details page");
		}
	}
	
	@When("Admin approv the request")
	public void adminApprovTheRequest() {
		try {
			adminAccountholderDetailsPage.accountApproval();
			logger.info("Account approved successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while admin approve the request" , e);
			throw e;
		}
	}
	
	@Then("Admin should see approve request successfully")
	public void adminShouldSeeApproveRequestSuccessfully() {
		try {
			String actualApproveRequestMessage = bot.getAlertMessage();
			String exceptedApproveRequestMessage = PropertiesManager.getProperty("admin.ApproveRequest.Message");
			assertEquals(exceptedApproveRequestMessage, actualApproveRequestMessage);
			logger.info("Approve request message is matched");
			bot.acceptAlert();
		} catch (AssertionError  ae) {
			logger.error("Assertion filed : approve request message is mismatched" , ae);
			throw ae;
		}catch (Exception e) {
			logger.error("An exception error occured while verifying the approve request message" , e);
			throw e;
		}
	}

}
