package com.eBanking.ui.pages.user;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;


public class AddPayeepage extends BasePage {
	
private TestContext context;
	
	public AddPayeepage(TestContext context) {
        super(context);
        this.context = context;
	}
	
	private  final By PayeeorBeneficiaryAccountNumber = By.id("accountnumber");
	private  final By PayeeorBeneficiaryconfirmAccountNumber = By.id("conaccountnumber");
	private  final By pbAccountHolderName = By.id("acountholdername");
	private  final By submitBtn = By.id("submit");
	private  final By searchFld = By.xpath("//input[@type='search']");
	
	
	private static final By addPayeeText = By.xpath("//h3[text()='Add Payee / beneficiary']");
	
	public String getAddPayyeText() {
		return context.getBot().getText(addPayeeText);
	}
	
	public String addPayeeAlertmsg() {
		return context.getBot().getAlertMessage();
	}
	
	public AddPayeepage acceptAddPayeeAlert() {
		context.getBot().acceptAlert();
		return this;
	}

	public void addPayyeAccountDetails(String payyeAccountNumber, String payyeConfirmAccountNumber,
			String accountHolderName) {
		context.getBot().enterText(PayeeorBeneficiaryAccountNumber, payyeAccountNumber)
		.enterText(PayeeorBeneficiaryconfirmAccountNumber, payyeConfirmAccountNumber)
		.enterText(pbAccountHolderName, accountHolderName)
		.click(submitBtn);
	}
	

	
}
