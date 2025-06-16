package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import com.eBanking.ui.pages.admin.AdminNewAccountRequestPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Slf4j
public class AdminNewAccountRequestSteps {

    private TestContext context;


    AdminNewAccountRequestPage adminNewAccountRequestPage;
    AdminDashBoardPage adminDashBoardPage;

    public AdminNewAccountRequestSteps(TestContext context) {
        this.context = context;
        this.adminDashBoardPage = new AdminDashBoardPage(context);
        this.adminNewAccountRequestPage = new AdminNewAccountRequestPage(context);
    }

    @When("I go to the new account request page")
    public void iGoToTheNewAccountRequestPage() {
        try {
            adminDashBoardPage.navigateToNewAccountRequestPage();
            log.info("Navigated to account request page successfully");
        } catch (Exception e) {
            log.error("An exception error occured while navigating to the account request page", e.getMessage());
            throw e;
        }


    }

    @Then("I am on new account request page")
    public void iAmOnNewAccountRequestPage() {
        try {
            String actualAdminNewAccountRequestPage = adminNewAccountRequestPage.getAdminNewAccountRequestPageTitle();
            String exceptedAdminNewAccountRequestPage = PropertiesManager
                    .getProperty("admin.NewAccountrequest.page.title");
            assertEquals(exceptedAdminNewAccountRequestPage, actualAdminNewAccountRequestPage);
            log.info("Admin navigate to the admin new account request page successfully");
        } catch (AssertionError e) {
            log.error("Assertion failed: Admin New Account Request page title mismatch", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Exception occurred while navigating to Admin New Account Request page", e);
            throw e;
        }

    }

    @When("I search an user account")
    public void iSearchAnUserAccount() {
        try {
            adminNewAccountRequestPage.searchUserAccount();
            log.info("Search user account successfully");
        } catch (Exception e) {
            log.error("An exception error occured while navigating to search user account" ,e.getMessage());
            throw  e;
        }
    }

    @When("I view the user account")
    public void iViewTheUserAccount() {
        try {
            adminNewAccountRequestPage.getAdminNewAccountRequesttext();
            log.info("The user account viewed successfully");
        } catch (Exception e) {
           log.error("An exception error occured while viewing the user account" , e.getMessage());
           throw  e;
        }

    }


}

	