package com.eBanking.stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.UserDashboardPage;
import com.eBanking.pages.UserPage;
import com.eBanking.utilities.CommonUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps {

	WebDriver driver = Hooks.getDriver();
	UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
	UserPage userPage = new UserPage(driver);

	private static Logger log = LoggerFactory.getLogger(UserSteps.class);

	@When("the user add following payye account details")
	public void the_user_add_following_payye_account_details(io.cucumber.datatable.DataTable dataTable) {
		try {
			userDashboardPage.clickOnPayeeOption().clickOnAddLink();
			Map<String, String> payeeAccountDetails = dataTable.asMap();
			userPage.userAddPayeeAccountDetails(payeeAccountDetails.get("Account Number"),
					payeeAccountDetails.get("Confirm Account Number"), payeeAccountDetails.get("Account Holder Name"));
			log.info("User added acconut details successfully");
		} catch (Exception e) {
			log.error("An exception occured while user add payee account details", e);
			throw e;
		}
		
	}

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
	
	

	@When("the user deletes the payee details")
	public void user_delete_payee_details() throws Exception {
	  try {
		userDashboardPage.clickOnPayeeOption().managePayee();
		userPage.userDeletePayee(CommonUtils.getProperties().getProperty("Deletepayee"));
		log.info("Payee details deleted successfully");
	} catch (Exception e) {
		log.error("An exception occured while deleting payee deatails" ,e );
		throw e;
	}
	}
	@Then("the user should see message data deleted")
	public void user_should_see_message_data_deleted() {

		try {
			Alert alert = driver.switchTo().alert();
			String actualMessage = alert.getText();
			alert.accept();
			String expMessage = "Data deleted";
			Assert.assertEquals(actualMessage, expMessage);
			log.info("User should see account details deleted successfull message");
			} catch (AssertionError ae) {
			log.error("Assert failed", ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception error occured while seeing account details deleted message", e);
			throw e;
		}
	}
	

	@When("the user money transfers to the payee's account")
	public void user_money_transfer_to_the_payee() throws Exception {
	  try {
		userDashboardPage.clickOnPayeeOption().managePayee();
		userPage.trasferMoneyToPayee(CommonUtils.getProperties().getProperty("MoneyTransferToPayee"),
				CommonUtils.getProperties().getProperty("transferAmount"));
		log.info("User money transferd to the payee successfull");
	} catch (Exception e) {
		log.error("An exception occured while user money transfer to the payee", e);
		throw e;
	}
	}
	@Then("the user should see the message {string}")
	public void the_user_should_see_the_message(String string) {
		try {
			Alert alert = driver.switchTo().alert();
			String actualMessage = alert.getText();
			alert.accept();
			String expMessage = "Transaction Details has been updated";
			Assert.assertEquals(actualMessage, expMessage);
			log.info("User should see transaction details has been updated successfull message");
			} catch (AssertionError ae) {
			log.error("Assert failed", ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception error occured while seeing transaction details has been updated message", e);
			throw e;
		}
	}





}