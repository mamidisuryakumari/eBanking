package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import com.eBanking.ui.pages.admin.AdminNewAccountRequestPage;

import io.cucumber.java.en.When;

public class AdminNewAccountRequestSteps extends Page {

	private static final Logger logger = LoggerFactory.getLogger(AdminNewAccountRequestSteps.class);

	AdminNewAccountRequestPage adminNewAccountRequestPage = new AdminNewAccountRequestPage();
	AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

	@When("Admin navigate to the admin new account request page")
	public void adminNavigateToTheAdminNewAccountRequestPage() {
		try {
			adminDashBoardPage.adminNavigateToNewAccountRequestPage();
			String actualAdminNewAccountRequestPage = adminNewAccountRequestPage.getAdminNewAccountRequestPage();
			String exceptedAdminNewAccountRequestPage = PropertiesManager
					.getProperty("admin.NewAccountrequest.page.title");
			assertEquals(exceptedAdminNewAccountRequestPage, actualAdminNewAccountRequestPage);
			logger.info("Admin navigate to the admin new account request page successfully");
		} catch (AssertionError ae) {
			logger.error("Assertion failed: Admin New Account Request page title mismatch", ae);
			throw ae;
		} catch (Exception e) {
			logger.error("Exception occurred while navigating to Admin New Account Request page", e);
			throw e;
		}

	}

}
