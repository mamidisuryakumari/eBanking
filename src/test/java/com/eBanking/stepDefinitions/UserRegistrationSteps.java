package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.HomePage;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.user.UserLoginPage;
import com.eBanking.ui.pages.user.UserRegistrationPage;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationSteps extends Page{

	private static Logger logger = LoggerFactory.getLogger(UserRegistrationSteps.class);
	UserRegistrationPage userRegistrationPage = new UserRegistrationPage();
	HomePage homePage = new HomePage();
	UserLoginPage loginPage = new UserLoginPage();
	
	@When("I go to registration page")
	public void iGoToRegistrationPage() {
		 try {
			 String actualRegistrationPageTitle = bot.getTitle();
				String expRegistrationPageTitle = PropertiesManager.getProperty("registration.page.title").trim();
				assertEquals(actualRegistrationPageTitle, expRegistrationPageTitle);
				logger.info("Registration page title is matched");
			} catch (AssertionError ae) {
				logger.error("Registration page title is not matched", ae);
				throw ae;
			}catch (Exception e) {
				logger.error("An exception occured while matching the register page title" , e);
				throw e;
			}
			
	}
	
	@When("I add user registration details:")
	public void iAddUserRegistrationDetails(DataTable registrationDetails) {
		try {
			var registrationDetailsMap = registrationDetails.asMap(String.class,String.class);
			userRegistrationPage.addRegistrationDetails(registrationDetailsMap.get("First Name"),
					registrationDetailsMap.get("Last Name"), 
					bot.getRandomNumber(10, 10000)+registrationDetailsMap.get("Email Address"),
					registrationDetailsMap.get("Mobile Number"),
					registrationDetailsMap.get("Password"));
			logger.info("registration successfull");
		} catch (Exception e) {
			logger.error("Unexcepted error occured", e);
			throw e;
		}
	}
	
	@Then("I should see user registered successfully")
	public void iShouldSeeUserRegisteredSuccessfully() {
		try {
			String actualTetx = bot.getAlertMessage();
			String expText = "You have successfully registered with us";
			assertEquals(actualTetx, expText);
			logger.info("User should see register successfull message");
			bot.acceptAlert();
		}catch (AssertionError ae) {
			logger.error("Assert failed" , ae);
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
