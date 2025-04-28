package com.eBanking.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.Elements;

public class RegistrationPage {
	
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By firstNameTextFld = By.id("fname");
	private By lastNameTextFld = By.id("lname");
	private By emailAddressFld = By.id("email");
	private By mobileNUmberFld = By.id("mobno");
	private By passwordFld = By.id("password");
	private By registerAccountBtn = By.id("submit");
	
	public LoginPage registerUserAccount(String firstName,String lastName, String eamilAddress,String mobileNumber,String password) {
		Elements.doSendKeys(driver, firstNameTextFld, firstName);
		Elements.doSendKeys(driver, lastNameTextFld, lastName);
		Elements.doSendKeys(driver, emailAddressFld, eamilAddress);
		Elements.doSendKeys(driver, mobileNUmberFld, mobileNumber);
		Elements.doSendKeys(driver, passwordFld, password);
		Elements.doClick(driver, registerAccountBtn);
		return new LoginPage(driver);
	}
}
