package com.eBanking.pages.user;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.CommonUtils;
import com.eBanking.utilities.DropdownUtil;
import com.eBanking.utilities.Elements;

public class AccountDetailsPage {
	
	private WebDriver driver;

	public AccountDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	

	private static By accountDetailsText = By.xpath("//h3[text()='Account Details']");
	private static By AddressProffDropdown = By.xpath("//select[@name='addproof']");
	private static By addressProffIDNumberFld = By.xpath("//input[@id='addpidnum']");
	private static By pancardNumberFld = By.id("pancardnum");
	private static By addressFld = By.name("address");
	private static By submitBtn = By.id("submit");
	private static By acceptCheckbox = By.id("tandc");
	private static By dobDate = By.id("dob");
	
	private static By uploadAddressProffFilePath = By.xpath("//input[@id='attaddproof']");
	private static By uploadPanCardFilePath = By.id("uplpancard");
	
	public String getAccountDetailsText() {
	return Elements.getText(driver, accountDetailsText);
	}
	
	public UserDashboardPage enterAccountDetails(String addressProffIDNumber,String pancardNumber,String address,String dob) throws IOException{
		DropdownUtil.selectByValue(driver, AddressProffDropdown,CommonUtils.getProperties().getProperty("addressProof"));
		Elements.doJsSendKeys(driver, addressProffIDNumberFld, addressProffIDNumber);
		Elements.doSendKeys(driver, uploadAddressProffFilePath,CommonUtils.getProperties().getProperty("uploadAddressProofFilePath"));
		Elements.doSendKeys(driver, uploadPanCardFilePath,CommonUtils.getProperties().getProperty("uploadPancardFilepath"));
		Elements.doSendKeys(driver, pancardNumberFld, pancardNumber);
		Elements.doSendKeys(driver, addressFld, address);
		Elements.doSendKeys(driver, dobDate, dob);
		Elements.selectCheckbox(driver, acceptCheckbox);
		Elements.doClick(driver, submitBtn);
		return new UserDashboardPage(driver);
	}
	
	
}
