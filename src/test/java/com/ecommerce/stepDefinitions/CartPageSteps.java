package com.ecommerce.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hooks.Hooks;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.ProductDetailsPage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.utilities.Elements;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageSteps {

	WebDriver driver = Hooks.getDriver();
	ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
	CartPage cartPage = new CartPage(driver);

	private static Logger log = LoggerFactory.getLogger(CartPageSteps.class);

	@Then("I should see the product added to the cart successfully")
	public void i_should_see_the_product_added_to_the_cart_successfully() {
		int exceptedItemQuantity = 1;
		try {
			Assert.assertEquals(productDetailsPage.getItemQuantity(), exceptedItemQuantity);
			log.info("The cart quantity is matched");
		} catch (AssertionError ae) {
			log.error("assertion failed ", ae);
			throw ae;
		} catch (Exception e) {
			log.error("The cart quantity is not matched", e);
			throw e;
		}

	}
	
	@Then("I should see the multiple products added to the cart successfully")
	public void i_should_see_the_multiple_products_added_to_the_cart_successfully() {
		int exceptedItemQuantity = 2;
		try {
			Assert.assertEquals(cartPage.getItemQuantity(), exceptedItemQuantity);
			log.info("The cart quantity is matched");
		} catch (AssertionError ae) {
			log.error("assertion failed ", ae);
			throw ae;
		} catch (Exception e) {
			log.error("The cart quantity is not matched", e);
			throw e;
		}
	}

	

	@When("I navigate back to product details page")
	public void i_navigate_back_to_product_details_page() {
		try {
			driver.navigate().back();
			log.info("navigate back to product details page successfully");
		} catch (Exception e) {
			log.error("Failed to navigate back to product details page");
		}

	}

	

	@Then("I should see the {int} products added to the cart successfully")
	public void i_should_see_the_products_added_to_the_cart_successfully(Integer int1) {
		int exceptedItemQuantity = 2;
		try {
			Assert.assertEquals(cartPage.getItemQuantity(), exceptedItemQuantity);
			log.info("The cart quantity is matched");
		} catch (AssertionError ae) {
			log.error("assertion failed ", ae);
			throw ae;
		} catch (Exception e) {
			log.error("The cart quantity is not matched", e);
			throw e;
		}
	}

}
