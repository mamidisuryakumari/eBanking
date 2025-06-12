package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.HomePage;
import com.eBanking.ui.pages.admin.AdminLoginPage;
import com.eBanking.ui.pages.user.UserLoginPage;
import com.eBanking.ui.pages.user.UserRegistrationPage;

import enums.UserType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class UserLoginSteps {

	private final TestContext context;
	private static final Logger logger = LoggerFactory.getLogger(UserLoginSteps.class);
	UserLoginPage userLoginPage;
	HomePage homePage;
	AdminLoginPage adminLoginPage;
	UserRegistrationPage registrationPage;

	public UserLoginSteps(TestContext context) {
		this.context = context;
		this.userLoginPage = new UserLoginPage(context);
		this.homePage = new HomePage(context);
		this.adminLoginPage = new AdminLoginPage(context);
		this.registrationPage = new UserRegistrationPage(context);

	}

	@When("I navigate to page as a {}")
	public void iNavigateToPage(String user) {
		try {
			UserType userType = UserType.valueOf(user.toUpperCase());
			homePage.navigateToPage(userType);
			logger.info("Navigate to page successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while navigating to page" , e.getMessage());
			throw e;
		}
		
	}

	@When("I navigate to user login page")
	public void iNavigateToUserLoginPage() {
		try {
			homePage.navigatedToUserLoginPage();
			String actualUserLoginPageTitle = userLoginPage.getUserLoginPageTitle();
			String exceptedUserLoginPageTitle = PropertiesManager.getProperty("userlogin.page.title").trim();
		assertEquals(exceptedUserLoginPageTitle, actualUserLoginPageTitle);
			logger.info("I navigated to login page successfully");
			userLoginPage.goToRegistrationPage();
		} catch (AssertionError e) {
			logger.error("Assertion failed: login page title is not matched", e.getMessage());
		} catch (Exception e) {
			logger.error("An exception occured while navigating to the login page", e.getMessage());
			throw e;
		}

	}

	@When("I go to user login page")
	public void iGoToUserLoginPage() {
		try {
			homePage.navigatedToUserLoginPage();
			String actualUserLoginPageTitle = userLoginPage.getUserLoginPageTitle();
			String exceptedUserLoginPageTitle = PropertiesManager.getProperty("userlogin.page.title").trim();
			assertEquals(exceptedUserLoginPageTitle, actualUserLoginPageTitle);
			logger.info("I navigated to login page successfully");
		} catch (Exception e) {
			logger.error("An exception occured while navigating login page", e);
			throw e;
		}

	}

	@When("I log in with valid credentials")
	public void user_logs_in_with_valid_credentials(DataTable userLoginDetails) {
		try {
			var userLoginMap = userLoginDetails.asMap(String.class, String.class);
			userLoginPage.loginUser(userLoginMap.get("Email Address"), userLoginMap.get("Password"));
			logger.info("User logged successfully");
		} catch (Exception e) {
			logger.error("An unexcepted error occured while login into the application", e);
			throw e;
		}

	}

	@When("I login with userName and password")
	public void loginToTheApplication() {
		try {
			userLoginPage.loginUser(context.getUserEmailId(), context.getUserPassword());
			logger.info("User logged successfully");
		} catch (Exception e) {
			logger.error("An unexcepted error occured while login into the application", e);
			throw e;
		}

	}

	@When("I clicks on create an account link")
	public void user_click_on_create_an_account_link() {
		try {

			logger.info("Account link was clicked successfully");
		} catch (Exception e) {
			logger.error("An exception occured while clicking create account link", e);
			throw e;
		}
	}

}
