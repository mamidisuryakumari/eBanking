package com.eBanking.stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.HomePage;
import com.eBanking.pages.user.UserRegistrationPage;
import com.eBanking.pages.user.UserLoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationSteps {

	WebDriver driver = Hooks.getDriver();
	Logger log = LoggerFactory.getLogger(UserRegistrationSteps.class);
	UserRegistrationPage registrationPage = new UserRegistrationPage(driver);
	HomePage homePage = new HomePage(driver);
	UserLoginPage loginPage = new UserLoginPage(driver);

	@When("I registers with the following details")
	public void user_registers_an_account_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {

		try {
			Map<String, String> registrationAccountDetails = dataTable.asMap();
			registrationPage.registerUserAccount(registrationAccountDetails.get("First Name"),
					registrationAccountDetails.get("Last Name"), registrationAccountDetails.get("Email Address"),
					registrationAccountDetails.get("Mobile Number"), registrationAccountDetails.get("Password"));
			log.info("registration successfull");
		} catch (Exception e) {
			log.error("Unexcepted error occured", e);
			throw e;
		}

	}
	

	@Then("I should see a message You have successfully registered with us")
	public void user_should_see_a_registration_successful_message() {
		try {
			Alert alert = driver.switchTo().alert();
			String actualTetx = alert.getText();
			alert.accept();
			String expText = "You have successfully registered with us";
			Assert.assertEquals(actualTetx, expText);
			log.info("User should see register successfull message");
		}catch (AssertionError ae) {
			log.error("Assert failed" , ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception error occured while seeing registration successful message", e);
			throw e;
		}

		}

	@Then("I should be navigated to the user registration page")
	public void user_should_be_navigated_to_registration_page() {
	    try {
	    	boolean result = registrationPage.isOnRegistrationPage();
			Assert.assertTrue(result);
			log.info("The registration page title was matched");
		} catch (AssertionError ae) {
			log.error("Assert failed", ae);
			throw ae;
		}catch (Exception e) {
			log.error("An exception error occured while navigating to registration page", e);
			throw e;
		}
	}
}
