package com.eBanking.ui.pages.admin;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.SynchronizationManager;
import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.By;

public class SearchAccountHolderPage extends BasePage {
    private TestContext contex;
    private SynchronizationManager synchronizationManager;
    public SearchAccountHolderPage(TestContext context) {
        super(context);
        this.contex = context;
        this.synchronizationManager = new SynchronizationManager(context.getDriver());
    }
private final By searchAccountfield = By.id("searchdata");
    private final By submitBtn = By.id("submit");
    private final By accountStatusText = By.xpath("//span[text()='Approved']");

    public SearchAccountHolderPage searchUserAccount(String accountName){
        contex.getBot().enterText(searchAccountfield, accountName).click(submitBtn);
        synchronizationManager.waitForTheElementToBeVisible(searchAccountfield);
        contex.setAccountCurrentStatus(contex.getBot().getWebElement(accountStatusText).getText());
        return this;
    }

}
