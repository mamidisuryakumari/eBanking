package com.eBanking.ui.pages.user;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.BrowserUtils;
import com.eBanking.utilities.Elements;

import io.cucumber.datatable.DataTable;

public class UserLoginPage {
	
	
	private WebDriver driver;
	
	public UserLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	private static final By createAnAccountlink = By.xpath("//a[text()='Create an Account!']");
	private static final By emailTextFld = By.id("email");
	private static final By passwordTextFld = By.id("password");
	private static final  By loginBtn = By.xpath("//button[normalize-space(text())='Login']");
	

	
	public boolean isOnLoginPage() {
		String exceptedLoginPageTitle = "e-Banking | User Login";
		return BrowserUtils.verifyTitle(driver, exceptedLoginPageTitle);
	}
	
	public UserRegistrationPage createAccount() {
		Elements.doClick(driver, createAnAccountlink);
		return new UserRegistrationPage(driver);
	}
	
	public UserDashboardPage loginUser(DataTable loginDetailsTable) {
		var loginDetailsMap = loginDetailsTable.asMap();
		var loginDetails = loginDetailsMap;
		var email = loginDetails.get("Email Address");
		var password = loginDetails.get("Password");
		Elements.doSendKeys(driver, emailTextFld, email);
		Elements.doSendKeys(driver, passwordTextFld, password);
		Elements.doClick(driver, loginBtn);
		return new UserDashboardPage(driver);
		
	}
	
	public UserDashboardPage loginUser(String email,String password) {
		Elements.doSendKeys(driver, emailTextFld, email);
		Elements.doSendKeys(driver, passwordTextFld, password);
		Elements.doClick(driver, loginBtn);
		return new UserDashboardPage(driver);
	}

}
