package com.ecommerce.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hooks.Hooks;
import com.ecommerce.pages.ProductDetailsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsPageSteps {

	WebDriver driver = Hooks.getDriver();
	private static Logger log = LoggerFactory.getLogger(ProductDetailsPageSteps.class);

	ProductDetailsPage prodcuDetailsPage = new ProductDetailsPage(driver);
	
	@Then("I should be navigated to product details page")
	public void i_should_be_navigated_to_product_details_page() {
		String expectedProductDetailsPageTitle = "Xonique Fashion Women's Georgette Traditional Ethnic Long Sequins Embroidered Anarkali Gown";
		try {
			Assert.assertEquals(prodcuDetailsPage.getProductDetailsPageTitle(), expectedProductDetailsPageTitle);
			log.info("Product details page title is matched");
		} catch (AssertionError ae) {
			log.error("Assertion failed while  product details page title", ae);
			throw ae;
		} catch (Exception e) {
			log.error("An error occured while verifying the product details page title", e);
			throw e;
		}
	}
	
	

	@Then("I should be navigated to product details page1")
	public void i_should_be_navigated_to_product_details_page1() {
		String expectedProductDetailsPageTitle = "Sejal's Anarkali Kurti";
		try {
			Assert.assertEquals(prodcuDetailsPage.getProductDetailsPageTitle(), expectedProductDetailsPageTitle);
			log.info("Product details page title is matched");
		} catch (AssertionError ae) {
			log.error("Assertion failed while  product details page title", ae);
			throw ae;
		} catch (Exception e) {
			log.error("An error occured while verifying the product details page title", e);
			throw e;
		}
	}



	
	@When("I add the first product to the cart")
	public void i_add_the_first_product_to_the_cart() {
		try {
		prodcuDetailsPage.addProductToCart();
		log.info("The first product is added to cart");
		} catch (Exception e) {
			log.error("An exception occured while add the first product", e);
			throw e;
		}
	}
	
	@When("I add the second product to the cart")
	public void i_add_the_second_product_to_the_cart() {
	  prodcuDetailsPage.addAndViewProductToCart();
	}
	

	@Then("I should be navigated to the product details page")
	public void i_should_be_navigated_to_the_product_details_page() {
	  String exceptedProducttext = "Xonique Fashion Women's Georgette Traditional Ethnic Long Sequins Embroidered Anarkali Gown";
	try {
		Assert.assertEquals(prodcuDetailsPage.getProductDetailsPageTitle(), exceptedProducttext);
		log.info("Text is matched");
	} catch(AssertionError ae) {
		log.error("Assertion failed" ,ae);
		throw ae;
	}
	catch (Exception e) {
		log.error("An unexcepted error occured while navigating product details page");
		throw e;
	}
	}
	

	@When("I add the product to cart")
	public void i_add_the_product_to_cart() {
		try {
			prodcuDetailsPage.addAndViewProductToCart();
			log.info("Product is added to cart");
		} catch (Exception e) {
			log.error("An error occured while adding product to the cart");
		}
	}
	
	@When("I add the product to the cart")
	public void i_add_the_product_to_the_cart() {
	    prodcuDetailsPage.addProductToCart();
	}



}
