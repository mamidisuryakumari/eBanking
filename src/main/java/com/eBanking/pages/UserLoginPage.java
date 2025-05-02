package com.eBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.Elements;

public class UserLoginPage {
	
	
	private WebDriver driver;
	
	public UserLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	private static By createAnAccountlink = By.xpath("//a[text()='Create an Account!']");
	private static By emailTextFld = By.id("email");
	private static By passwordTextFld = By.id("password");
	private static By loginBtn = By.xpath("//button[normalize-space(text())='Login']");
	

	
	public String getLoginPageTitle() {
	return	driver.getTitle();
	}
	
	public RegistrationPage createAccount() {
		Elements.doClick(driver, createAnAccountlink);
		return new RegistrationPage(driver);
	}
	
	public UserDashboardPage loginUser(String email,String password) {
		Elements.doSendKeys(driver, emailTextFld, email);
		Elements.doSendKeys(driver, passwordTextFld, password);
		Elements.doClick(driver, loginBtn);
		return new UserDashboardPage(driver);
	}

}
