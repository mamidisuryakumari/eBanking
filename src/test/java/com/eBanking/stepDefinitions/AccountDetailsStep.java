package com.eBanking.stepDefinitions;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.user.AccountDetailsPage;
import com.eBanking.ui.pages.user.UserDashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountDetailsStep extends Page{
	
	private static final Logger log = LoggerFactory.getLogger(AccountDetailsStep.class);
	AccountDetailsPage accountDetailsPage = new AccountDetailsPage();
	UserDashboardPage userDashboardPage = new UserDashboardPage();
	
	
	@When("I go to the account Details page")
	public void iGoToTheAccountDetailsPage() {
		try {
			 userDashboardPage.iNavigatedToAccountDetailsPage();
			 String exceptedAccountDetailsText = PropertiesManager.getProperty("accountdetails.text");
				String actualAccountDetailsText = accountDetailsPage.getAccountDetailsText();
				assertEquals(exceptedAccountDetailsText, actualAccountDetailsText);
				log.info("Account details text is matched successfully");
			} catch (AssertionError ae) {
				log.error("Assert failed", ae);
				throw ae;
			} catch (Exception e) {
				log.error("An unexcepted error occured while navigating to the account details page", e);
				throw e;
			}
	}

	

	@When("I enters the following account details")
	public void i_enters_the_following_account_details(io.cucumber.datatable.DataTable dataTable){
		try {
			Map<String, String> accountDetails = dataTable.asMap();
			accountDetailsPage.enterAccountDetails(accountDetails.get("Address Proof ID Number"),
					accountDetails.get("PAN Card ID Number"), 
					accountDetails.get("Address"),
					accountDetails.get("Date of birth"));
			log.info("Account details entered successfully");
		} catch (Exception e) {
			log.error("An exception error occured while entered account details", e);
			throw e;
		}
	}
	
	@Then("I should see account opening successfully")
		public void iShouldSeeAccountOpeningSuccessfully() {
			try {
				String createAccountSuccessMsg = bot.getAlertMessage();
				String expSuccessMsg = PropertiesManager.getProperty("createAccount.success.msg");
				assertEquals(createAccountSuccessMsg, expSuccessMsg);
				bot.acceptAlert();
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
