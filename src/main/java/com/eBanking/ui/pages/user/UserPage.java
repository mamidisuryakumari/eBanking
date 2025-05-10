package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.AlertUtil;
import com.eBanking.utilities.Elements;

import io.cucumber.datatable.DataTable;

public class UserPage {
	
	private WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
	}

	private static final By PayeeorBeneficiaryAccountNumber = By.id("accountnumber");
	private static final By PayeeorBeneficiaryconfirmAccountNumber = By.id("conaccountnumber");
	private static final By pbAccountHolderName = By.id("acountholdername");
	private static final By submitBtn = By.id("submit");
	private static final By searchFld = By.xpath("//input[@type='search']");
	private static final By deleteLink = By.xpath("//a[text()='Delete']");
	private static final By transferLink = By.xpath("//a[text()='Transfer']");
	private static final By amonutFld = By.name("amount");
	private static final By transferSubmitBtn = By.id("submit");
	
	
	public UserPage userAddPayeeAccountDetails(DataTable payeeAccountDetailsTable) {
		var payeeAccountDetailsMap = payeeAccountDetailsTable.asMap();
		var payeeAccountDetails = payeeAccountDetailsMap;
		
		var accountNumber = payeeAccountDetails.get("Account Number");
		var confirmAccountNumber = payeeAccountDetails.get("Confirm Account Number");
		var accountHolderName = payeeAccountDetails.get("Account Holder Name");
		Elements.doSendKeys(driver, PayeeorBeneficiaryAccountNumber, accountNumber);
		Elements.doSendKeys(driver, PayeeorBeneficiaryconfirmAccountNumber, confirmAccountNumber);
		Elements.doSendKeys(driver, pbAccountHolderName,accountHolderName);
		Elements.doClick(driver, submitBtn);
		return this;
		
		
	}
	
	public UserPage userAddPayeeAccountDetails(String accountNumber,String confirmAccountNumber,String accountHolderName ) {
		Elements.doSendKeys(driver, PayeeorBeneficiaryAccountNumber, accountNumber);
		Elements.doSendKeys(driver, PayeeorBeneficiaryconfirmAccountNumber, confirmAccountNumber);
		Elements.doSendKeys(driver, pbAccountHolderName,accountHolderName);
		Elements.doClick(driver, submitBtn);
		return this;
	}
	
	public UserPage userDeletePayee(String Deletepayee) {
		Elements.doSendKeys(driver, searchFld, Deletepayee);
		Elements.doClick(driver, deleteLink);
		AlertUtil.acceptAlert(driver);
		return this;
	}
	
	public UserPage trasferMoneyToPayee(String moneytTransferToPayee,String transferAmount) {
		Elements.doSendKeys(driver, searchFld, moneytTransferToPayee);
		Elements.doClick(driver, transferLink);
		Elements.doSendKeys(driver, amonutFld, transferAmount);
		Elements.doClick(driver, transferSubmitBtn);
		return this;
	}
}
