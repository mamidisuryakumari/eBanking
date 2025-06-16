package com.eBanking.ui.pages.cashier;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


@Slf4j
public class CashierAccountHolderDetailsPage extends BasePage {
    private TestContext context;

    public CashierAccountHolderDetailsPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private final By numberOfAccounts = By.xpath("//tbody/tr[@class='odd' or @class='even']/td[2]");
    private final By searchFld = By.xpath("//input[@type='search']");
    private final By viewLink = By.xpath("//a[text()='View ']");


    public String getCashierAccountHolderDetailsPageTitle() {
        return context.getBot().getTitle();
    }

    public CashierAccountHolderDetailsPage searchUserAccount() {
        List<WebElement> accounts = context.getDriver().findElements(numberOfAccounts);
        if (accounts.size() > 0) {
            for (WebElement account : accounts) {
                String accountName = account.getText();
                context.getBot().enterText(searchFld, accountName);
                context.setCashierUserAccount(accountName.split(" ")[0]);
                break;
            }
        } else {
            log.info("No records found");
        }
        return this;
    }

    public CashierUserDetailsPage navigateToCashierUserDetailsPage(){
        context.getBot().click(viewLink);
        return new CashierUserDetailsPage(context);
    }

}
