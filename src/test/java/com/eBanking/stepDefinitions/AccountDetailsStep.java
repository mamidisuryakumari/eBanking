package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.Common;
import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.user.AccountDetailsPage;
import com.eBanking.ui.pages.user.UserDashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountDetailsStep {
	
	private TestContext context;
	private static final Logger logger = LoggerFactory.getLogger(AccountDetailsStep.class);
	AccountDetailsPage accountDetailsPage ;
	UserDashboardPage userDashboardPage ;
	
	public AccountDetailsStep(TestContext context) {
		this.context = context;
		this.accountDetailsPage = new AccountDetailsPage(context);
		this.userDashboardPage  = new UserDashboardPage(context);
	}
	
	
	@When("I go to the account Details page")
	public void iGoToTheAccountDetailsPage() {
		try {
			 userDashboardPage.navigatedToAccountDetailsPage();
			 String exceptedAccountDetailsText = PropertiesManager.getProperty("accountdetails.text");
				String actualAccountDetailsText = accountDetailsPage.getAccountDetailsText();
				assertEquals(exceptedAccountDetailsText, actualAccountDetailsText);
				logger.info("Account details text is matched successfully");
			} catch (AssertionError ae) {
				logger.error("Assert failed", ae);
				throw ae;
			} catch (Exception e) {
				logger.error("An unexcepted error occured while navigating to the account details page", e);
				throw e;
			}
	}

	

	@When("I enters the following account details")
	public void i_enters_the_following_account_details(io.cucumber.datatable.DataTable dataTable){
		try {
			Map<String, String> accountDetails = dataTable.asMap();
			accountDetailsPage.enterAccountDetails(accountDetails.get("Address Proof ID Number").trim().replace("${aadharCard}",Common.generateRandomAdharNumber()),
					accountDetails.get("PAN Card ID Number").trim().replace("${panNumber}", Common.generateRandomPanNumber()), 
					accountDetails.get("Address"),
					accountDetails.get("Date of birth"));
			logger.info("Account details entered successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while entered account details", e);
			throw e;
		}
	}
	
	@Then("I should see success message as {}")
		public void iShouldSeeSuccessMessageAs(String expSuccessMsg) {
			try {
				accountDetailsPage.acceptAccountSubmition();
				String createAccountSuccessMsg = context.getActualUserAccountSubmissionSuccessMsg();
				assertEquals(createAccountSuccessMsg, expSuccessMsg);
				logger.info("Account created and sumbitted for approval");
				} catch (AssertionError e) {
				logger.error("Assertion failed: Alert text did not match the expected message" , e.getMessage());
				throw e;
			}catch (Exception e) {
				logger.error("An exception occurred while handling the alert message" , e.getMessage());
				throw e;
			}
	}

	
			
		

}
