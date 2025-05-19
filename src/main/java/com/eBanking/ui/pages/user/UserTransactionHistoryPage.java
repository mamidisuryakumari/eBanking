package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.Page;

public class UserTransactionHistoryPage extends Page{
	
	private static By transactionHistoryText = By.xpath("//h1[text()='Transaction History']");
	private static By latestTransactionStatus = By.xpath("//table//tbody//tr[1]/td[6]");
	
	public String getTransactionHistoryText() {
		return bot.getText(transactionHistoryText);
	}
	
	public String getLatestTransactionStatus() {
		return bot.getText(latestTransactionStatus);
	}
	

}
