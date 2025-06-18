package com.eBanking.ui.pages.cashier;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.By;

public class CashierChangePasswordPage extends BasePage {
    private TestContext context;

    public CashierChangePasswordPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private final By cashierCurrentPasswordFld = By.id("currentpassword");
    private final By cashierNewPasswordFld = By.id("newpassword");
    private final By cashierConfirmPasswordFld = By.id("confirmpassword");
    private final By cashierChangeBtn = By.id("submit");

    public String getCashierChangePasswordPageTitle() {
        return context.getBot().getTitle();
    }

    public CashierChangePasswordPage cashierChangePassword(String currentPassword, String newPassword, String confirmPassword) {
        context.getBot().enterText(cashierCurrentPasswordFld, currentPassword)
                .enterText(cashierNewPasswordFld, newPassword)
                .enterText(cashierConfirmPasswordFld, confirmPassword)
                .click(cashierChangeBtn);
        context.setCashierNewPassword(newPassword);
        return this;
    }

    public String getChangePasswordAlertText() {
        return context.getBot().getAlertMessage();
    }

    public CashierChangePasswordPage acceptChangePasswordAlert() {
        context.getBot().acceptAlert();
        return this;
    }

}
