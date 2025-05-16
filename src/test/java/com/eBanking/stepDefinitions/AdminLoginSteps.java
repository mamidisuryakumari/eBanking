package com.eBanking.stepDefinitions;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;


import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.HomePage;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.admin.AdminLoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminLoginSteps extends Page {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginSteps.class);
	
	AdminLoginPage adminLoginPage = new AdminLoginPage();
	HomePage homePage = new HomePage();
	
	
	@Then("Admin navigate to the admin login page")
	public void admin_should_be_navigated_to_login_page() {
		try {
			homePage.iNavigatedToAdminLoginPage();
			String actualAdminDashBoardPageTitle = adminLoginPage.getAdminLoginPageTitle();
			String exceptedAdminDashBoardPageTitle = PropertiesManager.getProperty("admin.Loginpage.title");
			assertEquals(exceptedAdminDashBoardPageTitle, actualAdminDashBoardPageTitle);
			logger.info("Admin login page title is matched");
		} catch (AssertionError ae) {
			logger.error("Assertion failed: Admin login page title mismatch", ae);
			throw ae;
		} catch (Exception e) {
			logger.error("An exception occured while navigating to admin login page");
			throw e;
		}
	}
	
	@When("Admin log in with valid credentials")
	public void admin_log_in_with_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
		try {
			 var adminUserDetails = dataTable.asMap();
			   adminLoginPage.adminLogin(adminUserDetails.get("Email Address"),
					   adminUserDetails.get("Password"));
			   logger.info("Admin logged successfully");
			   } catch (Exception e) {
			logger.error("An unexcepted error occured while login the application", e);
			throw e;
		}
	  
	}

}
