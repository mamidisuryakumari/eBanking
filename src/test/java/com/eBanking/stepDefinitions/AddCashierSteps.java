package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.Common;
import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.admin.AddCashierPage;
import com.eBanking.ui.pages.admin.AdminDashBoardPage;
import com.eBanking.ui.pages.admin.CashierDetailsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCashierSteps {
	
	private final Logger logger = LoggerFactory.getLogger(AddCashierSteps.class);
	
	private TestContext context;
	private AddCashierPage addCashierPage;
	private AdminDashBoardPage adminDashBoardPage;
	
	public AddCashierSteps(TestContext context) {
		this.context = context;
		this.addCashierPage = new AddCashierPage(context);
		this.adminDashBoardPage = new AdminDashBoardPage(context);
	}
	
	@When("I navigate to the add cashier page")
	public void navigateToTheAddCashierPage() {
		try {
			adminDashBoardPage.navigateToAddCashierPage();
			logger.info("Navigated to the add cashier page successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while navigating to the add cashier page" , e.getMessage());
			throw e;

		}
	}
    @Then("I should be on the add cashier page")
    public void IShouldBeOnTheAddCashierPage() {
    	try {
			String actualAddCashierPageText = addCashierPage.getAddCashierText();
			String expectedAddCashierPageText = PropertiesManager.getProperty("add.cashier.text");
			assertEquals(expectedAddCashierPageText, actualAddCashierPageText);
			logger.info("Add cashier text is matched");
		} catch (AssertionError e) {
			logger.error("Assertion failed: Add cashier text is mismatched" ,e.getMessage());
			throw e;
		}catch (Exception e) {
			logger.error("An exception error occured while verifying add cashier text", e.getMessage());
			throw e;
		}
    }
    @When("I add the following cashier details")
    public void iAddTheFollowingCashierDetails(DataTable addCashierDetails) {
    	try {
    		var addCashierDetailsMap = addCashierDetails.asMap();
        	addCashierPage.addCashier(addCashierDetailsMap.get("First Name").replace("${random}", Common.random()),
        			addCashierDetailsMap.get("Last Name"),
        			addCashierDetailsMap.get("Mobile Number").replace("${random}", Common.random()),
        			addCashierDetailsMap.get("Email").replace("${random}", Common.random()),
        			addCashierDetailsMap.get("Date of Birth"),
        			addCashierDetailsMap.get("Emp ID").replace("${random}", Common.random()),
        			addCashierDetailsMap.get("Address"),
        			addCashierDetailsMap.get("Password"));
        	logger.info("Cashier details added successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while adding cashier details" , e.getMessage());
			throw e;
		}
    	
    }
      
    @Then("I should see a confirmation message that the cashier was added successfully")
    public void iShouldSeeConfirmationMessageThatTheCashierWasAddedSuccessfully() {
    	try {
			String actualAddCashierAlertText=addCashierPage.getCashierAddAlertMsg();
			String ExceptedAddCashierAlertText = PropertiesManager.getProperty("cashier.add.alert.msg");
			assertEquals(ExceptedAddCashierAlertText, actualAddCashierAlertText);
			logger.info("Add cashier alert text is matched");
			addCashierPage.acceptCashierAddAlertMsg();
		} catch (AssertionError e) {
			logger.error("Assertion failed : Add cashier alert text is mismatched", e.getMessage());
			throw e;
		}catch (Exception e) {
			logger.error("An exception error occured while verifying cashier added message", e.getMessage());
			throw e;
		}
    }
    
    @When("I go to admin dashboard page")
    public void iGoToAdminDashboardPage() {
    	try {
			addCashierPage.navigateToAdminDashBoardPage();
			logger.info("Navigated to dashboard page successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while navigating to the admin dashboard page" , e.getMessage());
			throw e;
		}
    }

}
