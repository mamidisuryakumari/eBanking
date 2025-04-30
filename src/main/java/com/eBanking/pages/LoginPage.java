package com.eBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.Elements;

public class LoginPage {
	
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	private By createAnAccountlink = By.xpath("//a[text()='Create an Account!']");
	private By emailTextFld = By.id("email");
	private By passwordTextFld = By.id("password");
	private By loginBtn = By.xpath("//button[normalize-space(text())='Login']");
	
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
