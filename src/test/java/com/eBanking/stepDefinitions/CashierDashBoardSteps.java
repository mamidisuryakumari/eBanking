package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.cashier.CashierDashboardPage;

import io.cucumber.java.en.Then;

public class CashierDashBoardSteps {
	
	private static final Logger logger = LoggerFactory.getLogger(CashierDashBoardSteps.class);
	private TestContext context;
	private CashierDashboardPage cashierDashboardPage;
	
	public CashierDashBoardSteps(TestContext context) {
		this.context = context;
		this.cashierDashboardPage = new CashierDashboardPage(context);
	}
	
	@Then("I should be navigated to the cashier dashboard page")
	public void iShouldBeNavigatedToTheCashierDashboardPage() {
	try {
		String actualCashierDashboardPageTitle = cashierDashboardPage.getCashierDashboardPageTitle();
		String expectedCashierDashboardPageTitle = PropertiesManager.getProperty("cashier.dashboard.page.title");
		assertEquals(expectedCashierDashboardPageTitle, actualCashierDashboardPageTitle);
		logger.info("Cashier dashboard page title is matched");
	} catch (AssertionError e) {
		logger.error("Assertion failed : Title is mismatched",e.getMessage());
		throw e;
	}catch (Exception e) {
	logger.info("An exception occured while verifying the cashier dashboard page title",e.getMessage());	
	throw e;
	}
		
	}

}
