package com.eBanking.stepDefinitions;

import com.eBanking.ui.engine.Common;
import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import com.eBanking.ui.pages.admin.AdminProfilePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class AdminProfileSteps {

    private TestContext context;
    private AdminDashBoardPage adminDashBoardPage;
    private AdminProfilePage adminProfilePage;

    public AdminProfileSteps(TestContext context) {
        this.context = context;
        this.adminDashBoardPage = new AdminDashBoardPage(context);
        this.adminProfilePage = new AdminProfilePage(context);
    }

    @When("I go to the admin profile page")
    public void iGoToTheAdminProfilePage() {
        try {
            adminDashBoardPage.navigateToAdminProfilePage();
            log.info("Navigated to admin profile page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the admin profile page", e.getMessage());
            throw e;
        }
    }

    @Then("I am on the admin profile page")
    public void iAmOnTheAdminProfilePage() {
        try {
            String actualAdminProfileText = adminProfilePage.getAdminProfileLabelText();
            String expectedAdminProfileText = PropertiesManager.getProperty("admin.profile.text");
            assertEquals(expectedAdminProfileText, actualAdminProfileText);
            log.info("Admin profile text is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed : admin profile text is mismatched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while verifying the admin profile page", e.getMessage());
            throw e;
        }
    }

    @When("I update admin profile details")
    public void iUpDateAdminProfile(DataTable dataTable) {
        try {
            Map<String , String> adminProfileDetails = dataTable.asMap();
            adminProfilePage.updateProfile(adminProfileDetails.get("Admin Name").replace("${random}", Common.random()),
                    adminProfileDetails.get("Admin MobileNumber").replace("${mobileNumber}", Common.generateMobileNumber()));
            log.info("Update admin profile successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while updating profile", e.getMessage());
            throw e;
        }
    }

    @Then("I should see profile has been updated successfully")
    public void iShouldSeeProfileHasBeenUpdatedSuccessfully() {
        try {
            String actualUpdateProfileAlertText = adminProfilePage.getProfileUpdateAlertText();
            String expectedUpdateProfileAlertText = PropertiesManager.getProperty("admin.profile.update.alertMsg");
            assertEquals(actualUpdateProfileAlertText,expectedUpdateProfileAlertText);
            log.info("Updated profile text is matched");
            adminProfilePage.acceptProfileUpdateAlert();
        } catch (AssertionError e) {
            log.error("Assertion failed: update profile text is mismatched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while updating profile", e.getMessage());
            throw e;
        }
    }

}
