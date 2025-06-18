package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.Bot;
import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.user.UserForgotPasswordpage;
import com.eBanking.ui.pages.user.UserLoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
@Slf4j
public class UserForgotPasswordSteps {
	
	private TestContext context;
	private UserLoginPage userLoginPage;
	private UserForgotPasswordpage userForgotPasswordpage;
	
	public UserForgotPasswordSteps() {
		this.context = context;
		this.userLoginPage = new UserLoginPage(context);
		this.userForgotPasswordpage = new UserForgotPasswordpage(context);
	}

	
	@When("I go to the forgot Password page")
	public void iGoToTheForgotPasswordPage() {
		try {
			userLoginPage.navigatedToForgotPasswordPage();
			log.info("I go to the forgot password page successfully");
		} catch (Exception e) {
			log.error("An exception error occured while going to the forgot password page", e);
			throw e;
	}
	}
	
	@Then("I should be navigated to the user forgot password page")
	public void iShouldBeNavigatedToTheUserForgotPasswordPage() {
		try {
			String actualForgotPasswordText = userForgotPasswordpage.getForgotPasswordText();
			String exceptedForgotPasswordText = PropertiesManager.getProperty("forgotPassword.text");
			assertEquals(exceptedForgotPasswordText, actualForgotPasswordText);
			log.info("Forgot password text is matched");
		}catch (AssertionError ae) {
			log.error("Assertion failed : Forgot password text is mismatched" , ae );
			throw ae;
		}catch (Exception e) {
			log.error("An exception error occured while navigating to the forgot password page" , e);
			throw e;
		}
	}
	
	
	@When("I enter forgot password details")
	public void iEnterForgotPasswordDetails(DataTable forgotPasswordDetails) {
		try {
			var forgotPasswordDetailsMap = forgotPasswordDetails.asMap(String.class, String.class);
			userForgotPasswordpage.enterForgotPasswordDetails(
					forgotPasswordDetailsMap.get("E-mail address"),
					forgotPasswordDetailsMap.get("Mobile number"),
					forgotPasswordDetailsMap.get("New Password"),
					forgotPasswordDetailsMap.get("Confirm Password"));
			log.info("Forgot password details entered successfully");
		} catch (Exception e) {
			log.error("An exception error occured while entering forgot password details" ,e);
			throw e;
		}
	}
   
  @Then("I should see Password changed succesfully")
  public void iShouldSeePasswordChangedSuccessfully() {
	  try {
		String actualPasswordChangeSuccessMsg = userForgotPasswordpage.getPasswordChangeSuccessMsg();
		String exceptedPasswordChangeSuccessMsg = PropertiesManager.getProperty("forgot.password.success.message");
		assertEquals(exceptedPasswordChangeSuccessMsg, actualPasswordChangeSuccessMsg);
		  log.info("Password changed success message ia matched");
		userForgotPasswordpage.acceptPasswordChangeSuccessMsgAlert();
	} catch (AssertionError ae) {
		  log.error("Assertion failed while verifying password changed success message" , ae);
		throw ae;
	}catch (Exception e) {
		  log.error("An exception error occured while seeing paasword changed successfully", e);
		throw e;
	}
  }

}
