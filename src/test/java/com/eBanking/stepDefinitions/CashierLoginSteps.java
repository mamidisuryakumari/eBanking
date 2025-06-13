package com.eBanking.stepDefinitions;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.HomePage;
import com.eBanking.ui.pages.cashier.CashierLoginPage;

import enums.UserType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class CashierLoginSteps {

	private static final Logger logger = LoggerFactory.getLogger(CashierLoginSteps.class);
	private TestContext context;
	private HomePage homePage;
	private CashierLoginPage cashierLoginPage;

	public CashierLoginSteps(TestContext context) {
		this.context = context;
		this.homePage = new HomePage(context);
		this.cashierLoginPage = new CashierLoginPage(context);
	}

	@When("I navigate to cashier login page as a {}")
	public void iNavigateToCashierLoginPageCashier(String cashier) {
		try {
			UserType userType = UserType.valueOf(cashier.toUpperCase());
			homePage.navigateToPage(userType);
			logger.info("Navigate to cashier login page successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while navigating to cashier login page", e.getMessage());
			throw e;
		}

	}

	@When("I log in with cashier valid credentials")
	public void iLogInWithCashierValidCredentails(DataTable cashierLoginDetails) {
		try {
			Map<String, String> cashierLoginDetailsMap = cashierLoginDetails.asMap(String.class, String.class);
			cashierLoginPage.loginCashier(cashierLoginDetailsMap.get("EmployeeId").replace("${EmployeeId}",context.getCashierEmpId()),
					cashierLoginDetailsMap.get("Password").replace("${Password}",context.getCashierPassword()));
			logger.info("Cashier login successfully with valid credentails");
		} catch (Exception e) {
			logger.error("An exception error occured while logging in with cashier credentials", e.getMessage());
			throw e;
		}
	}

}
