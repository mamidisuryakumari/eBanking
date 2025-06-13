package com.eBanking.ui.pages.user;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;

public class UserForgotPasswordpage extends BasePage {
	
private TestContext context;
	
	public UserForgotPasswordpage(TestContext context) {
        super(context);
        this.context = context;
	}

	private  final By forgotPasswordLabel = By.xpath("//h1[text()='Forgot Password!']");
	private  final By emailAddressFld = By.name("email");
	private  final By mobileNumberFld = By.name("mobile");
	private  final By newPasswordFld = By.name("newpassword");
	private  final By confirmPasswordFld = By.name("confirmpassword");
	private  final By resetBtn = By.name("submit");

	public String getForgotPasswordText() {
		return context.getBot().getText(forgotPasswordLabel);
	}

	public UserForgotPasswordpage enterForgotPasswordDetails(String emilAddress, String mobileNumber, String newPassword,
			String confirmPassword) {
		{
			context.getBot().enterText(emailAddressFld, emilAddress).enterText(mobileNumberFld, mobileNumber)
					.enterText(newPasswordFld, newPassword).enterText(confirmPasswordFld, confirmPassword)
					.click(resetBtn);
			return this;
		}
	}
	
	public String getPasswordChangeSuccessMsg() {
		return context.getBot().getAlertMessage();
	}
	
	public UserForgotPasswordpage acceptPasswordChangeSuccessMsgAlert() {
		context.getBot().acceptAlert();
		return this;
	}

}
