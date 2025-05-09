package com.eBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.pages.user.UserLoginPage;
import com.eBanking.utilities.BrowserUtils;
import com.eBanking.utilities.Elements;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By userMenu = By.xpath("(//a[text()='User/Account Holder'])[2]");
	private By adminMenu = By.xpath("(//a[text()='Admin'])[2]");

	public UserLoginPage clickOnUserMenu() {
		Elements.doJsClick(driver, userMenu);
		return new UserLoginPage(driver);
	}

	public boolean isOnHomePage() {
		String expTitle = "e-Banking System";
		return BrowserUtils.verifyTitle(driver, expTitle);
	}

	public UserLoginPage clickOnAdminMenu() {
		Elements.doJsClick(driver, adminMenu);
		return new UserLoginPage(driver);
	}

}
