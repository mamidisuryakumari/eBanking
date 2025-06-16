package com.eBanking.stepDefinitions;

import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import com.eBanking.ui.pages.admin.SearchAccountHolderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class SearchAccountHolderPageSteps {

    private TestContext context;
     AdminDashBoardPage adminDashBoardPage;
     SearchAccountHolderPage searchAccountHolderPage;
    public SearchAccountHolderPageSteps(TestContext context){
        this.context = context;
        this.adminDashBoardPage = new AdminDashBoardPage(context);
        this.searchAccountHolderPage = new SearchAccountHolderPage(context);
    }

    @When("I search the user account and verify the account status")
    public void iSearchTheUserAccountAndVerifyTheAccountStatus() {

            adminDashBoardPage.navigateToSearchAccountHolderPage();
            searchAccountHolderPage.searchUserAccount(context.getSearchUserAccount());


    }

    @Then("I should see user account status is {string}")
    public void verifyAccountStatus() {
      String   expectedStatus = "Approved";
        String actualAccountStatus = context.getAccountCurrentStatus();
        assertEquals(expectedStatus, actualAccountStatus);
    }
}
