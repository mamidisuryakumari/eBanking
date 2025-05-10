package com.eBanking.stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.ui.pages.admin.AdminLoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminLoginSteps {
	
	WebDriver driver = Hooks.getDriver();
	AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
	Logger log = LoggerFactory.getLogger(AdminLoginSteps.class);
	
	@Then("Admin should be navigated to login page")
	public void admin_should_be_navigated_to_login_page() {
		try {
			boolean result = adminLoginPage.isOnAdminLoginPage();
			Assert.assertTrue(result);
			log.info("Admin login page title is matched");
		} catch (AssertionError ae) {
			log.error("Assert is failed", ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception occured while navigating to admin login page");
			throw e;
		}
	}
	
	@When("Admin log in with valid credentials")
	public void admin_log_in_with_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
		try {
			 Map<String, String> adminUserDetails = dataTable.asMap();
			   adminLoginPage.adminLogin(adminUserDetails.get("Email Address"),
					   adminUserDetails.get("Password"));
			   log.info("Admin logged successfully");
			   } catch (Exception e) {
			log.error("An unexcepted error occured while login the application", e);
			throw e;
		}
	  
	}

}
