package com.eBanking.ui.pages.user;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class UserLoginPage extends BasePage {
	
	private TestContext context;
	
	public UserLoginPage(TestContext context) {
        super(context);
        this.context = context;
	}
	
	private  final By userRegistrationLink = By.xpath("//a[text()='Create an Account!']");
	private  final By emailTextFld = By.id("email");
	private  final By passwordTextFld = By.id("password");
	private final  By loginBtn = By.xpath("//button[normalize-space(text())='Login']");
	private  final By forgotPasswordLink = By.xpath("//a[text()='Forgot Password?']");
	private final By expectedMsg = By.xpath("//h1[text()='Dashboard']");

	public String getExpectedDashboardText(){
		 return context.getBot().getText(expectedMsg).trim();
	}
	public String getEmailFormatErrorMessage() {

		context.getDriver().findElement(passwordTextFld).click(); // blur

		return context.getBot().getValidationMessage(emailTextFld).trim();
	}


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
		context.setUserEmailId(email);
		context.setUserPassword(password);
		return new UserDashboardPage(context);
	}

	public UserForgotPasswordpage goToTheUserForgotPasswordPage(){
		context.getBot().click(forgotPasswordLink);
		return new UserForgotPasswordpage(context);
	}

}
