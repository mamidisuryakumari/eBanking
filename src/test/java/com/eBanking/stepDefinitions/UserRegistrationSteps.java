package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.Common;
import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.HomePage;
import com.eBanking.ui.pages.user.UserLoginPage;
import com.eBanking.ui.pages.user.UserRegistrationPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationSteps {

	private TestContext context;
	private final Logger logger = LoggerFactory.getLogger(UserRegistrationSteps.class);
	UserRegistrationPage userRegistrationPage;
	HomePage homePage;
	UserLoginPage userloginPage;

	public UserRegistrationSteps(TestContext context) {
		this.context = context;
		this.userRegistrationPage = new UserRegistrationPage(context);
		this.homePage = new HomePage(context);
		this.userloginPage = new UserLoginPage(context);
	}

	@When("I go to registration page")
	public void iGoToRegistrationPage() {
		try {
			userloginPage.goToRegistrationPage();
			String actualRegistrationPageTitle = userRegistrationPage.getRegistrationPageTitle();
			String expRegistrationPageTitle = PropertiesManager.getProperty("registration.page.title").trim();
			assertEquals(actualRegistrationPageTitle, expRegistrationPageTitle);
			logger.info("Registration page title is matched");
		} catch (AssertionError e) {
			logger.error("Assertion failed: registration page title is not matched", e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error("An exception occured while matching the register page title", e.getMessage());
			throw e;
		}

	}

	@When("I add user registration details:")
	public void iAddUserRegistrationDetails(DataTable registrationDetails) {
		try {
			var registrationDetailsMap = registrationDetails.asMap(String.class, String.class);
			userRegistrationPage.addRegistrationDetails(
					registrationDetailsMap.get("First Name").replace("${random}", Common.random()),
					registrationDetailsMap.get("Last Name"),
					registrationDetailsMap.get("Email Address").replace("${random}", Common.random()),
					registrationDetailsMap.get("Mobile Number").replace("${mobileNumber}",Common.generateMobileNumber()),
					registrationDetailsMap.get("Password").replace("${password}",PropertiesManager.getProperty("user.password")));
			logger.info("User registration details added successfully");
		} catch (Exception e) {
			logger.error("Unexpected error occurred while adding user registration details", e.getMessage());
			throw e;
		}
	}

	@Then("I should see user registration message as {}")
	public void iShouldSeeMessageAs(String expectedRegistrationSuccessMsg) {
		try {
			userRegistrationPage.acceptUserRegistration();
			assertEquals(context.getActualUserRegistrationSuccessMsg(), expectedRegistrationSuccessMsg);
			logger.info("User should see register successfull message");

		} catch (AssertionError ae) {
			logger.error("Assert failed", ae);
			throw ae;
		} catch (Exception e) {
			logger.error("An exception error occured while seeing registration successful message", e);
			throw e;
		}

	}

	@Then("I should be navigated to the user registration page")
	public void user_should_be_navigated_to_registration_page() {

	}
}