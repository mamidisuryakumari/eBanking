package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.user.AddPayeepage;
import com.eBanking.ui.pages.user.UserDashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
@Slf4j
public class AddPayeeSteps {
	private TestContext context;
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
		String expectedAddPayyeText = PropertiesManager.getProperty("addPayee.Text");
		assertEquals(expectedAddPayyeText, actualAddPayyeText);
		   log.info("Text is matched successfully");
	} catch (AssertionError ae) {
		   log.error("Assertion failed: add payee text is mismatched", ae);
        throw ae;
	}catch (Exception e) {
		   log.error("An exception error occured while navigating to add payee page" , e);
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
			log.info("Payee account details added successfully");
		} catch (Exception e) {
			log.error("An exception error occured while adding payye account details" , e);
			throw e;
		}
	}
	
	
	@Then("I should see Payee account details have been added successfully")
	public void i_should_see_the_message(String string) {
	   try {
		String actualAddPayeeSuccessMsg = addPayeepage.addPayeeAlertmsg();
		String exceptedAddPayeeSuccessMsg = PropertiesManager.getProperty("addPayyeAccount.success.msg");
		assertEquals(exceptedAddPayeeSuccessMsg, actualAddPayeeSuccessMsg);
		   log.info("Add payee success message is matched");
		addPayeepage.acceptAddPayeeAlert();
		
	} catch (AssertionError ae) {
		   log.error("Assertion failed : add payee success message is mismatched" , ae );
	}catch (Exception e) {
		   log.error("An exception error occured while  seeing account details added successful message" ,e );
	}
	}
	
	

}
