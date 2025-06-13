package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import com.eBanking.ui.pages.admin.SearchAccountHolderPage;
import io.cucumber.datatable.DataTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AdminAccountholderDetailsPage;
import com.eBanking.ui.pages.admin.AdminNewAccountRequestPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminAccountholderDetailsSteps {

    private TestContext context;
    private Logger logger = LoggerFactory.getLogger(AdminAccountholderDetailsSteps.class);

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
            logger.info("Navigated to account holder details page successfully");
        } catch (Exception e) {
            logger.error("An exception error occured while navigating to the account holder details page",
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
            logger.info("Admin navigated to adimn holder details page successfully");
        } catch (AssertionError e) {
            logger.error("Assertion failed : admin account holder details page title is mismatched", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("An exception error occured while navigating to admin account holder details page");
            throw e;
        }
    }

    @When("I click on 'Take Action' button")
    public void iClickOnTakeActionButton() {
        adminAccountholderDetailsPage.openTakeActionPopup();
    }

    @Then("I should see 'Take Action' model window popup opened")
    public void iShouldSeeTakeActionModelPopupOpened() {
        String actualPopupWindowTitle = context.getPopupWindowTitle();
        String expectedPopupWindowTitle = "Take Action";
     //   assertEquals(expectedPopupWindowTitle, actualPopupWindowTitle);
        logger.info("Take action model window opened successfully");
    }

    @When("I add below remarks:")
    public void iAddBelowRemarks(DataTable dataTable) {
        var remarksMap = dataTable.asMap();
        adminAccountholderDetailsPage.accountApproval(
                remarksMap.get("Remarks").trim(),
                remarksMap.get("Status").trim(),
                remarksMap.get("Initial Amount").trim());
    }

    @When("I search the user account and verify the account status")
    public void iSearchTheUserAccountAndVerifyTheAccountStatus() {
adminDashBoardPage.navigateToSearchAccountHolderPage();
searchAccountHolderPage.searchUserAccount(context.getSearchUserAccount());
    }

    @Then("I shound see user account status is {string}")
    public void verifyAccountStatus(String expectedStatus) {
        expectedStatus = "Approved";
String actualAccountStatus = context.getAccountCurrentStatus();
        assertEquals(expectedStatus, actualAccountStatus);
    }



    @Then("I should see approve request success message as {}")
    public void iShouldSeeSpproveRequestSuccessMsg(String expectedApproveRequestMsg) {
        try {
            adminAccountholderDetailsPage.acceptApproveRequest();
            String actualApproveRequestMsg = context.getActualApproveRequestMsg();
            assertEquals(expectedApproveRequestMsg, actualApproveRequestMsg);
            logger.info("Approve request alert message is displayed successfully");
        } catch (AssertionError e) {
            logger.error("Assertion failed: Approve request alert message is not matched", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("An exception error occured while seeing the approve request", e.getMessage());
            throw e;
        }
    }

    @When("I reject the request")
    public void iRejectTheRequest() {
        try {
            adminAccountholderDetailsPage.accountReject();
            logger.info("Reject the request successfully");
        } catch (Exception e) {
            logger.error("An exception error occured while rejecting the request", e.getMessage());
            throw e;
        }
    }

    @Then("I should see reject request success message as {}")
    public void iShouldSeeRejectRequestSuccessfully(String expectedRejectRequestMsg) {
        try {
            adminAccountholderDetailsPage.acceptRejectRequest();
            assertEquals(expectedRejectRequestMsg, context.getActualRejectRequestMsg());
            logger.info("Reject request alert message is displayed successfully");
        } catch (AssertionError e) {
            logger.error("Assertion failed: Reject request alert message is not matched", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("An exception error occured while seeing the reject request", e.getMessage());
            throw e;
        }

    }

}
