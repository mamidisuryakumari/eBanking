package com.eBanking.ui.pages;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.user.UserLoginPage;


public class HomePage extends Page {

	

	private static By userMenuLink = By.xpath("(//a[contains(.,'Account Holder')])[2]");
	private static By adminMenuLink = By.xpath("(//a[text()='Admin'])[2]");

	public UserLoginPage iNavigatedToUserLoginPage() {
		bot.jsClick(userMenuLink);
		return new UserLoginPage();
	}

	public String getHomePageTitle() {
		return bot.getTitle();
	}

	public UserLoginPage iNavigatedToAdminLoginPage() {
		bot.jsClick(adminMenuLink);
		return new UserLoginPage();
	}
}
