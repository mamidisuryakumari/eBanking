package com.eBanking.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;
import com.eBanking.ui.pages.HomePage;
import com.eBanking.ui.pages.user.UserLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
@Slf4j
public class HomePageSteps{

	private final TestContext context;
	HomePage homePage;
	UserLoginPage userloginPage;
	
	public HomePageSteps(TestContext context) {
		this.context = context;
		this.homePage = new HomePage(context);
		this.userloginPage = new UserLoginPage(context);
	}
	
	@When("I go to home page")
	public void iGoToHomePage() {
		try {
			context.getDriver().navigate().to(PropertiesManager.getProperty("base.url"));
			log.info("Navigated to the home page");
		} catch (Exception e) {
			log.error("An exception error occured while navigating to home page" ,e.getMessage());
			throw e;
		}
	}

	@Given("I am on the home page")
	public void user_is_on_the_home_page() {
		try {
			String actualHomePageTitle = homePage.getHomePageTitle();
			String expHomePageTitle = PropertiesManager.getProperty("home.page.title").trim();
			assertEquals(expHomePageTitle, actualHomePageTitle);
			log.info(" Title matched for the home page");
		} catch (AssertionError e) {
			log.error("Title is not matched for home page", e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error("An unexcepted error occurred while matching the title" , e);
			throw e;
		}

	}
	
	
	
	



}
