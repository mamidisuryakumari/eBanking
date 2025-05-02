package com.eBanking.stepDefinitions;

import java.lang.System.LoggerFinder;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.AdminDashBoardPage;

import io.cucumber.java.en.Then;

public class AdminDashboardSteps {
	
	WebDriver driver = Hooks.getDriver();
	Logger log = LoggerFactory.getLogger(AdminDashboardSteps.class);
	AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage(driver);
	
	@Then("Admin should be navigated to admindashboard page")
	public void admin_should_be_navigated_to_admindashboard_page() {
		 try {
				String actualTitle = adminDashBoardPage.getAdminDashBoardPageTitle();
				String expectedTitle = "e-Banking | Dashboard";
				Assert.assertEquals(expectedTitle, actualTitle);
				log.info("Title is matched");
		    }catch (AssertionError ae) {
				log.error("Title is not matched" , ae);
				throw ae;
			} catch (Exception e) {
				log.error("An exception error occured while navigating to admin dashboard page" , e);
				throw e;
			}
	}


}
