package com.eBanking.ui.pages;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.user.UserLoginPage;
import com.eBanking.utilities.Elements;

public class HomePage extends Page {

	

	private static By userMenuLink = By.xpath("(//a[contains(.,'Account Holder')])[2]");
	private static By adminMenuLink = By.xpath("(//a[text()='Admin'])[2]");

	public UserLoginPage iNavigatedToUserLoginPage() {
		bot.click(userMenuLink);
		return new UserLoginPage();
	}

	

	public UserLoginPage iNavigatedToAdminLoginPage() {
		Elements.doJsClick(driver, adminMenuLink);
		return new UserLoginPage();
	}
}
