package com.eBanking.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.BrowserUtils;
import com.eBanking.utilities.Elements;

public class AdminDashBoardPage {

	private WebDriver driver;

	public AdminDashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	private static By newAccountRequestFld = By.xpath("//div[normalize-space(text())='New Account Requests']");

	public boolean isOnAdminDashBoardPage() {
		String expectedTitle = "e-Banking | Dashboard";
		return BrowserUtils.verifyTitle(driver, expectedTitle);
	}

	public AdminPage newAccountRequest() {
		Elements.doClick(driver, newAccountRequestFld);
		return new AdminPage(driver);
	}
}
