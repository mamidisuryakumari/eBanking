package com.eBanking.stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.AdminLoginPage;
import com.eBanking.pages.HomePage;
import com.eBanking.pages.UserLoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginSteps {

	WebDriver driver = Hooks.getDriver();
	Logger log = LoggerFactory.getLogger(UserLoginSteps.class);
	UserLoginPage userLoginPage = new UserLoginPage(driver);
	HomePage homePage = new HomePage(driver);
	AdminLoginPage adminLoginPage = new AdminLoginPage(driver);

	@When("the user log in with valid credentials")
	public void user_logs_in_with_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
		try {

			Map<String, String> loginDetails = dataTable.asMap();
			userLoginPage.loginUser(loginDetails.get("Email Address"), (loginDetails.get("Password")));
			log.info("User logged successfully");
		} catch (Exception e) {
			log.error("An unexcepted error occured while login the application", e);
			throw e;
		}

	}

	@Then("the user should be navigated to the login page")
	public void user_should_be_navigated_to_login_page() {
		try {
			boolean result = userLoginPage.isOnLoginPage();
			Assert.assertTrue(result);
			log.info("Login page title is matched");
		} catch (AssertionError ae) {
			log.error("Assert is failed", ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception occured while navigating to login page");
			throw e;
		}
		}

	@When("the user clicks on create an account link")
	public void user_click_on_create_an_account_link() {
		try {
			userLoginPage.createAccount();
			log.info("Account link was clicked successfully");
		} catch (Exception e) {
			log.error("An exception occured while clicking create account link", e);
			throw e;
		}
	}
	
	

	
	
	
	
	



}
