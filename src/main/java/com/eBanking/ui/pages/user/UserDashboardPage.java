package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.ui.pages.Page;
import com.eBanking.utilities.BrowserUtils;
import com.eBanking.utilities.Elements;

public class UserDashboardPage extends Page{

	

	private static By accountOpeninigoption = By.xpath("//span[text()='Account Openning']");
	private static By payeeoption = By.xpath("//span[text()='Payee / Beneficiary']");
	private static By addLink = By.xpath("//a[text()='Add']");
	private static By manageLink = By.xpath("//a[text()='Manage']");

	public boolean isOnUserDashboardPage() {
		String expectedTitle = "e-Banking | User Dashboard";
		return BrowserUtils.verifyTitle(driver, expectedTitle);
	}

	public AccountDetailsPage clickOnAccountOpening() {
		Elements.doClick(driver, accountOpeninigoption);
		return new AccountDetailsPage();
	}

	public UserDashboardPage clickOnPayeeOption() {
		Elements.doClick(driver, payeeoption);
		return this;
	}
	
	public UserPage clickOnAddLink() {
		Elements.doClick(driver, addLink);
		return new UserPage();
	}
	
	public UserPage managePayee() {
		Elements.doClick(driver, manageLink);
		return new UserPage();
	}
}
