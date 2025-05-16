package com.eBanking.stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.pages.Page;
import com.eBanking.ui.pages.user.UserDashboardPage;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPayeeSteps extends Page{
	
	
	UserDashboardPage userDashboardPage = new UserDashboardPage();
	

	private static Logger log = LoggerFactory.getLogger(AddPayeeSteps.class);
	
	@When("I add following payee account details")
	public void the_user_add_following_payye_account_details(io.cucumber.datatable.DataTable dataTable) {
		
		
	}
	
	@Then("I should be navigated to the add payee page")
	public void i_should_be_navigated_to_the_add_payee_page() {
	   
	}
	@Then("I should see the message {string}")
	public void i_should_see_the_message(String string) {
	   
	}


}
