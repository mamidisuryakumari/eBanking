package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;




public class UserRegistrationPage {
	
	private TestContext context;
	
	public UserRegistrationPage(TestContext context) {
		this.context = context;
	}

	
	private  final By firstNameTextFld = By.id("fname");
	private  final By lastNameTextFld = By.id("lname");
	private  final By emailAddressFld = By.id("email");
	private  final By mobileNUmberFld = By.id("mobno");
	private  final By passwordFld = By.id("password");
	private  final By registerAccountBtn = By.id("submit");
	
	
	public String getRegistrationPageTitle() {
		return context.getBot().getTitle();
	}
	
	public UserRegistrationPage acceptUserRegistration () {
	String actualUserRegistrationSuccessMsg =	context.getBot().getAlertMessage();
	context.setActualUserRegistrationSuccessMsg(actualUserRegistrationSuccessMsg);
		context.getBot().acceptAlert();
		return this;
	}
	
	
	
	
	public UserLoginPage addRegistrationDetails(String firstName,String lastName, String emailId, String mobileNumber,String password) {
		
		
		context.getBot().enterText(firstNameTextFld, firstName)
		.enterText(lastNameTextFld, lastName)
		.enterText(emailAddressFld, emailId)
		.enterText( mobileNUmberFld, mobileNumber)
		.enterText(passwordFld, password)
		.click(registerAccountBtn);
		
		context.setUserEmailId(emailId);
		context.setUserPassword(password);
	
		return new UserLoginPage(context);
	}

	

	
}
