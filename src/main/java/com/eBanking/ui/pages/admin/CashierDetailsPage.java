package com.eBanking.ui.pages.admin;

import java.util.List;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;

public class CashierDetailsPage extends BasePage {
	
	private TestContext context;
	public CashierDetailsPage(TestContext context) {
        super(context);
        this.context = context;
	}
	
	private final By cashierSearchFld = By.xpath("//input[@type='search']");
	private final By deleteLink = By.xpath("//a[text()='Delete']");
	private final By detailsCashierText = By.xpath("//h1[text()='Details of Cashier']");
	private final By editCashier = By.xpath("//a[text()='Edit']");
	private final By cashierEmpIds = By.xpath("//tbody//tr//td[3]");
	private final By noMatchingRecordText = By.xpath("//td[text()='No matching records found']");
	
	public String getNoMatchingRecordText(){
		System.out.println(context.getBot().getText(noMatchingRecordText));
		return context.getBot().getText(noMatchingRecordText);
	}
	public String getDetailsCashierText() {

		return context.getBot().getText(detailsCashierText);
	}

	public void searchCashier(){
		context.getBot().searchAccount(cashierSearchFld, context.getCashierFullName());
	}

	public CashierDetailsPage deleteCashier() {
		context.getBot()
				.searchAccount(cashierSearchFld, context.getCashierEmpId())
				.click(deleteLink)
				.acceptAlert();
		return this;
	}
	
	public void deleteCashierUsingCashierList() {
		List<WebElement> cashierempIdsList= context.getBot().getDriver().findElements(cashierEmpIds);
		for (WebElement cashierEmpIds : cashierempIdsList) {
			
			String allCashierEmpIds = cashierEmpIds.getText().trim();
			String deleteEmpId = PropertiesManager.getProperty("cashier.emp.id");
		//	String deleteEmpId = context.getCashierEmpId();
			if(allCashierEmpIds.equals(deleteEmpId))
					 {
				context.getBot()
				.click(deleteLink)
				.acceptAlert();
				break;
			}
		}
	}
	

	
	public String getCashierDeleteAlertMsg() {
		return context.getBot().getAlertMessage();
	}
	public CashierDetailsPage acceptCashierDeleteAlertMsg() {
		context.getBot().acceptAlert();
		return this;
	}
	
	public CashierUpdateDetailsPage navigateToupdateCashierDetailsPage() {
		context.getBot()
		.searchAccount(cashierSearchFld, PropertiesManager.getProperty("cashier.emp.id"))
		.click(editCashier);
		return new CashierUpdateDetailsPage(context);
	}

}
