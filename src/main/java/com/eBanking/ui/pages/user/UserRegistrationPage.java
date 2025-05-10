package com.eBanking.ui.pages.user;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.BrowserUtils;
import com.eBanking.utilities.CommonUtils;
import com.eBanking.utilities.Elements;

import io.cucumber.datatable.DataTable;

public class UserRegistrationPage {

	private WebDriver driver;

	public UserRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	private static final By firstNameTextFld = By.id("fname");
	private static final By lastNameTextFld = By.id("lname");
	private static final By emailAddressFld = By.id("email");
	private static final By mobileNUmberFld = By.id("mobno");
	private static final By passwordFld = By.id("password");
	private static final By registerAccountBtn = By.id("submit");

	public boolean isOnRegistrationPage() {
		String exceptedRegistrationPageTitle = "e-Banking";
		return BrowserUtils.verifyTitle(driver, exceptedRegistrationPageTitle);
	}

	public UserLoginPage addRegistrationDetails(DataTable registrationDetailsTable) {
		var registrationDetailsMap = registrationDetailsTable.asMap();
		var registrationDetails = registrationDetailsMap;

		var firstName = registrationDetails.get("First Name");
		var lastName = registrationDetails.get("Last Name");
		var emilId = CommonUtils.getRandomNumber(10, 10000)+registrationDetails.get("Email Address");
		var mobileNumber = registrationDetails.get("Mobile Number");
		var password = registrationDetails.get("Password");
		
		Elements.doSendKeys(driver, firstNameTextFld, firstName);
		Elements.doSendKeys(driver, lastNameTextFld, lastName);
		Elements.doSendKeys(driver, emailAddressFld, emilId);
		Elements.doSendKeys(driver, mobileNUmberFld, mobileNumber);
		Elements.doSendKeys(driver, passwordFld, password);
		Elements.doClick(driver, registerAccountBtn);
		return new UserLoginPage(driver);
	}

	
}
