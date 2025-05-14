package com.eBanking.ui.pages.user;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.ui.pages.Page;
import com.eBanking.utilities.BrowserUtils;
import com.eBanking.utilities.CommonUtils;
import com.eBanking.utilities.Elements;



public class UserRegistrationPage extends Page {

	
	private static final By firstNameTextFld = By.id("fname");
	private static final By lastNameTextFld = By.id("lname");
	private static final By emailAddressFld = By.id("email");
	private static final By mobileNUmberFld = By.id("mobno");
	private static final By passwordFld = By.id("password");
	private static final By registerAccountBtn = By.id("submit");

	
	
	public UserLoginPage addRegistrationDetails(String firstName,String lastName, String emailId, String mobileNumber,String password) {
		Elements.doSendKeys(driver, firstNameTextFld, firstName);
		Elements.doSendKeys(driver, lastNameTextFld, lastName);
		Elements.doSendKeys(driver, emailAddressFld, emailId);
		Elements.doSendKeys(driver, mobileNUmberFld, mobileNumber);
		Elements.doSendKeys(driver, passwordFld, password);
		Elements.doClick(driver, registerAccountBtn);
		return new UserLoginPage();
	}

	

	
}
