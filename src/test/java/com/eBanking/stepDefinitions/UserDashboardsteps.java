package com.eBanking.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.UserDashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserDashboardsteps {
	
	WebDriver driver = Hooks.getDriver();
	Logger log = LoggerFactory.getLogger(UserDashboardsteps.class);
	UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
	
	

	@Then("the user should be navigated to the dashboard page")
	public void user_should_be_navigated_to_dashboard_page() {
	    try {
	    	boolean result = userDashboardPage.isOnUserDashboardPage();
			Assert.assertTrue(result);
			log.info("Title is matched for userdashboard page");
	    }catch (AssertionError ae) {
			log.error("Title is not matched for userdashboard" , ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception error occured while navigating to dashboard page" , e);
			throw e;
		}
	}

	

	@When("the user clicks on the Account Opening option")
	public void the_user_clicks_on_the_account_opening_option() {
		try {
			 userDashboardPage.clickOnAccountOpening();
			 log.info("User clicked on account opening successfully");
		} catch (Exception e) {
			log.error("An exception occured while clicking on the account opening option", e);
			throw e;
		}
	  }
	




}
