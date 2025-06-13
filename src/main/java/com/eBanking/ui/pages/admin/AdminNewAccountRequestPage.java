package com.eBanking.ui.pages.admin;

import java.util.List;
import java.util.Properties;

import com.eBanking.ui.engine.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
@Slf4j
public class AdminNewAccountRequestPage extends BasePage {
	
private TestContext context;
	
	public AdminNewAccountRequestPage(TestContext context) {
		super(context);
		this.context = context;
	}

	private final By accountSearchFld = By.xpath("//input[@type='search']");
	private  final By viewLink = By.xpath("//a[text()='View ']");
	private final By newAccountOpeningRequestlabel = By.xpath("//h1[text()='New Account Opening Requests']");
	private  final By userAccountEmail = By.xpath("//tbody/tr/td[4]");
	private final By numberOfRecordsInTable =By.xpath("//tbody/tr[@class='odd' or @class='even']/td[2]");
	
	
	public String getAdminNewAccountRequestPageTitle() {
		return context.getBot().getTitle();
	}
	public String getAdminNewAccountRequesttext() {
		return context.getBot().getText(accountSearchFld);
	}
	
	
	
public AdminNewAccountRequestPage searchUserAccount() {
		List<WebElement> elements = context.getDriver().findElements(numberOfRecordsInTable);
		if(elements.size() > 0){
			for(WebElement element : elements){
				String accountName = element.getText();
				context.getBot().enterText(accountSearchFld , accountName);
				context.setSearchUserAccount(accountName.split( " ")[0]);
				break;
			}
		}else{
			log.info("No records found");
		}
	return this;
}
	
	
	public AdminAccountholderDetailsPage navigateToAccountHolderDetailsPage() {

			context.getBot()
			.click(viewLink);
		return new AdminAccountholderDetailsPage(context);
		}
	}


	
	


