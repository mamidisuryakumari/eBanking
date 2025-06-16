package com.eBanking.ui.pages.cashier;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.By;

public class CashierUserDetailsPage extends BasePage {
    private TestContext context;
    public CashierUserDetailsPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private final By userDetailsLabelText = By.xpath("//h1[text()='Details of User']");
    private final By depositBtn = By.xpath("//button[text()='Deposit']");
    private final By withdrawalBtn = By.xpath("//button[text()='Withdraw']");
    private final By takeActionPopUpWindowLabelText = By.xpath("(//h5[text()='Take Action'])[1]");
    private final By withdrawTakeActionPopUpWindowLabelText = By.xpath("(//h5[text()='Take Action'])[2]");
    private final By amountFld = By.name("amount");
    private final By withdrawalAmountFld = By.xpath("(//input[@name='amount'])[2]");
    private final By transactionTypeDropdown = By.name("ttype");
    private final By updateBtn = By.xpath("(//button[text()='Update'])[1]");
    private final By withdrawalUpdateBtn = By.xpath("(//button[text()='Update'])[2]");

    public String getUserDetailsLabelText(){
        return context.getBot().getText(userDetailsLabelText);
    }

public String getUserDetailsText(){
       return context.getBot().getText(userDetailsLabelText);
}
public CashierUserDetailsPage clickOnDepositBtn(){
        context.getBot().click(depositBtn);
        return this;
}
    public CashierUserDetailsPage clickOnWithdrawalBtn(){
        context.getBot().click(withdrawalBtn);
        return this;
    }
public String getTakeActionPopupWindowText(){
      return  context.getBot().getText(takeActionPopUpWindowLabelText);
}

    public String getWithdrawalTakeActionPopupWindowText(){
        return  context.getBot().getText(withdrawTakeActionPopUpWindowLabelText);
    }


public CashierUserDetailsPage enterAmountAndSelectTransactionType(String amount, String value){
        context.getBot().enterText(amountFld,amount)
                .selectByValue(transactionTypeDropdown, value)
                .click(updateBtn);
        return this;
}
    public CashierUserDetailsPage enterWithdrawalAmount(String amount){
        context.getBot().enterText(withdrawalAmountFld,amount)
                .click(withdrawalUpdateBtn);
        return this;
    }


public String getTransactionSuccessAlertMsg(){
     return  context.getBot().getAlertMessage();
}
public CashierUserDetailsPage acceptTransactionSuccessAlertMsg(){
        context.getBot().acceptAlert();
        return this;
}
}
