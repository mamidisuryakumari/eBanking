package com.eBanking.ui.pages.admin;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;

public class AdminLoginPage extends BasePage {
	
private TestContext context;
	
	public AdminLoginPage(TestContext context) {
		super(context);
		this.context = context;
	}

	private static By enterEmailAddressFld = By.id("email");
	private static By passwordFld = By.id("password");
	private static By loginBtn = By.name("login");

	public String getAdminLoginPageTitle() {
		return context.getBot().getTitle();
	}

	public AdminDashBoardPage adminLogin(String email, String password) {
		context.getBot().enterText(enterEmailAddressFld, email);
		context.getBot().enterText(passwordFld, password);
		context.getBot().click(loginBtn);
context.setAdminEmail(email);
		context.setAdminPassword(password);
		return new AdminDashBoardPage(context);
	}

}
