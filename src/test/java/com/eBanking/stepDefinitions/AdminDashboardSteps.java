package com.eBanking.stepDefinitions;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminDashboardSteps extends Page{
	
	
	Logger logger = LoggerFactory.getLogger(AdminDashboardSteps.class);
	AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
	
	@Then("Admin should be navigated to the admindashboard page")
	public void admin_should_be_navigated_to_admindashboard_page() {
		 try {
			 String actualAdminDashBoardPageTitle = adminDashBoardPage.getAdminDashboardPageTitle();
			 String exceptedAdminDashBoardPageTitle = PropertiesManager.getProperty("admin.DashboardPage.title");
			 assertEquals(exceptedAdminDashBoardPageTitle, actualAdminDashBoardPageTitle);
				logger.info("Title is matched");
		    }catch (AssertionError ae) {
				logger.error("Assertion failed: Title is not matched" , ae);
				throw ae;
			} catch (Exception e) {
				logger.error("An exception error occured while navigating to admin dashboard page" , e);
				throw e;
			}
	}
	
	

	
	




}
