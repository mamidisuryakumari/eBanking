package com.eBanking.ui.pages.admin;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.Page;


public class AdminDashBoardPage extends Page{

	

	private static By newAccountRequestFld = By.xpath("//div[normalize-space(text())='New Account Requests']");
	
	public String getAdminDashboardPageTitle() {
		return bot.getTitle();
	}



	public AdminAccountholderDetailsPage adminNavigateToNewAccountRequestPage() {
		bot.click(newAccountRequestFld);
		return new AdminAccountholderDetailsPage();
	}
}
