package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.Page;

public class TransferAmountPage extends Page{
	
	private static final By transferAmountText = By.xpath("//h3[text()='Transfer Amount']");
	private static final By amonutFld = By.name("amount");
	private static final By transferSubmitBtn = By.id("submit");
	
	public String getTransferAmountText() {
		return bot.getText(transferAmountText);
	}
	
	public ManagePayeePage trasferAmount(String transferAmount) {
		bot.enterText(amonutFld, transferAmount)
		.click(transferSubmitBtn);
		return new ManagePayeePage();
		}

	public String getTransferamountalertMsg() {
		return	bot.getAlertMessage();
		}
	
	public ManagePayeePage acceptTransactionDetails() {
		bot.acceptAlert();
		return new ManagePayeePage();
	}
}
