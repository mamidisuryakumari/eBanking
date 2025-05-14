package com.eBanking.stepDefinitions;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.user.AccountDetailsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountDetailsStep extends Page{
	AccountDetailsPage accountDetailsPage = new AccountDetailsPage();
	Logger log = LoggerFactory.getLogger(AccountDetailsStep.class);

	@Then("the user should be navigated to the Account Details page")
	public void the_user_should_be_navigated_to_the_account_details_page() {

		try {
			String exceptedAccountDetailsText = "Account Details";
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

	@When("the user enters the following account details")
	public void the_user_enters_the_following_account_details(io.cucumber.datatable.DataTable dataTable)
			throws IOException {
		try {
			Map<String, String> accountDetails = dataTable.asMap();
			accountDetailsPage.enterAccountDetails(accountDetails.get("Address Proof ID Number"),
					accountDetails.get("PAN Card ID Number"), accountDetails.get("Address"),
					accountDetails.get("Date of birth"));
			log.info("Account details entered successfully");
		} catch (Exception e) {
			log.error("An exception error occured while entered account details", e);
			throw e;
		}
	}

	@Then("the user should see a message {string}")
	public void the_user_should_see_a_message(String string) {
		try {
			Alert alert = driver.switchTo().alert();
			String actualTetx = alert.getText();
			alert.accept();
			String expSuccessMsg = "Details succesfully submitted.";
			assertEquals(expSuccessMsg, actualTetx);
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
