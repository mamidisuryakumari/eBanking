package com.eBanking.stepDefinitions;

import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AdminAccountholderDetailsPage;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import com.eBanking.ui.pages.admin.ApporvedAccountOpeningRequestsPage;
import com.eBanking.ui.pages.user.ManagePayeePage;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApprovedAccountRequestPageSteps {
    private TestContext context;
    private ApporvedAccountOpeningRequestsPage apporvedAccountOpeningRequestsPage;
    private AdminDashBoardPage adminDashBoardPage;
    private ManagePayeePage managePayeePage;
    private AdminAccountholderDetailsPage adminAccountholderDetailsPage;

    public ApprovedAccountRequestPageSteps(TestContext context) {
        this.context = context;
        this.apporvedAccountOpeningRequestsPage = new ApporvedAccountOpeningRequestsPage(context);
        this.managePayeePage = new ManagePayeePage(context);
        this.adminDashBoardPage = new AdminDashBoardPage(context);
        this.adminAccountholderDetailsPage = new AdminAccountholderDetailsPage(context);
    }

    @When("I go to approved account request page")
    public void iGoToApprovedAccountRequestPage() {
        try{
            adminDashBoardPage.navigateToApprovedAccountRequestPage();
            apporvedAccountOpeningRequestsPage.listOfAccountHolders();
            log.info("Navigated to approved account request page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to approved account request page", e);
            throw e;
        }

    }

    @When("I navigated to the admin account holder details page")
    public void iNavigatedToTheAdminAccountHolderDetailsPage() {
        try{
            adminAccountholderDetailsPage.getPayeeAccountNumber();
            log.info("Navigate to admin account holder details page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the admin holder details page");
            throw e;
        }

    }

    @When("I compare manage payee and approved account holder")
    public void iCompareManagePayeeAndApprovedAccountHolder() {
        try {
            managePayeePage.getPayeeName();
            apporvedAccountOpeningRequestsPage.searchApprovedAccount(context.getPayeeName());
            log.info("manage payee and approved account holder compared successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while comparing manage payee and approved account holder");
            throw new RuntimeException(e);
        }

    }
}
