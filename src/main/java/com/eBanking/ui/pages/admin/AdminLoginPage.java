package com.eBanking.ui.pages.admin;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.Page;

public class AdminLoginPage extends Page {

	private static By enterEmailAddressFld = By.id("email");
	private static By passwordFld = By.id("password");
	private static By loginBtn = By.name("login");

	public String getAdminLoginPageTitle() {
		return bot.getTitle();
	}

	public AdminDashBoardPage adminLogin(String email, String password) {
		bot.enterText(enterEmailAddressFld, email);
		bot.enterText(passwordFld, password);
		bot.click(loginBtn);
		return new AdminDashBoardPage();
	}

}
