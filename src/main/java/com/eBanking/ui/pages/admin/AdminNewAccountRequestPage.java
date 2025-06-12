package com.eBanking.ui.pages.admin;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;

public class AdminNewAccountRequestPage {
	
private TestContext context;
	
	public AdminNewAccountRequestPage(TestContext context) {
		this.context = context;
	}

	private final By accountApproveSearchFld = By.xpath("//input[@type='search']");
	private  final By viewLink = By.xpath("//a[text()='View ']");
	private final By newAccountOpeningRequestlabel = By.xpath("//h1[text()='New Account Opening Requests']");
	private  final By userAccountEmail = By.xpath("//tbody/tr/td[4]");
	
	
	public String getAdminNewAccountRequestPageTitle() {
		return context.getBot().getTitle();
	}
	public String getAdminNewAccountRequesttext() {
		return context.getBot().getText(accountApproveSearchFld);
	}
	
	
	
public AdminAccountholderDetailsPage searchAccountApprove(String emailID) {
	context.getBot().searchAccount(accountApproveSearchFld, emailID);
	context.getBot()
	.click(viewLink);
	return new AdminAccountholderDetailsPage(context);
}
	
	
	public AdminAccountholderDetailsPage navigateToAccountHolderDetailsPage() {
	List<WebElement> userAccountEmailsList =	context.getBot().getDriver().findElements(userAccountEmail);
	for(WebElement alluserAccountEmails : userAccountEmailsList ) {
		String userAccountEmails = alluserAccountEmails.getText().trim();
		String newRequestEmailId = context.getUserEmailId();
	//	String newRequestEmpId = PropertiesManager.getProperty("user.approve.emailid");
		if(userAccountEmails.equals(newRequestEmailId)) {
			context.getBot()
			.click(viewLink);
			break;
		}
	}
	return new AdminAccountholderDetailsPage(context);
	}
	
	

}
