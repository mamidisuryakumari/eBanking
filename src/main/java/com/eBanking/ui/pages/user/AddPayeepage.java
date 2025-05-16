package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.Page;

public class AddPayeepage extends Page {
	
	private static final By PayeeorBeneficiaryAccountNumber = By.id("accountnumber");
	private static final By PayeeorBeneficiaryconfirmAccountNumber = By.id("conaccountnumber");
	private static final By pbAccountHolderName = By.id("acountholdername");
	private static final By submitBtn = By.id("submit");
	private static final By searchFld = By.xpath("//input[@type='search']");
	private static final By deleteLink = By.xpath("//a[text()='Delete']");
	private static final By transferLink = By.xpath("//a[text()='Transfer']");
	private static final By amonutFld = By.name("amount");
	private static final By transferSubmitBtn = By.id("submit");
	

}
