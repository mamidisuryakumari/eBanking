package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import com.eBanking.ui.pages.admin.SearchAccountHolderPage;
import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AdminAccountholderDetailsPage;
import com.eBanking.ui.pages.admin.AdminNewAccountRequestPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Slf4j
public class AdminAccountholderDetailsSteps {

    private TestContext context;


    AdminNewAccountRequestPage adminNewAccountRequestPage;
    AdminAccountholderDetailsPage adminAccountholderDetailsPage;
    AdminDashBoardPage adminDashBoardPage;
    SearchAccountHolderPage searchAccountHolderPage;

    public AdminAccountholderDetailsSteps(TestContext context) {
        this.context = context;
        this.adminAccountholderDetailsPage = new AdminAccountholderDetailsPage(context);
        this.adminNewAccountRequestPage = new AdminNewAccountRequestPage(context);
        this.adminDashBoardPage = new AdminDashBoardPage(context);
        this.searchAccountHolderPage = new SearchAccountHolderPage(context);
    }

    @When("I go to the account holder details page")
    public void iGotoTheAccountHolderDetailsPage() {
        try {
            adminNewAccountRequestPage.navigateToAccountHolderDetailsPage();
            log.info("Navigated to account holder details page successfully");
        } catch (Exception e) {
            log.error("An exception error occured while navigating to the account holder details page",
                    e.getMessage());
            throw e;
        }
    }

    @Then("I am on account holder details page")
    public void iAmOnAccountHilderDetailsPage() {
        try {
            String actualAdminAccountholderDetailsPageTitle = adminAccountholderDetailsPage
                    .getAdminAccountholderDetailsPage();
            String exceptedAdminAccountholderDetailsPageTitle = PropertiesManager
                    .getProperty("admin.AccountHolderDetails.page.title");
            assertEquals(exceptedAdminAccountholderDetailsPageTitle, actualAdminAccountholderDetailsPageTitle);
            log.info("Admin navigated to adimn holder details page successfully");
        } catch (AssertionError e) {
            log.error("Assertion failed : admin account holder details page title is mismatched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while navigating to admin account holder details page");
            throw e;
        }
    }

    @When("I click on 'Take Action' button")
    public void iClickOnTakeActionButton() {
        try {
            adminAccountholderDetailsPage.openTakeActionPopup();
            log.info("Take action button clicked successfully");
        } catch (Exception e) {
          log.error("An exception error occured while clicking the take action button" , e.getMessage());
          throw e;
        }

    }

    @Then("I should see 'Take Action' model window popup opened")
    public void iShouldSeeTakeActionModelPopupOpened() {
        try {
            String actualPopupWindowTitle = adminAccountholderDetailsPage.getPopupWindowTitleText();
            String expectedPopupWindowTitle = "Take Action";
            assertEquals(expectedPopupWindowTitle, actualPopupWindowTitle);
            log.info("Popup window title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: Popup window title is mismatched", e.getMessage());
            throw e;
        }catch (Exception e) {
            log.error("An exception error occured while seeing the take action model window opened", e.getMessage());
            throw e;
        }

    }

    @When("I add below remarks:")
    public void iAddBelowRemarks(DataTable dataTable) {
        try {
            var remarksMap = dataTable.asMap();
            adminAccountholderDetailsPage.accountApproval(
                    remarksMap.get("Remarks").trim(),
                    remarksMap.get("Status").trim(),
                    remarksMap.get("Initial Amount").trim());
            log.info("Remaks details added successfully");
        } catch (Exception e) {
           log.error("An exception error occured while adding remarks details" , e.getMessage());
           throw  e;
        }

    }





    @Then("I should see approve request success message as {}")
    public void iShouldSeeSpproveRequestSuccessMsg(String expectedApproveRequestMsg) {
        try {
            adminAccountholderDetailsPage.acceptApproveRequest();
            String actualApproveRequestMsg = context.getActualApproveRequestMsg();
            assertEquals(expectedApproveRequestMsg, actualApproveRequestMsg);
            log.info("Approve request alert message is displayed successfully");
        } catch (AssertionError e) {
            log.error("Assertion failed: Approve request alert message is not matched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while seeing the approve request", e.getMessage());
            throw e;
        }
    }

    @When("I reject the request")
    public void iRejectTheRequest() {
        try {
            adminAccountholderDetailsPage.accountReject();
            log.info("Reject the request successfully");
        } catch (Exception e) {
            log.error("An exception error occured while rejecting the request", e.getMessage());
            throw e;
        }
    }

    @Then("I should see reject request success message as {}")
    public void iShouldSeeRejectRequestSuccessfully(String expectedRejectRequestMsg) {
        try {
            adminAccountholderDetailsPage.acceptRejectRequest();
            assertEquals(expectedRejectRequestMsg, context.getActualRejectRequestMsg());
            log.info("Reject request alert message is displayed successfully");
        } catch (AssertionError e) {
            log.error("Assertion failed: Reject request alert message is not matched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while seeing the reject request", e.getMessage());
            throw e;
        }

    }

}
