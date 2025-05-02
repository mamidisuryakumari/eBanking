package com.eBanking.stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.AdminLoginPage;

import io.cucumber.java.en.When;

public class AdminLoginSteps {
	
	WebDriver driver = Hooks.getDriver();
	AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
	Logger log = LoggerFactory.getLogger(AdminLoginSteps.class);
	
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
