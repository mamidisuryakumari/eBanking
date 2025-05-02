package com.eBanking.pages;

import org.openqa.selenium.WebDriver;

public class AdminDashBoardPage {
	
	private WebDriver driver;

	public AdminDashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAdminDashBoardPageTitle() {
		return driver.getTitle();
	}
	

}
