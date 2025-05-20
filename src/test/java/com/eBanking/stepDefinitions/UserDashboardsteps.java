package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.user.UserDashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserDashboardsteps extends Page{
	
	Logger log = LoggerFactory.getLogger(UserDashboardsteps.class);
	UserDashboardPage userDashboardPage = new UserDashboardPage();
	
	

	@Then("I should be navigated to the user dashboard page")
	public void user_should_be_navigated_to_dashboard_page() {
	    try {
	    	String actualDashboardPageTitle = userDashboardPage.getDashboardPageTitle();
	    	String exceptedDashboardPageTitle = PropertiesManager.getProperty("userDashboard.page.title");
	    	assertEquals(exceptedDashboardPageTitle, actualDashboardPageTitle);
			log.info("Title is matched for userdashboard page");
	    }catch (AssertionError ae) {
			log.error("Title is not matched for userdashboard" , ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception error occured while navigating to dashboard page" , e);
			throw e;
		}
	}

	

	
	





}
