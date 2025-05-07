package com.eBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.utilities.AlertUtil;
import com.eBanking.utilities.Elements;

public class UserPage {
	
	private WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
	}

	private static By PayeeorBeneficiaryAccountNumber = By.id("accountnumber");
	private static By PayeeorBeneficiaryconfirmAccountNumber = By.id("conaccountnumber");
	private static By pbAccountHolderName = By.id("acountholdername");
	private static By submitBtn = By.id("submit");
	private static By searchFld = By.xpath("//input[@type='search']");
	private static By deleteLink = By.xpath("//a[text()='Delete']");
	private static By transferLink = By.xpath("//a[text()='Transfer']");
	private static By amonutFld = By.name("amount");
	private static By transferSubmitBtn = By.id("submit");
	
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
