package com.eBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.Elements;

public class HomePage {
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By userMenu = By.xpath("(//a[text()='User/Account Holder'])[2]");
	private By adminMenu = By.xpath("(//a[text()='Admin'])[2]");
	
	public LoginPage clickOnUserMenu() {
		Elements.doJsClick(driver, userMenu);
		return new LoginPage(driver);
	}
	
	public String getHomePageTitle() {
	return	driver.getTitle();
	}
	

}
