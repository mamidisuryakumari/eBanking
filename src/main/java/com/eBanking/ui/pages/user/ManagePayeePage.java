package com.eBanking.ui.pages.user;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.pages.admin.ApporvedAccountOpeningRequestsPage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ManagePayeePage extends BasePage {

	private TestContext context;
	private ApporvedAccountOpeningRequestsPage apporvedAccountOpeningRequests;

	public ManagePayeePage(TestContext context) {
		super(context);
		this.context = context;
		this.apporvedAccountOpeningRequests = new ApporvedAccountOpeningRequestsPage(context);
	}

	private final By managePayeeText = By.xpath("//h1[text()='Manage Payee']");
	private final By deleteLink = By.xpath("//a[text()='Delete']");
	private final By transferLink = By.xpath("//a[text()='Transfer']");
	private final By transactionHistoryLink = By.xpath("//span[text()='Transaction History']");
	private final By searchTextFld = By.xpath("//input[@type='search']");
	private final By managePayeeListFields = By.xpath("//tbody/tr/td[2]");

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

	public List<String> managePayeeAccountHolderList() {
		List<WebElement> managePayeeAccountHolderNamesList = context.getDriver().findElements(managePayeeListFields);
		List<String> availableNamesInManagePayeeAccount = new ArrayList<String>();
		for (WebElement name : managePayeeAccountHolderNamesList) {
			availableNamesInManagePayeeAccount.add(name.getText());
			context.setManagePayyeAccount(availableNamesInManagePayeeAccount);
		}
		System.out.println("Available account holders in User "+availableNamesInManagePayeeAccount);
		return availableNamesInManagePayeeAccount;

	}

	public String getPayeeName() {
		List<String> approvedAccountsList = apporvedAccountOpeningRequests.listOfAccountHolders();
		List<String> existingList = context.getManagePayyeAccount();
		System.out.println("Available account holders in User "+existingList);
		String payeeToAdd = null;

		for (String name : approvedAccountsList) {
			if (!existingList.contains(name)) {
				existingList.add(name);
				payeeToAdd = name;
				context.setPayeeName(payeeToAdd);
				return  name;

			}

		}

		if (payeeToAdd == null) {
			throw new RuntimeException("No available payee names left to add.");
		} else {
			System.out.println("Available name: " + payeeToAdd);
		}
		return payeeToAdd;
	}
}
