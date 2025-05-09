package com.eBanking.stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.admin.AdminPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps {
	WebDriver driver = Hooks.getDriver();
	private static Logger log = LoggerFactory.getLogger(AdminSteps.class);
	AdminPage adminPage = new AdminPage(driver);
	
	@Then("Admin should be navigated to admin page")
	public void admin_should_be_navigated_to_account_opening_request_page() {
	    try {
	    	boolean result = adminPage.isOnAdminPage();
			Assert.assertTrue(result);
			log.info("Title is matched");
	    }catch (AssertionError ae) {
			log.error("Title is not matched" , ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception error occured while navigating to admin page" , e);
			throw e;
		}
	}
	@When("Admin approv the request")
	public void admin_approv_the_request() throws IOException{
		try {
			adminPage.accountApproval();
			log.info("Admin approv the request successfully");
		} catch (Exception e) {
			log.error("An exception occured while approving the request", e);
			throw e;
		}
	   
	}
	@Then("Admin should see approve request successful message")
	public void admin_should_see_approve_request_successful_message() {
		try {
			Alert alert = driver.switchTo().alert();
			String actualTetx = alert.getText();
			alert.accept();
			String expSuccessMsg = "Remark has been updated";
			Assert.assertEquals(expSuccessMsg, actualTetx);
			log.info("Success message is matched");
		} catch (AssertionError ae) {
			log.error("Assertion failed: Alert text did not match the expected message" , ae);
			throw ae;
		}catch (Exception e) {
			log.error("An exception occurred while handling the alert message" , e);
			throw e;
		}
	}


}
