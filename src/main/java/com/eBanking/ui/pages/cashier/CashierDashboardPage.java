package com.eBanking.ui.pages.cashier;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;

public class CashierDashboardPage extends BasePage {
	
	private TestContext context;
	
	public CashierDashboardPage(TestContext context) {
		super(context);
		this.context = context;
	}
	
	public String getCashierDashboardPageTitle() {
		return context.getBot().getTitle();
	}

}
