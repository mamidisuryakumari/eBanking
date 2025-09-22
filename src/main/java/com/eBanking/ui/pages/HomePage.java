package com.eBanking.ui.pages;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.user.UserLoginPage;

import enums.UserType;


public class HomePage extends BasePage {

	private TestContext context;
	
	public HomePage(TestContext context) {
		super(context);
		this.context = context;
	}
	
	private final Logger logger = LoggerFactory.getLogger(HomePage.class);
	

	private final By userMenuLink = By.xpath("(//a[contains(.,'Account Holder')])[2]");
	private final By adminMenuLink = By.xpath("(//a[text()='Admin'])[2]");
	private final By cashierLink = By.xpath("(//a[text()='Cashier'])[2]");
	
	public void navigateToPage(UserType user) {
		
	switch(user) {
	case USER: 
		context.getBot().click(userMenuLink);
		logger.info("Landed on user login page");
		break;
	case ADMIN: 
		context.getBot().click(adminMenuLink);
		logger.info("Landed on admin login page");
		break;
		
	case CASHIER:
		context.getBot().click(cashierLink);
		logger.info("Landed on cashier login page");
		break;
		
		default:
			logger.info("Please pass a correct usertype value");
		throw new IllegalArgumentException("I am unable to navigate to page");
		
	}
	}

	public UserLoginPage navigatedToUserLoginPage() {
		context.getBot().jsClick(userMenuLink);
		return new UserLoginPage(context);
	}

	public String getHomePageTitle() {
		String s = "";
		return context.getBot().getTitle(s);
	}

	public UserLoginPage navigatedToAdminLoginPage() {
		context.getBot().jsClick(adminMenuLink);
		return new UserLoginPage(context);
	}
}
