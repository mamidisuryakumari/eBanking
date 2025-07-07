package com.eBanking.ui.pages.user;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;

public class UserDashboardPage extends BasePage {
	private TestContext context;

	public UserDashboardPage(TestContext context) {
        super(context);
        this.context = context;
	}

	private final By accountOpeninigoption = By.xpath("//span[text()='Account Openning']");
	private final By payeeoption = By.xpath("//span[text()='Payee / Beneficiary']");
	private final By addLink = By.xpath("//a[text()='Add']");
	private final By manageLink = By.xpath("//a[text()='Manage']");
	private final By userNameProfile = By
			.xpath("//span[contains(text(),'" + PropertiesManager.getProperty("userName") + "')]");
	private final By changePasswordLink = By.xpath("//a[@href='change-password.php']");
	private final By profileLink = By.xpath("//a[@ href=\"profile.php\"]");
	private final By transactionHistoryLink = By.xpath("//span[text()='Transaction History']");
	private final By avilableBalanceFld = By.xpath("(//div[@class='h5 mb-0 font-weight-bold text-gray-800'])[1]");
	
	private final By dashboardLink = By.xpath("//span[text()='Dashboard']");
	private final By userImageLink = By.xpath("//img[@class='img-profile rounded-circle']");
	private final By logoutLink = By.xpath("(//a[@href='logout.php'])[1]");
	private final By readyToLeaveLogoutPopup = By.xpath("//h5[text()='Ready to Leave?']");
	private final By userLogoutBtn = By.xpath("//a[text()='Logout']");

	public UserDashboardPage clickOnLogOutLink(){
		context.getBot().click(userImageLink)
				.click(logoutLink);
		return this;
	}
	public  String getUserLogoutPopupText(){
		return context.getBot().getText(readyToLeaveLogoutPopup);
	}

	public UserLoginPage clickOnUserLogoutBtn(){
		context.getBot().click(userLogoutBtn);
		return new UserLoginPage(context);
	}

	
	public void navigateToDashBoardPage() {
		context.getBot().click(dashboardLink);
	}

	public double availableBalance() {
		String avialableBalanceText = context.getBot().getText(avilableBalanceFld);
		return Double.parseDouble(avialableBalanceText);
	}

	public UserTransactionHistoryPage navigateToTransactionHistoryPage() {
		context.getBot().click(transactionHistoryLink);
		return new UserTransactionHistoryPage(context);
	}

	public UserChangePasswordPage navigatedToTheChangePasswordPage() {
		context.getBot().click(userImageLink).click(changePasswordLink);
		return new UserChangePasswordPage(context);
	}

	public UserProfilePage navigatedToTheUserProfilePage() {
		context.getBot().click(userImageLink).click(profileLink);
		return new UserProfilePage(context);
	}

	public AccountDetailsPage navigatedToAccountDetailsPage() {
		context.getBot().click(accountOpeninigoption);
		return new AccountDetailsPage(context);
	}

	public AddPayeepage navagatedToAddPayeePage() {
		context.getBot().click(payeeoption).click(addLink);
		return new AddPayeepage(context);
	}

	public ManagePayeePage navigatedToManagePayee() {
		context.getBot().click(payeeoption).click(manageLink);
		return new ManagePayeePage(context);
	}

	public String getDashboardPageTitle() {
		return context.getBot().getTitle();
	}
}
