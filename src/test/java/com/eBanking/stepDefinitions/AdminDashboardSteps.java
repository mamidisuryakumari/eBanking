package com.eBanking.stepDefinitions;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;

import io.cucumber.java.en.Then;

public class AdminDashboardSteps {
	
	private TestContext context;
	private final Logger logger = LoggerFactory.getLogger(AdminDashboardSteps.class);
	AdminDashBoardPage adminDashBoardPage;
	
	public AdminDashboardSteps(TestContext context) {
		this.context = context;
		this.adminDashBoardPage = new AdminDashBoardPage(context);
	}
	
	@Then("I should be navigated to the admin dashboard page")
	public void iShouldBeNavigatedToTheAdminDashBoardPage(){
		 try {
			 String actualAdminDashBoardPageTitle = adminDashBoardPage.getAdminDashboardText();
			 String exceptedAdminDashBoardPageTitle = PropertiesManager.getProperty("admin.dashboard.text");
			 assertEquals(exceptedAdminDashBoardPageTitle, actualAdminDashBoardPageTitle);
				logger.info("Admin dashboard text  is matched");
		    }catch (AssertionError ae) {
				logger.error("Assertion failed: Admin dashboard text is not matched" , ae);
				throw ae;
			} catch (Exception e) {
				logger.error("An exception error occured while navigating to admin dashboard page" , e);
				throw e;
			}
}
	
	@Then("Admin should be navigated to the admin dashboard page")
	public void admin_should_be_navigated_to_admin_dashboard_page() {
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
