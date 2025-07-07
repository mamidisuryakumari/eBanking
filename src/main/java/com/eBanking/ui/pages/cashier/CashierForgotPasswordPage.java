package com.eBanking.ui.pages.cashier;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.By;

public class CashierForgotPasswordPage extends BasePage {
    private TestContext context;
    public CashierForgotPasswordPage(TestContext context) {
        super(context);
        this.context = context;
    }
    private final By forgotPasswordText = By.xpath("//h1[text()='Forgot Password!']");
    private final By userEmailAddressFld = By.name("email");
    private final By mobileNumberFld = By.name("mobile");
    private final By newPasswordFld = By.name("newpassword");
    private final By confirmPasswordFld = By.name("confirmpassword");
    private final By resetBtn = By.name("submit");

    public String getForgotPasswordText(){
        return context.getBot().getText(forgotPasswordText);
    }

    public CashierForgotPasswordPage forgotPassword(String emailId, String mobileNumber, String newPassword, String confirmPassword){
        context.getBot().enterText(userEmailAddressFld, emailId)
                .enterText(mobileNumberFld, mobileNumber)
                .enterText(newPasswordFld, newPassword)
                .enterText(confirmPasswordFld, confirmPassword)
                .click(resetBtn);
        context.setCashierNewPassword(newPassword);
        return this;
    }

    public String getCashierForgotPasswordAlertText(){
        return  context.getBot().getAlertMessage();
    }

    public CashierForgotPasswordPage acceptCashierForgotPasswordAlert(){
        context.getBot().acceptAlert();
        return this;
    }
}
