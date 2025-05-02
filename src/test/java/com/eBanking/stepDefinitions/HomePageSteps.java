package com.eBanking.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.HomePage;
import com.eBanking.pages.UserLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	WebDriver driver = Hooks.getDriver();
	Logger log = LoggerFactory.getLogger(HomePageSteps.class);
	HomePage homePage = new HomePage(driver);
	UserLoginPage loginPage = new UserLoginPage(driver);

	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
		try {
			String actualTitle = homePage.getHomePageTitle();
			String expTitle = "e-Banking System";
			Assert.assertEquals(expTitle, actualTitle);
			log.info("Title is matched");
		} catch (AssertionError ae) {
			log.error("Title is not matched", ae);
		} catch (Exception e) {
			log.error("An unexcepted error occured while matching the title");
		}

	}
	
	

	@When("User click on user menu")
	public void user_click_on_user_menu() {
		try {
			homePage.clickOnUserMenu();
			log.info("User menu clicked successfully");
		} catch (Exception e) {
			log.error("An exception occured while clicking the user menu" , e);
			throw e;
		}
		
	}
	@Given("Admin is on the home page")
	public void admin_is_on_the_home_page() {
		try {
			String actualTitle = homePage.getHomePageTitle();
			String expTitle = "e-Banking System";
			Assert.assertEquals(expTitle, actualTitle);
			log.info("Title is matched");
		} catch (AssertionError ae) {
			log.error("Title is not matched", ae);
		} catch (Exception e) {
			log.error("An unexcepted error occured while matching the title");
		}
	}
	
	@When("Admin click on admin menu")
	public void admin_click_on_admin_menu() {
		try {
			 homePage.clickOnAdminMenu();
			 log.info("Admin menu clicked successfully");
		} catch (Exception e) {
			log.error("An exception occured while clicking the admin menu" , e);
			throw e;
		}
	  
	}
	



}
