package com.eBanking.ui.pages.cashier;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.By;

public class CashierProfilePage extends BasePage {
    private TestContext context;

    public CashierProfilePage(TestContext context) {
        super(context);
        this.context = context;
    }

    private final By cashierFirstNameFld = By.name("fname");
    private final By cashierAddressFld = By.name("address");
    private final By cashierUpdateBtn = By.id("submit");

    public String getCashierProfilePageTitle() {
        return context.getBot().getTitle();
    }

    public CashierProfilePage cashierProfileUpdate(String firstName, String address) {
        context.getBot().enterText(cashierFirstNameFld, firstName)
                .enterText(cashierAddressFld, address)
                .click(cashierUpdateBtn);
        return this;
    }

    public String getCashierDetailsUpdateProfileAlertText() {
        return context.getBot().getAlertMessage();
    }

    public CashierProfilePage acceptCashierDetailsUpdateProfileAlert() {
        context.getBot().acceptAlert();
        return this;
    }
}
