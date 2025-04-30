package com.eBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.Elements;

public class UserDashboardPage {
	
	private WebDriver driver;

	public UserDashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
private static By accountOpeninigoption = By.xpath("//span[text()='Account Openning']");
	
	public String getUserDashboardPage() {
	return	driver.getTitle();
	}
	
	public AccountDetailsPage clickOnAccountOpening() {
		Elements.doClick(driver, accountOpeninigoption);
		return new AccountDetailsPage(driver);
	}

}
