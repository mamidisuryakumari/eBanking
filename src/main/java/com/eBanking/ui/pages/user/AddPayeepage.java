package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.pages.Page;

public class AddPayeepage extends Page {
	
	private static final By PayeeorBeneficiaryAccountNumber = By.id("accountnumber");
	private static final By PayeeorBeneficiaryconfirmAccountNumber = By.id("conaccountnumber");
	private static final By pbAccountHolderName = By.id("acountholdername");
	private static final By submitBtn = By.id("submit");
	private static final By searchFld = By.xpath("//input[@type='search']");
	
	
	private static final By addPayeeText = By.xpath("//h3[text()='Add Payee / beneficiary']");
	
	public String getAddPayyeText() {
		return bot.getText(addPayeeText);
	}

	public void addPayyeAccountDetails(String payyeAccountNumber, String payyeConfirmAccountNumber,
			String accountHolderName) {
		bot.enterText(PayeeorBeneficiaryAccountNumber, payyeAccountNumber)
		.enterText(PayeeorBeneficiaryconfirmAccountNumber, payyeConfirmAccountNumber)
		.enterText(pbAccountHolderName, accountHolderName)
		.click(submitBtn);
	}
	

	
}
