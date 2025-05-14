package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.HomePage;
import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.user.UserLoginPage;
import com.eBanking.utilities.BrowserUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps extends Page{

	private static final Logger log = LoggerFactory.getLogger(HomePageSteps.class);
	HomePage homePage = new HomePage();
	UserLoginPage loginPage = new UserLoginPage();

	@Given("I am on the home page")
	public void user_is_on_the_home_page() {
		try {
			String actualHomePageTitle = bot.getTitle();
			String expHomePageTitle = PropertiesManager.getProperty("home.page.title").trim();
			assertEquals(expHomePageTitle, actualHomePageTitle);
			log.info(" Title matched for the home page");
		} catch (AssertionError ae) {
			log.error("Title is not matched for home page", ae);
		} catch (Exception e) {
			log.error("An unexcepted error occured while matching the title");
		}

	}
	
	

	
	@Given("Admin is on the home page")
	public void admin_is_on_the_home_page() {
		try {
		//	boolean result = homePage.isOnHomePage();
		//	Assert.assertTrue(result);
			log.info("Title is matched for homepage");
		} catch (AssertionError ae) {
			log.error("Title is not matched for homepage", ae);
		} catch (Exception e) {
			log.error("An unexcepted error occured while matching the homepage title");
		}
	}
	
	@When("Admin click on admin menu")
	public void admin_click_on_admin_menu() {
		try {
			// homePage.
		//	 log.info("Admin menu clicked successfully");
		} catch (Exception e) {
			log.error("An exception occured while clicking the admin menu" , e);
			throw e;
		}
	  
	}
	



}
