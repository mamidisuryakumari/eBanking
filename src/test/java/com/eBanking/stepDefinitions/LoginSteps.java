package com.eBanking.stepDefinitions;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.HomePage;
import com.eBanking.pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver = Hooks.getDriver();
	Logger log = LoggerFactory.getLogger(LoginSteps.class);
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);

	@When("User log in with valid credentials")
	public void user_logs_in_with_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
		try {
			homePage.clickOnUserMenu();
			Map<String, String> loginDetails = dataTable.asMap();
			loginPage.loginUser(loginDetails.get("Email Address"), (loginDetails.get("Password")));
			log.info("User logged successfully");
		} catch (Exception e) {
			log.error("An unexcepted error occured while login the application", e);
			throw e;
		}

	}

	

}
