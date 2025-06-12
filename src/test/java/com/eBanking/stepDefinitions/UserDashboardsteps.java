package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.user.UserDashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserDashboardsteps {
	
	private TestContext context;
	private final Logger logger = LoggerFactory.getLogger(UserDashboardsteps.class);
	UserDashboardPage userDashboardPage ;
	
	public UserDashboardsteps(TestContext context) {
		this.context = context;
		this.userDashboardPage = new UserDashboardPage(context);
	}
	
	@When("I go to dashboard page")
	public void navigateToDashBoardPage(){
		try {
			userDashboardPage.navigateToDashBoardPage();
		} catch (Exception e) {
			
		}
	}
	

	@Then("I should be navigated to the user dashboard page")
	public void user_should_be_navigated_to_dashboard_page() {
	    try {
	    	String actualDashboardPageTitle = userDashboardPage.getDashboardPageTitle();
	    	String exceptedDashboardPageTitle = PropertiesManager.getProperty("userDashboard.page.title");
	    	assertEquals(exceptedDashboardPageTitle, actualDashboardPageTitle);
			logger.info("Title is matched for userdashboard page");
	    }catch (AssertionError e) {
	    	logger.error("Title is not matched for userdashboard" , e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error("An exception error occured while navigating to dashboard page" , e);
			throw e;
		}
	}

	

	
	





}
