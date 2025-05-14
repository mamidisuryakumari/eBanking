package com.eBanking.ui.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.ui.pages.Page;
import com.eBanking.utilities.BrowserUtils;
import com.eBanking.utilities.Elements;

public class AdminLoginPage extends Page{
	
	
	
	private static By enterEmailAddressFld = By.id("email");
	private static By passwordFld = By.id("password");
	private static By loginBtn = By.name("login");
	
	public boolean isOnAdminLoginPage() {
		String exceptedAdminLoginPageTitle = "e-Banking | Admin";
		return BrowserUtils.verifyTitle(driver, exceptedAdminLoginPageTitle);
	}
	
	public void adminLogin(String email, String password) {
		Elements.doSendKeys(driver, enterEmailAddressFld, email);
		Elements.doSendKeys(driver, passwordFld, password);
		Elements.doClick(driver, loginBtn);
	//	return new AdminDashBoardPage();
	}

}
