package com.ecommerce.stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hooks.Hooks;
import com.ecommerce.pages.AdvancedRegisterPages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdvancedRegistrationpageSteps {
	
	

		WebDriver driver = Hooks.getDriver();
	AdvancedRegisterPages advancedRegisterPages = new AdvancedRegisterPages(driver);
	private static Logger log = LoggerFactory.getLogger(AdvancedRegistrationpageSteps.class);

		@Given("I am on advanced registration form page")
		public void i_am_on_advanced_registration_form_page() {
			
			try {
				String exceptedTitle = "Advanced Registration Form|Software Testing Online";
				String actualTitle = advancedRegisterPages.getAdvancedRegisterTitle();
				Assert.assertEquals(exceptedTitle, actualTitle);
				log.info("The title is matched");
			} catch (AssertionError ae) {
				log.error("Assertion failed", ae);
				throw ae;
			}catch (Exception e) {
				log.error("An unexcepted error occured while matching the title");
				throw e;
				
			}
		   
		}
		@When("I add below values in advanced registration form")
		public void i_add_below_values_in_advanced_registration_form(io.cucumber.datatable.DataTable dataTable) {
		   Map<String,String> registerForm = dataTable.asMap(String.class, String.class);
		   
		   advancedRegisterPages.enterDetails(registerForm.get("UserName"), registerForm.get("Password"), registerForm.get("Email"));
		}
		@When("I click on register button")
		public void i_click_on_register_button() {
		   
		}
		@Then("I should see registration successfull pop up message")
		public void i_should_see_registration_successfull_pop_up_message() {
		   
		}




}
