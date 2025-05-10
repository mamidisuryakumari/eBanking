package com.eBanking.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.ui.pages.user.UserDashboardPage;
import com.eBanking.ui.pages.user.UserPage;

import io.cucumber.java.en.Then;

public class ManagePayeeSteps {
	
	WebDriver driver = Hooks.getDriver();
	UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
	UserPage userPage = new UserPage(driver);

	private static Logger log = LoggerFactory.getLogger(ManagePayeeSteps.class);
	
	@Then("the user should see a message Payee or beneficiary Account detail has been added")
	public void the_user_should_see_a_message_payee_beneficiary_account_detail_has_been_added() {
		try {
			Alert alert = driver.switchTo().alert();
			String actualMessage = alert.getText();
			alert.accept();
			String expMessage = "Payee / beneficiary Account detail has been added.";
			Assert.assertEquals(actualMessage, expMessage);
			log.info("User should see account details added successfull message");
			} catch (AssertionError ae) {
			log.error("Assert failed", ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception error occured while seeing account details added successful message", e);
			throw e;
		}

	}
	
	@Then("I should be navigated to the manage payee page")
	public void i_should_be_navigated_to_the_manage_payee_page() {
	    
	}


}
