package com.eBanking.ui.pages.admin;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;

public class AdminDashBoardPage extends BasePage {

    private TestContext context;

    public AdminDashBoardPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private final By newAccountRequestFld = By.xpath("//div[normalize-space(text())='New Account Requests']");
    private final By accountApproveFld = By.xpath("//span[text()='Account Approval']");
    private final By newRequestLink = By.xpath("//a[text()='New Request']");
    private final By cashierLink = By.xpath("//span[text()='Cashier']");
    private final By addCashierLink = By.xpath("//a[text()='Add Cashier']");
    private final By manageCashierLink = By.xpath("//a[text()='Manage Cashier']");
    private final By adminDashboardText = By.xpath("//h1[text()='Dashboard']");
    private final By searchAccountLink = By.xpath("//span[text()='Search Account']");
    private final By adminFld = By.xpath("//img[@class='img-profile rounded-circle']");
    private final By profileLink = By.xpath("//a[@href='profile.php']");
    private final By changePasswordLink = By.xpath("//a[@href='change-password.php']");

    public String getAdminDashboardText() {
        return context.getBot().getText(adminDashboardText);
    }

    public String getAdminDashboardPageTitle() {
        return context.getBot().getTitle();
    }

    public SearchAccountHolderPage navigateToSearchAccountHolderPage() {
        context.getBot().click(searchAccountLink);
        return new SearchAccountHolderPage(context);
    }

    public AdminAccountholderDetailsPage navigateToNewAccountRequestPage() {
        context.getBot().click(accountApproveFld).click(newRequestLink);
        return new AdminAccountholderDetailsPage(context);
    }

    public AddCashierPage navigateToAddCashierPage() {
        context.getBot().click(cashierLink).click(addCashierLink);
        return new AddCashierPage(context);
    }

    public CashierDetailsPage navigateToCashierDetailsPage() {
        context.getBot().click(cashierLink).click(manageCashierLink);
        return new CashierDetailsPage(context);
    }

    public AdminProfilePage navigateToAdminProfilePage() {
        context.getBot().jsClick(adminFld).click(profileLink);
        return new AdminProfilePage(context);
    }

    public AdminChangePasswordPage navigateToAdminChangePasswordPage() {
        context.getBot().click(adminFld).click(changePasswordLink);
        return new AdminChangePasswordPage(context);
    }
}
