package com.eBanking.stepDefinitions;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AdminChangePasswordPage;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class AdminChangePasswordPageSteps {
    private TestContext context;
    private AdminDashBoardPage adminDashBoardPage;
    private AdminChangePasswordPage adminChangePasswordPage;

    public AdminChangePasswordPageSteps(TestContext context) {
        this.context = context;
        this.adminDashBoardPage = new AdminDashBoardPage(context);
        this.adminChangePasswordPage = new AdminChangePasswordPage(context);
    }

    @When("I go to the admin change password page")
    public void iGoToTheAdminChangePasswordPage() {
        try {
            adminDashBoardPage.navigateToAdminChangePasswordPage();
            log.info("Navigate to admin change password page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the change password page", e.getMessage());
            throw e;
        }
    }

    @Then("I am on the change password page")
    public void iAmOnTheChangePasswordPage() {
try{
  String actualChangePasswordPageTitle = adminChangePasswordPage.getChangePasswordPageTitle();
  String expectedChangePasswordPageTitle = PropertiesManager.getProperty("admin.changePassword.page.title");
    assertEquals(expectedChangePasswordPageTitle, actualChangePasswordPageTitle);
    log.info("Admin change password page title is matched");
} catch (AssertionError e) {
    log.error("Assertion error: Admin change password page title is mismatched" , e.getMessage());
    throw  e;
}catch (Exception e) {
log.error("An exception error occurred while verifying admin change password page title" , e.getMessage());
throw  e;
}
    }

    @When("I enter change the password details")
    public void iEnterChangeThePasswordDetails(DataTable dataTable) {
try{
    Map<String , String> changePasswordDetails = dataTable.asMap();
    adminChangePasswordPage.changePassword(context.getAdminPassword(),
            changePasswordDetails.get("New password"),changePasswordDetails.get("Confirm password"));
    log.info("Admin Change password details entered successfully");
} catch (Exception e) {
    log.error("An exception error occurred while entering change password details" , e.getMessage());
    throw e;
}
    }

    @Then("I should see Your password successfully changed")
    public void iShouldSeeYourPasswordSuccessfullyChanged() {
try{
    String actualChangePasswordAlertText = adminChangePasswordPage.getChangePasswordAlertText();
    String expectedChangePasswordAlertText = PropertiesManager.getProperty("admin.changePassword.alert.Text");
    assertEquals(expectedChangePasswordAlertText,actualChangePasswordAlertText );
    log.info("Change password alert message is matched");
    adminChangePasswordPage.acceptChangePasswordAlert();
} catch (AssertionError e) {
    log.error("AssertionFailed : Change password alert message is mismatched", e.getMessage());
    throw  e;
} catch (Exception e) {
log.error("An exception error occured while verifying the change password alert text" , e.getMessage());
throw  e;
}
    }
}
