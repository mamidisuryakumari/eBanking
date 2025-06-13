package com.eBanking.ui.pages.user;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;

public class ManagePayeePage extends BasePage {
	
private TestContext context;
	
	public ManagePayeePage(TestContext context) {
        super(context);
        this.context = context;
	}

	private final By managePayeeText = By.xpath("//h1[text()='Manage Payee']");
	private  final By deleteLink = By.xpath("//a[text()='Delete']");
	private  final By transferLink = By.xpath("//a[text()='Transfer']");
	private final By transactionHistoryLink = By.xpath("//span[text()='Transaction History']");
	private final By searchTextFld = By.xpath("//input[@type='search']");
	
	public ManagePayeePage searchPayeeName(String payeeName) {
		context.getBot().enterText(searchTextFld, payeeName);
		return this;
	}
	
	public UserTransactionHistoryPage iNavigatedToTransactionHistoryPage() {
		context.getBot().click(transactionHistoryLink);
		return new UserTransactionHistoryPage(context);
	}
	
	
	public TransferAmountPage iNavigatedToTranferAmountPage() {
		context.getBot().click(transferLink);
		return new TransferAmountPage(context);
	}

	public String getManagePayeeText() {
		return context.getBot().getText(managePayeeText);
	}

	public ManagePayeePage deletePayee() {
		context.getBot().click(deleteLink).acceptAlert();
		return this;
	}

	public String deleteSuccessMsg() {
		return context.getBot().getAlertMessage();
	}
	
	public ManagePayeePage acceptdeleteMsg() {
		context.getBot().acceptAlert();
		return this;
	}
}
