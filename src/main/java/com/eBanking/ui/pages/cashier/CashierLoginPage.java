package com.eBanking.ui.pages.cashier;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.HomePage;
import enums.UserType;


public class CashierLoginPage extends BasePage {
	
	private TestContext context;
	private final Logger logger = LoggerFactory.getLogger(CashierLoginPage.class);
	
	public CashierLoginPage(TestContext context) {
        super(context);
        this.context = context;
	}
	
	private final By cashierEmployeeIdFld = By.id("empid");
	private final By cashierPasswordFld = By.id("password");
	private final By loginBtn = By.xpath("//button[@name='login']");
	private final By cashierForgotPasswordLink = By.xpath("//a[text()='Forgot Password?']");
	
	public String getCashierLoginPageTitle() {
		return context.getBot().getTitle();
	}
	
	public CashierDashboardPage loginCashier(String employeeId, String password) {
		context.getBot().enterText(cashierEmployeeIdFld, employeeId)
		.enterText(cashierPasswordFld, password)
		.click(loginBtn);
		context.setCashierEmpId(employeeId);
		context.setCashierPassword(password);
		return new CashierDashboardPage(context);
	}

	public CashierForgotPasswordPage navigateToTheForgotPasswordPage(){
		context.getBot().click(cashierForgotPasswordLink);
		return new CashierForgotPasswordPage(context);
	}
	

}
