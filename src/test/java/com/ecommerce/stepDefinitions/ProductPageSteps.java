package com.ecommerce.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hooks.Hooks;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.ProductDetailsPage;
import com.ecommerce.pages.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps {

	WebDriver driver = Hooks.getDriver();
	private static Logger log = LoggerFactory.getLogger(ProductPageSteps.class);
	ProductPage productPage = new ProductPage(driver);
	ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
	CartPage cartPage = new CartPage(driver);

	@Given("I am on the product page")
	public void i_am_on_the_product_page() {
		String expectedTitle = "ynrstore";

		try {
			String actualTitle = productPage.getProductPageTitle();
			Assert.assertEquals(expectedTitle, actualTitle);
			log.info("Product page title matched: ");
		} catch (AssertionError ae) {
			log.error("Assertion failed while verifying product page title", ae);
			throw ae;
		} catch (Exception e) {
			log.error("An exception error occurred while verifying product page title", e);
			throw e;
		}
	}

	@When("I select single product")
	public void i_select_single_product() {
		try {
			productPage.selectSingleProduct();
			log.error("Product is selected successfully");
		} catch (Exception e) {
			log.error("An exception occured while selecting the product", e);
			throw e;
		}
	}

	@When("I select and add multiple products to the cart")
	public void i_select_multiple_products() {
		String exceptedCartPageTitle = "My Cart";
		try {
			productPage.selectFirstProduct();
			productDetailsPage.addProductToCart();
			productDetailsPage.navigateBackToProductPage();
			productPage.selectSecondProduct();
			productDetailsPage.addAndViewProductToCart();
			Assert.assertEquals(cartPage.getCartPageTitle(), exceptedCartPageTitle);
			log.info("Cart page title is matched");
		} catch (AssertionError ae) {
			log.info("Assertion failed", ae);
			throw ae;
		} catch (Exception e) {
			log.error("An unexcepted error occured", e);
			throw e;
		}

	}

	@When("I select first product")
	public void i_select_first_product_from_the_women_s_category() {
		try {
			productPage.selectFirstProduct();
			log.info("The first product is selected");
		} catch (Exception e) {
			log.error("An exception error occured while selecting the first product", e);
			throw e;
		}
	}

	@When("I navigate back to product page")
	public void i_navigate_back_to_product_page() {
		productDetailsPage.navigateBackToProductPage();
	}

	@Then("I should be navigated to product page")
	public void i_should_be_navigated_to_product_page() {
		try {

		} catch (Exception e) {

		}
	}

	@When("I select second product")
	public void i_select_second_product() {
		productPage.selectSecondProduct2();
	}

	@When("I add multiple products to cart")
	public void i_add_multiple_products_to_cart() {
		productPage.addMultipleProducts();
	}

	@When("I select {string}")
	public void i_select_from_the_women_s_category(String string) {
		productPage.selectFirstProduct();
	}



	

	

}
