package com.eBanking.stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;

public class AdminDashboardSteps extends Page{
	
	
	Logger log = LoggerFactory.getLogger(AdminDashboardSteps.class);
	AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
	
	@Then("Admin should be navigated to admindashboard page")
	public void admin_should_be_navigated_to_admindashboard_page() {
		 try {
			 boolean result = adminDashBoardPage.isOnAdminDashBoardPage();
				assertTrue(result);
				log.info("Title is matched");
		    }catch (AssertionError ae) {
				log.error("Title is not matched" , ae);
				throw ae;
			} catch (Exception e) {
				log.error("An exception error occured while navigating to admin dashboard page" , e);
				throw e;
			}
	}
	
	

	@When("Admin click on new account request menu")
	public void admin_click_on_new_account_request_menu() {
		try {
			adminDashBoardPage.newAccountRequest();
			log.info("New account request menu clicked successfully");
		} catch (Exception e) {
			log.error("An exception  occured while clicking account request menu",e );
			throw e;
		}
	   
	}
	




}
