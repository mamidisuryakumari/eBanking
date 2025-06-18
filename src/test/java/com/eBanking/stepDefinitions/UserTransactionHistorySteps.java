package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.user.ManagePayeePage;
import com.eBanking.ui.pages.user.UserDashboardPage;
import com.eBanking.ui.pages.user.UserTransactionHistoryPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
@Slf4j
public class UserTransactionHistorySteps {
	private TestContext context;
	ManagePayeePage managePayeePage;
	UserTransactionHistoryPage userTransactionHistoryPage;
	UserDashboardPage userDashboardPage;

	public UserTransactionHistorySteps(TestContext context) {
		this.context = context;
		this.userTransactionHistoryPage = new UserTransactionHistoryPage(context);
		this.managePayeePage = new ManagePayeePage(context);
		this.userDashboardPage = new UserDashboardPage(context);
	}
	
	@When("I go to the transaction history page")
	public void iGoToTheTransactionHistoryPage() {
		try {
		userDashboardPage.navigateToTransactionHistoryPage();
		log.info("Navigated to transaction history page successfully");
		} catch (Exception e) {
			log.error("An exception error occured while navigating to the transaction history page" , e.getMessage());
			throw e;
		}
	}

	@When("I calculate the transaction balance from the history")
	public void iVerifyTheUserTransactionBalance() {
		try {
	        double calculatedBalance = userTransactionHistoryPage.checkBalance();
			log.info("Transaction balance calculated from history: " + calculatedBalance);
	    } catch (Exception e) {
			log.error("An exception occurred while calculating the transaction balance", e);
	        throw e;
	    }
		
	}
	
	@Then("the calculated transaction balance should match the available balance displayed")
	public void iShouldSeeTheCalculatedBalanceDisplayedCorrectly() {
		try {
			userDashboardPage.navigateToDashBoardPage();
			double actualBalance = userDashboardPage.availableBalance();
		 double calculatedBalance = context.getCalculateBalance();
			assertEquals(actualBalance, calculatedBalance, "Balance mismatch:");
			log.info("The calculated balance displayed correctly");
		} catch (AssertionError e) {
			log.error("Assertion faile: ", e.getMessage());
			throw e;
		}catch (Exception e) {
			log.error("An exception error occured while seeing calculated balance" ,e.getMessage());
			throw e;
		}
	}

}
