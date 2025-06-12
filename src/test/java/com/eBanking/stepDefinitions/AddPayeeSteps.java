package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.user.AddPayeepage;
import com.eBanking.ui.pages.user.UserDashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPayeeSteps {
	private TestContext context;
		private  Logger logger = LoggerFactory.getLogger(AddPayeeSteps.class);
	UserDashboardPage userDashboardPage;
	AddPayeepage addPayeepage;
	
	public AddPayeeSteps(TestContext context) {
		this.context = context;
		this.userDashboardPage = new UserDashboardPage(context);
		this.addPayeepage = new AddPayeepage(context);
	}
	
	@Then("I go to the add payee page")
	public void iGoToTheAddPayeePage() {
	   try {
		userDashboardPage.navagatedToAddPayeePage();
		String actualAddPayyeText = addPayeepage.getAddPayyeText();
		String excePtedAddPayyeText = PropertiesManager.getProperty("addPayee.Text");
		assertEquals(excePtedAddPayyeText, actualAddPayyeText);
		logger.info("Text is matched successfully");
	} catch (AssertionError ae) {
		logger.error("Assertion failed: add payee text is mismatched", ae);
        throw ae;
	}catch (Exception e) {
		logger.error("An exception error occured while navigating to add payee page" , e);
		throw e;
	}
	   
	}

	
	@When("I add following payee account details")
	public void the_user_add_following_payye_account_details(io.cucumber.datatable.DataTable dataTable) {
		
		try {
			var payeeAccountDetails = dataTable.asMap();
			addPayeepage.addPayyeAccountDetails(payeeAccountDetails.get("Account Number"),
					payeeAccountDetails.get("Confirm Account Number"), 
					payeeAccountDetails.get("Account Holder Name"));
			logger.info("Payee account details added successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while adding payye account details" , e);
			throw e;
		}
	}
	
	
	@Then("I should see Payee account details have been added successfully")
	public void i_should_see_the_message(String string) {
	   try {
		String actualAddPayeeSuccessMsg = addPayeepage.addPayeeAlertmsg();
		String exceptedAddPayeeSuccessMsg = PropertiesManager.getProperty("addPayyeAccount.success.msg");
		assertEquals(exceptedAddPayeeSuccessMsg, actualAddPayeeSuccessMsg);
		logger.info("Add payee success message is matched");
		addPayeepage.acceptAddPayeeAlert();
		
	} catch (AssertionError ae) {
		logger.error("Assertion failed : add payee success message is mismatched" , ae );
	}catch (Exception e) {
		logger.error("An exception error occured while  seeing account details added successful message" ,e );
	}
	}
	
	

}
