package com.eBanking.ui.pages.cashier;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.By;

public class CashierDashboardPage extends BasePage {

    private TestContext context;


    public CashierDashboardPage(TestContext context) {
        super(context);
        this.context = context;

    }

    private final By accountHolderLink = By.xpath("//span[text()=' Account Holders']");
    private final By cashierImageLink = By.xpath("//img[@class='img-profile rounded-circle']");
    private final By cashierProfileLink = By.xpath("//a[@href='profile.php']");
    private final By cashierChangePasswordLink = By.xpath("//a[@href='change-password.php']");
    private final By cashierLogoutLink = By.partialLinkText("Logout");
    private final By cashierLogoutPopupText = By.xpath("//h5[text()='Ready to Leave?']");
    private final By cashierLogoutBtn = By.xpath("//a[text()='Logout']");

    public String getCashierDashboardPageTitle() {
        return context.getBot().getTitle();
    }

    public CashierAccountHolderDetailsPage navigatedToTheAccountHolderDetailsPage() {
        context.getBot().click(accountHolderLink);
        return new CashierAccountHolderDetailsPage(context);
    }

    public CashierProfilePage navigateToCashierProfilePage() {
        context.getBot().click(cashierImageLink).click(cashierProfileLink);
        return new CashierProfilePage(context);
    }

    public CashierChangePasswordPage navigateToCashierChangePasswordPage() {
        context.getBot().click(cashierImageLink).click(cashierChangePasswordLink);
        return new CashierChangePasswordPage(context);
    }

    public CashierDashboardPage clickOnLogoutLink(){
       context.getBot().click(cashierImageLink).click(cashierLogoutLink);
       return this;
    }

    public String getCashierPopupWindowText(){
       return context.getBot().getText(cashierLogoutPopupText);
    }

    public CashierDashboardPage clickOnLogoutBtn(){
         context.getBot().click(cashierLogoutBtn);
         return this;
    }

}
