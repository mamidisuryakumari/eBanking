package com.eBanking.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.hooks.Hooks;
import com.eBanking.pages.HomePage;
import com.eBanking.pages.LoginPage;

import io.cucumber.java.en.Given;

public class HomePageSteps {

	WebDriver driver = Hooks.getDriver();
	Logger log = LoggerFactory.getLogger(HomePageSteps.class);
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);

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
}
