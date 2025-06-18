package com.eBanking.stepDefinitions;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
@Slf4j
public class UserProfileSteps {
	
	private TestContext context;
    public UserProfileSteps() {
		this.context = context;
	}
	
	@When("I go to the user profile page")
	public void iGoToTheUserProfilePage() {
		
	}
    @Then("I should see the user profile page")
    public void iShouldSeeTheUserProfilePage() {
    	
    }
    @When("I enter user profile update details")
    public void iEnterUserProfileUpdateDetails() {
    	
    }
      
    @Then("I should see profile updated successfully")
    public void iShouldSeeProfileUpdatedSuccessfully() {
    	
    }

}
