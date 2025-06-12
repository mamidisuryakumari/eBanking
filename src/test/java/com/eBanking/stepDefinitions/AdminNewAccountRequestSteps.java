package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import com.eBanking.ui.pages.admin.AdminNewAccountRequestPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminNewAccountRequestSteps {

	private TestContext context;
	private  final Logger logger = LoggerFactory.getLogger(AdminNewAccountRequestSteps.class);

	AdminNewAccountRequestPage adminNewAccountRequestPage ;
	AdminDashBoardPage adminDashBoardPage ;
	
	public AdminNewAccountRequestSteps(TestContext context) {
		this.context = context;
		this.adminDashBoardPage = new AdminDashBoardPage(context);
		this.adminNewAccountRequestPage = new AdminNewAccountRequestPage(context);
	}
	
	@When("I go to the new account request page")
	public void iGoToTheNewAccountRequestPage() {
		try {
			adminDashBoardPage.navigateToNewAccountRequestPage();
			logger.info("Navigated to account request page successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while navigating to the account request page" , e.getMessage());
			throw e;
		}
		
		
	}
    @Then("I am on new account request page")
    public void iAmOnNewAccountRequestPage() {
    	try {
			String actualAdminNewAccountRequestPage = adminNewAccountRequestPage.getAdminNewAccountRequestPageTitle();
			String exceptedAdminNewAccountRequestPage = PropertiesManager
					.getProperty("admin.NewAccountrequest.page.title");
			assertEquals(exceptedAdminNewAccountRequestPage, actualAdminNewAccountRequestPage);
			logger.info("Admin navigate to the admin new account request page successfully");
		} catch (AssertionError e) {
			logger.error("Assertion failed: Admin New Account Request page title mismatch", e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error("Exception occurred while navigating to Admin New Account Request page", e);
			throw e;
		}

	}
    }

	