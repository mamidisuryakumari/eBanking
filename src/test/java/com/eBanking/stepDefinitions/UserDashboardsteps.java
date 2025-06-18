package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.eBanking.ui.pages.user.UserLoginPage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.user.UserDashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Slf4j
public class UserDashboardsteps {

    private TestContext context;
    private UserDashboardPage userDashboardPage;
    private UserLoginPage userLoginPage;

    public UserDashboardsteps(TestContext context) {
        this.context = context;
        this.userDashboardPage = new UserDashboardPage(context);
        this.userLoginPage = new UserLoginPage(context);
    }


    @Then("I should be navigated to the user dashboard page")
    public void user_should_be_navigated_to_dashboard_page() {
        try {
            String actualDashboardPageTitle = userDashboardPage.getDashboardPageTitle();
            String exceptedDashboardPageTitle = PropertiesManager.getProperty("userDashboard.page.title");
            assertEquals(exceptedDashboardPageTitle, actualDashboardPageTitle);
            log.info("Title is matched for user dashboard page");
        } catch (AssertionError e) {
            log.error("Title is not matched for user dashboard", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to dashboard page", e);
            throw e;
        }
    }

    @When("I click on logout link")
    public void iClickOnLogoutLink() {
        try {
            userDashboardPage.clickOnLogOutLink();
            log.info("Logout link clicked successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while clicking the logout link");
            throw e;
        }
    }

    @Then("I should see ready to leave confirmation pop up")
    public void iShouldSeeReadyToLeaveConfirmationPopup() {
        try {
            String actualUserLogoutConfirmationPopup = userDashboardPage.getUserLogoutPopupText();
            String expectedUserLogoutConfirmationPopup = PropertiesManager.getProperty("user.logout.confirmation.popup.text");
            assertEquals(expectedUserLogoutConfirmationPopup, actualUserLogoutConfirmationPopup);
            log.info("User logout confirmation popup title is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed: User logout confirmation popup title is mismatched");
            throw e;
        } catch (Exception e) {
            log.error("An exception error occurred while seeing user logout confirmation popup");
            throw e;
        }
    }

    @When("I clicks on logout button")
    public void iClicksOnLogoutButton() {
        try {
            userDashboardPage.clickOnUserLogoutBtn();
            log.info("Logout button clicked successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while clicking logout button", e.getMessage());
            throw e;
        }
    }

    @Then("I should see user logout successfully")
    public void iShouldSeeUserLogoutSuccessfully() {
        try {
            log.info("User logout successfully");
        } catch (Exception e) {
            log.error("An exception error occurred during logout", e.getMessage());
            throw e;
        }
    }

    @Then("I should be navigated to the user login page")
    public void iShouldBeNavigatedToTheUserLoginPage() {
        try {
            String actualUserLoginPageTitle = userLoginPage.getUserLoginPageTitle();
            String expectedUserLoginPageTitle = PropertiesManager.getProperty("user.login.page.title");
            assertEquals(expectedUserLoginPageTitle, actualUserLoginPageTitle);
            log.info("User login page title is matched");
        } catch (AssertionError e) {
            log.error("Assertion faild: User login page title is mismatched", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An exception error occured while navigating to the user login page", e.getMessage());
            throw e;
        }
    }




}
