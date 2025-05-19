package com.eBanking.ui.pages.user;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;

import com.eBanking.ui.engine.Bot;
import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;

public class AccountDetailsPage extends Page {

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
		return bot.getText(accountDetailsText);
	}

	public UserDashboardPage enterAccountDetails(String addressProffIDNumber, String pancardNumber, String address, String dob) {
		bot.selectByValue(AddressProffDropdown, PropertiesManager.getProperty("addressProof"))
				.enterText(addressProffIDNumberFld, addressProffIDNumber)
				.fileUpload(uploadAddressProffFilePath,System.getProperty("user.dir")+File.separator +PropertiesManager.getProperty("upload.AddressProof.FilePath").replace("/",File.separator))
				.fileUpload(uploadPanCardFilePath,System.getProperty("user.dir")+File.separator +PropertiesManager.getProperty("upload.pancard.FilePath").replace("/", File.separator))
				.enterText(pancardNumberFld, pancardNumber)
				.enterText(addressFld, address).enterText(dobDate, dob).checkCheckbox(acceptCheckbox).click(submitBtn);
		return new UserDashboardPage();
	}

	

}
