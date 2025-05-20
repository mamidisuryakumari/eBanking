package com.eBanking.ui.pages.user;

import org.openqa.selenium.By;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;

public class UserDashboardPage extends Page {

	private static By accountOpeninigoption = By.xpath("//span[text()='Account Openning']");
	private static By payeeoption = By.xpath("//span[text()='Payee / Beneficiary']");
	private static By addLink = By.xpath("//a[text()='Add']");
	private static By manageLink = By.xpath("//a[text()='Manage']");
	private static By userNameProfile = 
			By.xpath("//span[contains(text(),'" + PropertiesManager.getProperty("userName") + "')]");
	private static final By changePasswordLink = By.xpath("//a[@href='change-password.php']");
	
	public UserChangePasswordPage iNavigatedToTheChangePasswordPage() {
		bot.click(userNameProfile)
		.click(changePasswordLink);
		return new UserChangePasswordPage();
	}

	public AccountDetailsPage iNavigatedToAccountDetailsPage() {
		bot.click(accountOpeninigoption);
		return new AccountDetailsPage();
	}

	public AddPayeepage iNavagatedToAddPayeePage() {
		bot.click(payeeoption).click(addLink);
		return new AddPayeepage();
	}

	public ManagePayeePage iNavigatedToManagePayee() {
		bot.click(payeeoption).click(manageLink);
		return new ManagePayeePage();
	}
	
	public String getDashboardPageTitle() {
		return bot.getTitle();
	}
}
