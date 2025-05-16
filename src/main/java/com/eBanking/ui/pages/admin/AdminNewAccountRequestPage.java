package com.eBanking.ui.pages.admin;

import java.io.IOException;

import org.openqa.selenium.By;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;

public class AdminNewAccountRequestPage extends Page{
	
	private static final By viewLink = By.xpath("//a[text()='View ']");
	
	
	
	public String getAdminNewAccountRequestPage() {
		return bot.getTitle();
	}
	
	
	public AdminAccountholderDetailsPage adminNavigateToAccountHolderDetailsPage() {
		bot.click(viewLink);
		return new AdminAccountholderDetailsPage();
	}

}
