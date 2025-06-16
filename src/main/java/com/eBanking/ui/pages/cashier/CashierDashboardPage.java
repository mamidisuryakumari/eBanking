package com.eBanking.ui.pages.cashier;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.By;

public class CashierDashboardPage extends BasePage {
	
	private TestContext context;

	
	public CashierDashboardPage(TestContext context) {
		super(context);
		this.context = context;

	}

	private final By accountHolderLink = By.xpath("//span[text()=' Account Holders']");
	
	public String getCashierDashboardPageTitle() {
		return context.getBot().getTitle();
	}

	public CashierAccountHolderDetailsPage navigatedToTheAccountHolderDetailsPage(){
		context.getBot().click(accountHolderLink);
		return new CashierAccountHolderDetailsPage(context);
	}

}
