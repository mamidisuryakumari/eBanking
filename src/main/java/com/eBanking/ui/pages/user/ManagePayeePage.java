package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.Page;

public class ManagePayeePage extends Page {

	private static By managePayeeText = By.xpath("//h1[text()='Manage Payee']");
	private static final By deleteLink = By.xpath("//a[text()='Delete']");
	private static final By transferLink = By.xpath("//a[text()='Transfer']");
	private static By transactionHistoryLink = By.xpath("//span[text()='Transaction History']");
	private static By searchTextFld = By.xpath("//input[@type='search']");
	
	public ManagePayeePage searchPayeeName(String payeeName) {
		bot.enterText(searchTextFld, payeeName);
		return this;
	}
	
	public UserTransactionHistoryPage iNavigatedToTransactionHistoryPage() {
			bot.click(transactionHistoryLink);
		return new UserTransactionHistoryPage();
	}
	
	
	public TransferAmountPage iNavigatedToTranferAmountPage() {
		bot.click(transferLink);
		return new TransferAmountPage();
	}

	public String getManagePayeeText() {
		return bot.getText(managePayeeText);
	}

	public ManagePayeePage deletePayee() {
		bot.click(deleteLink).acceptAlert();
		return this;
	}

	public String deleteSuccessMsg() {
		return bot.getAlertMessage();
	}
	
	public ManagePayeePage acceptdeleteMsg() {
		bot.acceptAlert();
		return this;
	}
}
