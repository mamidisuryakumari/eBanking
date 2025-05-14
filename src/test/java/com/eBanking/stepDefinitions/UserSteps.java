package com.eBanking.stepDefinitions;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.user.UserDashboardPage;
import com.eBanking.ui.pages.user.UserPage;
import com.eBanking.utilities.CommonUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps extends Page{

	
	UserDashboardPage userDashboardPage = new UserDashboardPage();
	UserPage userPage = new UserPage();

	private static Logger log = LoggerFactory.getLogger(UserSteps.class);

	
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
			assertEquals(actualMessage, expMessage);
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
			assertEquals(actualMessage, expMessage);
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