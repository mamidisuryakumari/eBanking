package com.eBanking.ui.pages.admin;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.Common;
import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;

public class CashierUpdateDetailsPage extends BasePage {

	private TestContext context;
	private final Logger logger = LoggerFactory.getLogger(CashierUpdateDetailsPage.class);

	public CashierUpdateDetailsPage(TestContext context) {
        super(context);
        this.context = context;
	}

	private final By updateCashierLabel = By.xpath("//h1[text()='Update Cashier']");
	private final By cashierFirstNameFld = By.xpath("//input[@name='fname']");
	private final By cashierLastNameFld = By.className("lname");
	private final By cashierDobFld = By.className("dob");
	private final By genderDropdownFld = By.className("gender");
	private final By cashierAddressFld = By.name("address");
	private final By updateBtn = By.name("submit");

	public String getUpdateCashiertext() {
		return context.getBot().getText(updateCashierLabel);
	}
	
	public String getCashierUpdateDetailstextAlert() {
		return context.getBot().getAlertMessage();
	}
	
	public CashierUpdateDetailsPage acceptCashierUpdateDetailsttextAlert() {
		context.getBot().acceptAlert();
		return this;
	}
	
	public CashierUpdateDetailsPage updateCashierDetails() {
	//	context.getBot().enterText(cashierFirstNameFld,PropertiesManager.getProperty("cashier.update.name")+Common.random());  	 
		context.getBot().enterText(cashierFirstNameFld, context.getCashierFirstName() + Common.random());
		context.getBot().click(updateBtn);
	  return this;
	   
	}

}