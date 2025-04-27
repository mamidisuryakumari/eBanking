package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utilities.Elements;

public class AdvancedRegisterPages {
	
	private WebDriver driver;

	public AdvancedRegisterPages(WebDriver driver) {
		this.driver = driver;
	}
	
	public static By userNameFld = By.id("username");
	public static By passwordFld = By.id("password");
	public static By emailFld = By.id("email");
	public static By femaleRadioBtn = By.xpath("//input[@id='female']");
	public static By moviesCheckBox = By.id("movies");
	public static By countryDropdown = By.id("country");
	public static By dateFld = By.id("dob");
	public static By registerBtn = By.xpath("//button[text()='Register']");
	public static By registrationSuccessfullMsg = By.xpath("//p[text()='Registration Successful!']");
	public static By closeBtn = By.xpath("//button[text()='Close']");
	public static By  clodeSymbol =By.xpath("//span[text()='×']");
	
	
	public String getAdvancedRegisterTitle() {
	return 	driver.getTitle();
	}

	
public AdvancedRegisterPages enterDetails(String username, String password, String email) {
	Elements.doSendKeys(driver, userNameFld, username);
	Elements.doSendKeys(driver, passwordFld, password);
	Elements.doSendKeys(driver, emailFld, email);
	Elements.doClick(driver, femaleRadioBtn);
	return this;
}
	
public AdvancedRegisterPages clickOnRegisterBtn() {
	Elements.doClick(driver, registerBtn);
	return this;
}

}
