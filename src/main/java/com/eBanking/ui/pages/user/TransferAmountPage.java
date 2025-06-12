package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;

public class TransferAmountPage {
	
private TestContext context;
	
	public TransferAmountPage(TestContext context) {
		this.context = context;
	}
	
	private final By transferAmountText = By.xpath("//h3[text()='Transfer Amount']");
	private  final By amonutFld = By.name("amount");
	private  final By transferSubmitBtn = By.id("submit");
	
	public String getTransferAmountText() {
		return context.getBot().getText(transferAmountText);
	}
	
	public ManagePayeePage trasferAmount(String transferAmount) {
		context.getBot().enterText(amonutFld, transferAmount)
		.click(transferSubmitBtn);
		return new ManagePayeePage(context);
		}

	public String getTransferamountalertMsg() {
		return	context.getBot().getAlertMessage();
		}
	
	public ManagePayeePage acceptTransactionDetails() {
		context.getBot().acceptAlert();
		return new ManagePayeePage(context);
	}
}
