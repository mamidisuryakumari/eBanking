package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;

public class UserChangePasswordPage  {
	
private TestContext context;
	
	public UserChangePasswordPage(TestContext context) {
		this.context = context;
	}

	private static final By changePasswordLabel = By.xpath("//h3[text()='Home/Change Password']");
	private static final By currectPasswordFld = By.id("currentpassword");
	private static final By newpasswordFld = By.id("newpassword");
	private static final By confirmPasswordFld = By.id("confirmpassword");
	private static final By changeBtn = By.id("submit");

	public String getChangePasswordLabelText() {
		return context.getBot().getText(changePasswordLabel);
	}
	
	public UserChangePasswordPage enterChangePasswordDetails(String currentPassword, String newPassword, String confirmPassword) {
		context.getBot().enterText(currectPasswordFld, currentPassword)
		.enterText(newpasswordFld, newPassword)
		.enterText(confirmPasswordFld, confirmPassword)
		.click(changeBtn);
		return this;
	}
	
	public String getPasswordChangedAlertMessage() {
		return context.getBot().getAlertMessage();
	}
	
	public UserChangePasswordPage acceptPasswordChangedAlertMessage() {
		context.getBot().acceptAlert();
		return this;
	}

}
