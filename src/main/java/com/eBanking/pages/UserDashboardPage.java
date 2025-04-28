package com.eBanking.pages;

import org.openqa.selenium.WebDriver;

public class UserDashboardPage {
	
	private WebDriver driver;

	public UserDashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getUserDashboardPage() {
	return	driver.getTitle();
	}

}
