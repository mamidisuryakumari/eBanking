package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.Page;

public class UserChangePasswordPage extends Page {

	private static final By changePasswordLabel = By.xpath("//h3[text()='Home/Change Password']");
	private static final By currectPasswordFld = By.id("currentpassword");
	private static final By newpasswordFld = By.id("newpassword");
	private static final By confirmPasswordFld = By.id("confirmpassword");
	private static final By changeBtn = By.id("submit");

	public String getChangePasswordLabelText() {
		return bot.getText(changePasswordLabel);
	}
	
	public UserChangePasswordPage enterChangePasswordDetails(String currentPassword, String newPassword, String confirmPassword) {
		bot.enterText(currectPasswordFld, currentPassword)
		.enterText(newpasswordFld, newPassword)
		.enterText(confirmPasswordFld, confirmPassword)
		.click(changeBtn);
		return this;
	}
	
	public String getPasswordChangedAlertMessage() {
		return bot.getAlertMessage();
	}
	
	public UserChangePasswordPage acceptPasswordChangedAlertMessage() {
		bot.acceptAlert();
		return this;
	}

}
