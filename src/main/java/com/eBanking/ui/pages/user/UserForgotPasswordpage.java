package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.Page;

public class UserForgotPasswordpage extends Page {

	private static final By forgotPasswordLabel = By.xpath("//h1[text()='Forgot Password!']");
	private static final By emailAddressFld = By.name("email");
	private static final By mobileNumberFld = By.name("mobile");
	private static final By newPasswordFld = By.name("newpassword");
	private static final By confirmPasswordFld = By.name("confirmpassword");
	private static final By resetBtn = By.name("submit");

	public String getForgotPasswordText() {
		return bot.getText(forgotPasswordLabel);
	}

	public UserForgotPasswordpage enterForgotPasswordDetails(String emilAddress, String mobileNumber, String newPassword,
			String confirmPassword) {
		{
			bot.enterText(emailAddressFld, emilAddress).enterText(mobileNumberFld, mobileNumber)
					.enterText(newPasswordFld, newPassword).enterText(confirmPasswordFld, confirmPassword)
					.click(resetBtn);
			return this;
		}
	}
	
	public String getPasswordChangeSuccessMsg() {
		return bot.getAlertMessage();
	}
	
	public UserForgotPasswordpage acceptPasswordChangeSuccessMsgAlert() {
		bot.acceptAlert();
		return this;
	}

}
