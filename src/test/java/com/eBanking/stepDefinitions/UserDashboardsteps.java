package com.eBanking.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.UserDashboardPage;

import io.cucumber.java.en.Then;

public class UserDashboardsteps {
	
	WebDriver driver = Hooks.getDriver();
	Logger log = LoggerFactory.getLogger(UserDashboardsteps.class);
	UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
	
	

	@Then("User should be navigated to dashboard page")
	public void user_should_be_navigated_to_dashboard_page() {
	    try {
			String actualTitle = userDashboardPage.getUserDashboardPage();
			String expectedTitle = "e-Banking | User Dashboard";
			Assert.assertEquals(expectedTitle, actualTitle);
			log.info("Title is matched");
	    }catch (AssertionError ae) {
			log.error("Title is not matched" , ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception error occured while navigating to dashboard page" , e);
			throw e;
		}
	}




}
