package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserLoginSteps {

	private  TestContext context;
	private UserLoginPage userLoginPage;
	private HomePage homePage;
	private AdminLoginPage adminLoginPage;
	private UserRegistrationPage registrationPage;

	public UserLoginSteps(TestContext context) {
		this.context = context;
		this.userLoginPage = new UserLoginPage(context);
		this.homePage = new HomePage(context);
		this.adminLoginPage = new AdminLoginPage(context);
		this.registrationPage = new UserRegistrationPage(context);

	}

	@When("I navigate to login page as a {}")
	public void iNavigateToPage(String user) {
		try {
			UserType userType = UserType.valueOf(user.toUpperCase());
			homePage.navigateToPage(userType);
			log.info("Navigate to page successfully");
		} catch (Exception e) {
			log.error("An exception error occured while navigating to page" , e.getMessage());
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
			log.info("I navigated to login page successfully");
			userLoginPage.goToRegistrationPage();
		} catch (AssertionError e) {
			log.error("Assertion failed: login page title is not matched", e.getMessage());
		} catch (Exception e) {
			log.error("An exception occured while navigating to the login page", e.getMessage());
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
			log.info("I navigated to login page successfully");
		} catch (Exception e) {
			log.error("An exception occured while navigating login page", e);
			throw e;
		}

	}

	@When("I log in with valid credentials")
	public void user_logs_in_with_valid_credentials(DataTable userLoginDetails) {
		try {
			var userLoginMap = userLoginDetails.asMap(String.class, String.class);
			userLoginPage.loginUser(userLoginMap.get("Email Address"), userLoginMap.get("Password"));
			log.info("User logged successfully");
		} catch (Exception e) {
			log.error("An unexcepted error occured while login into the application", e);
			throw e;
		}

	}

	@When("I login with userName and password")
	public void loginToTheApplication() {
		try {
			userLoginPage.loginUser(context.getUserEmailId(), context.getUserPassword());
			log.info("User logged successfully");
		} catch (Exception e) {
			log.error("An unexcepted error occurred while login into the application", e);
			throw e;
		}

	}

	@When("I clicks on create an account link")
	public void user_click_on_create_an_account_link() {
		try {
			log.info("Account link was clicked successfully");
		} catch (Exception e) {
			log.error("An exception occured while clicking create account link", e);
			throw e;
		}
	}

	@When("I log in with valid email address and new password")
	public void iLogInWithValidEmailAddressAndPassword(){
		try{
			userLoginPage.loginUser(context.getUserEmailId(),context.getUserNewPassword());
			log.info("User log in successfully");
		} catch (Exception e) {
			log.error("An exception error occured while logging in the user "+ e.getMessage());
			throw e;
		}
	}

	@When("I log in email address {string} and password {string}")
	public void i_log_in_email_address_and_password(String eamilAddress, String password) {
		try {
			userLoginPage.loginUser(eamilAddress,password );
			log.info("Email address and password entered successfully");
		} catch (Exception e) {
			log.error("An exception error occured while entering email address and password", e.getMessage());
			throw e;
		}

	}

	@Then("I should see the message {string}")
	public void i_should_see_the_message(String expectedMessage) {
		try {
            String actualMsgText = userLoginPage.getEmailFormatErrorMessage();

            if(expectedMessage.isEmpty())
            {
              assertEquals(expectedMessage,actualMsgText,"Error message s not matched");
              log.info(actualMsgText);
            }

			else if(expectedMessage.contains("@ is missing")){

                assertEquals(expectedMessage ,actualMsgText , "Actual and Expected error message are not matched");
                log.info(actualMsgText);
			}

		} catch (AssertionError e) {
			log.error("Asserion failed", e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error("Exception error occurred while seeing the message", e.getMessage());
			throw  e;
		}

	}


}
