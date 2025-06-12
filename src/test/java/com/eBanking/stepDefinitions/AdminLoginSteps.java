package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.HomePage;
import com.eBanking.ui.pages.admin.AdminLoginPage;

import enums.UserType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminLoginSteps {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginSteps.class);
	private TestContext context;
	AdminLoginPage adminLoginPage;
	HomePage homePage;
	
	public AdminLoginSteps(TestContext context) {
		this.context = context;
		this.homePage = new HomePage(context);
		this.adminLoginPage = new AdminLoginPage(context);
	}
	
	@When("I navigate to admin login page as a {}")
	public void iNavigateToAdminLoginPage(String user) {
		try {
			UserType userType = UserType.valueOf(user.toUpperCase());
			homePage.navigateToPage(userType);
			logger.info("Navigated to the admin login page successfully");
		} catch (Exception e) {
			logger.error("An exception error occured while navigating to admin login page" ,e.getMessage());
			throw e;
		}
		
	}
	
	@When("I go to the admin login page")
	public void iGoToAdminLoginPage() {
	try {
		homePage.navigatedToAdminLoginPage();
		logger.info("Navigated to the admin login page successfully");
	} catch (Exception e) {
		logger.error("An exception error occured while navigating to the admin login page" , e.getMessage());
		throw e;
	}
		
	}
    @Then("I am on admin login page")
    public void iAmOnAdminLoginPage() {
    	try {
			String actualAdminDashBoardPageTitle = adminLoginPage.getAdminLoginPageTitle();
			String exceptedAdminDashBoardPageTitle = PropertiesManager.getProperty("admin.Loginpage.title");
			assertEquals(exceptedAdminDashBoardPageTitle, actualAdminDashBoardPageTitle);
			logger.info("Admin login page title is matched");
		} catch (AssertionError e) {
			logger.error("Assertion failed: Admin login page title mismatch", e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error("An exception occured while navigating to admin login page");
			throw e;
		}
	}
    
    @When("I log in to admin with valid credentials")
    public void iLogInWithValidCredentails(DataTable adminUserDetails) {
    	try {
			 var adminUserDetailsMap = adminUserDetails.asMap();
			   adminLoginPage.adminLogin(adminUserDetailsMap.get("Email Address"),
					   adminUserDetailsMap.get("Password"));
			   logger.info("Admin logged successfully");
			   } catch (Exception e) {
			logger.error("An unexcepted error occured while login the application", e);
			throw e;
		}
	  
	}
    }
    
     
	
	
	
	
