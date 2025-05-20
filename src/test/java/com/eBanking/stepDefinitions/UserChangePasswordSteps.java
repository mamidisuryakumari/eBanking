package com.eBanking.stepDefinitions;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.user.UserChangePasswordPage;
import com.eBanking.ui.pages.user.UserDashboardPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserChangePasswordSteps {
	
	private static final Logger logger = LoggerFactory.getLogger(UserChangePasswordSteps.class);
	UserDashboardPage userDashboardPage = new UserDashboardPage();
	UserChangePasswordPage userChangePasswordPage = new UserChangePasswordPage();
	
	@When("I go to the change password page")
	public void iGoToTheChangePasswordPage() {
		try {
			userDashboardPage.iNavigatedToTheChangePasswordPage();
			logger.info("Go to the change password page successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while going to the change password page" , e);
			throw e;
		}
	}
	 @Then("I should be navigated to the change password page")
	 public void iNavigatedTiTheChangePasswordPage() {
		 try {
			String actualChangePasswordText = userChangePasswordPage.getChangePasswordLabelText();
			String ExceptedChangePasswordText = PropertiesManager.getProperty("expected.changePassword.text");
			assertEquals(ExceptedChangePasswordText, actualChangePasswordText);
			logger.info("Change password text is matched");
		}catch (AssertionError ae) {
			logger.error("Assertion filed verifying change password text" ,ae);
			throw ae;
		} catch (Exception e) {
			logger.error("An exception error occured while navigating to the change password page");
			throw e;
		}
	 }
	  @When("I enter change password details")
	  public void enterPasswordDetails(DataTable enterPasswordDetails) {
		  try {
			var enterPasswordDetailsMap = enterPasswordDetails.asMap();
			userChangePasswordPage.enterChangePasswordDetails(
					enterPasswordDetailsMap.get("Current password"), 
					enterPasswordDetailsMap.get("New password"), 
					enterPasswordDetailsMap.get("Confirm password"));
			logger.info("Enter password details successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while entering change password details", e);
			throw e;
		}
	  }
	    
	   @Then("I should see password changed successfully")
	   public void passwordChangedSuccessfully() {
		  try {
			String actualPasswordChangeAlertMsg = userChangePasswordPage.getPasswordChangedAlertMessage();
			String exceptedPasswordChangeAlertMsg = PropertiesManager.getProperty("changePassword.success.message");
			assertEquals(exceptedPasswordChangeAlertMsg, actualPasswordChangeAlertMsg);
			logger.info("Password change alert message is matched");
			userChangePasswordPage.acceptPasswordChangedAlertMessage();
		} catch (AssertionError ae) {
			logger.error("Password changed alert message is mismatched" , ae);
			throw ae;
		}catch (Exception e) {
			logger.error("An exception error occured while seeing password changed message" , e);
			throw e;
		} 
	   }

}
