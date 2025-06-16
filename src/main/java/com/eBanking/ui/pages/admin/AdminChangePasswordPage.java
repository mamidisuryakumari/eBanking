package com.eBanking.ui.pages.admin;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.By;

public class AdminChangePasswordPage extends BasePage {
    private TestContext context;
    public AdminChangePasswordPage(TestContext context) {
        super(context);
        this.context = context;
    }
    private final By currentPasswordFld = By.id("currentpassword");
    private final By newPasswordFld = By.id("newpassword");
    private final By confirmPasswordFld = By.id("confirmpassword");
    private final By changeBtn = By.id("submit");
public String getChangePasswordPageTitle(){
      return context.getBot().getTitle();
}
public AdminChangePasswordPage changePassword(String currentPassword , String newPassword, String confirmPassword){
context.getBot().enterText(currentPasswordFld ,currentPassword)
        .enterText(newPasswordFld, newPassword)
        .enterText(confirmPasswordFld , confirmPassword)
        .click(changeBtn);
context.setAdminNewPassword(newPassword);
return this;
}

public String getChangePasswordAlertText(){
    return context.getBot().getAlertMessage();
}
public AdminChangePasswordPage acceptChangePasswordAlert(){
    context.getBot().acceptAlert();
    return this;
}

}
