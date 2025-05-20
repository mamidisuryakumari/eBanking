package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.Page;




public class UserLoginPage extends Page{
	
	
	
	private static final By createAnAccountlink = By.xpath("//a[text()='Create an Account!']");
	private static final By emailTextFld = By.id("email");
	private static final By passwordTextFld = By.id("password");
	private static final  By loginBtn = By.xpath("//button[normalize-space(text())='Login']");
	private static final By forgotPasswordLink = By.xpath("//a[text()='Forgot Password?']");
	
	UserRegistrationPage registrationPage = new UserRegistrationPage();
	

	
	public UserForgotPasswordpage iNavigatedToForgotPasswordPage() {
		bot.click(forgotPasswordLink);
		return new UserForgotPasswordpage();
	}
	
	public UserRegistrationPage createAccount() {
		bot.click(createAnAccountlink);
		return new UserRegistrationPage();
	}
	
	public UserDashboardPage loginUser(String email,String password) {
		
		bot.enterText(emailTextFld, email)
		.enterText(passwordTextFld, password)
		.click(loginBtn);
		return new UserDashboardPage();
	}

}
