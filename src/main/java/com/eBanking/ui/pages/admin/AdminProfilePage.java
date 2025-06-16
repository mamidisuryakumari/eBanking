package com.eBanking.ui.pages.admin;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;
import org.openqa.selenium.By;

public class AdminProfilePage extends BasePage {
    private TestContext context;

    public AdminProfilePage(TestContext context) {
        super(context);
        this.context = context;
    }

    private final By adminProfileLabelText = By.xpath("//h6[text()='Admin Profile']");
    private final By adminNameInputFld = By.id("fname");
    private final By adminMobileNumberInputFld = By.id("mobilenumber");
    private final By updateBtn = By.id("submit");

    public String getAdminProfileLabelText() {
        return context.getBot().getText(adminProfileLabelText);
    }

    public AdminProfilePage updateProfile(String adminName, String mobileNumber) {
        context.getBot().enterText(adminNameInputFld, adminName)
                .enterText(adminMobileNumberInputFld, mobileNumber)
                .click(updateBtn);
        return this;
    }

    public String getProfileUpdateAlertText(){
       return  context.getBot().getAlertMessage();
    }

    public AdminProfilePage acceptProfileUpdateAlert(){
        context.getBot().acceptAlert();
        return this;
    }
}
