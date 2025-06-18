package com.eBanking.stepDefinitions;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.HomePage;
import com.eBanking.ui.pages.cashier.CashierLoginPage;

import enums.UserType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
@Slf4j
public class CashierLoginSteps {


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
			log.info("Navigate to cashier login page successfully");
		} catch (Exception e) {
			log.error("An exception error occured while navigating to cashier login page", e.getMessage());
			throw e;
		}

	}

	@When("I log in with cashier valid credentials")
	public void iLogInWithCashierValidCredentails(DataTable cashierLoginDetails) {
		try {
			Map<String, String> cashierLoginDetailsMap = cashierLoginDetails.asMap(String.class, String.class);
			cashierLoginPage.loginCashier(cashierLoginDetailsMap.get("EmployeeId"),
					cashierLoginDetailsMap.get("Password"));
			log.info("Cashier login successfully with valid credentails");
		} catch (Exception e) {
			log.error("An exception error occured while logging in with cashier credentials", e.getMessage());
			throw e;
		}
	}

	@When("I log in with valid cashier employeeId and Password")
	public void iLogInWithValidCashierCredentials(){
		try{
			cashierLoginPage.loginCashier(context.getCashierEmpId(),context.getCashierNewPassword());
			log.info("Cashier log in successfully");
		} catch (Exception e) {
			log.error("Failed to cashier login", e.getMessage());
			throw e;
		}

	}

}
