package com.eBanking.ui.pages.cashier;

import com.eBanking.ui.engine.TestContext;

public class CashierDashboardPage {
	
	private TestContext context;
	
	public CashierDashboardPage(TestContext context) {
		this.context = context;
	}
	
	public String getCashierDashboardPageTitle() {
		return context.getBot().getTitle();
	}

}
