package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;




public class UserLoginPage{
	
	private TestContext context;
	
	public UserLoginPage(TestContext context) {
		this.context = context;
	}
	
	private  final By userRegistrationLink = By.xpath("//a[text()='Create an Account!']");
	private  final By emailTextFld = By.id("email");
	private  final By passwordTextFld = By.id("password");
	private final  By loginBtn = By.xpath("//button[normalize-space(text())='Login']");
	private  final By forgotPasswordLink = By.xpath("//a[text()='Forgot Password?']");
	
	public String getUserLoginPageTitle() {
		return context.getBot().getTitle();
	}
	

	public UserForgotPasswordpage navigatedToForgotPasswordPage() {
		context.getBot().click(forgotPasswordLink);
		return new UserForgotPasswordpage(context);
	}
	
	public UserRegistrationPage goToRegistrationPage() {
		context.getBot().click(userRegistrationLink);
		return new UserRegistrationPage(context);
	}
	
	public UserDashboardPage loginUser(String email,String password) {
		context.getBot().enterText(emailTextFld, email)
		.enterText(passwordTextFld, password)
		.click(loginBtn);
		return new UserDashboardPage(context);
	}

}
