package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.HomePage;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.admin.AdminLoginPage;
import com.eBanking.ui.pages.user.UserLoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginSteps extends Page{

	
	private static final Logger logger = LoggerFactory.getLogger(UserLoginSteps.class);
	UserLoginPage userLoginPage = new UserLoginPage();
	HomePage homePage = new HomePage();
	AdminLoginPage adminLoginPage = new AdminLoginPage();
	
	@When("I navigate to user login page")
	public void iNavigateToUserLoginPage(){
		try {
			homePage.iNavigatedToUserLoginPage();
			String actualUserLoginPageTitle = bot.getTitle();
			String exceptedUserLoginPageTitle = PropertiesManager.getProperty("userlogin.page.title").trim();
			assertEquals(exceptedUserLoginPageTitle, actualUserLoginPageTitle);
			logger.info("I navigated to login page successfully");
			userLoginPage.createAccount();
		} catch (Exception e) {
			logger.error("An exception occured while navigating login page", e);
			throw e;
		}
			
		}
	
@When("I go to user login page")
public void iGoToUserLoginPage()  {
	try {
		homePage.iNavigatedToUserLoginPage();
		String actualUserLoginPageTitle = bot.getTitle();
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
