package com.eBanking.stepDefinitions;

import com.eBanking.ui.engine.Common;
import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.user.UserDashboardPage;
import com.eBanking.ui.pages.user.UserProfilePage;
import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class UserProfileSteps {
	
	private TestContext context;
    private UserDashboardPage userDashboardPage;
    private UserProfilePage userProfilePage;
    public UserProfileSteps(TestContext context) {
		this.context = context;
        this.userDashboardPage = new UserDashboardPage(context);
        this.userProfilePage = new UserProfilePage(context);
	}
	
	@When("I go to the user profile page")
	public void iGoToTheUserProfilePage() {
		try{
          userDashboardPage.navigatedToTheUserProfilePage();
          log.info("Navigated to the profile page successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while navigating to the user profile page", e.getMessage());
            throw e;
        }
	}
    @Then("I should see the user profile page")
    public void iShouldSeeTheUserProfilePage() {
    	try {
          String actualUserProfileText =   userProfilePage.getUserProfileText();
            String expectedUserProfileText = PropertiesManager.getProperty("user.profile.text");
            assertEquals(expectedUserProfileText, actualUserProfileText);
            log.info("User profile text is matched");
        } catch (AssertionError e) {
            log.error("Assertion failed :User profile text is mismatched ");
            throw e;
        }catch (Exception e) {
            log.error("An exception error occurred while verifying user profile text");
            throw e;
        }
    }
    @When("I enter user profile update details")
    public void iEnterUserProfileUpdateDetails(DataTable dataTable) {
    	try {
            Map<String , String > userUpdateProfileDetails = dataTable.asMap();
           userProfilePage.updateUserProfile(userUpdateProfileDetails.get("Last Name").
                   replace("${random}", Common.random()),
                   userUpdateProfileDetails.get("Mobile Number").replace("${mobileNumber}", Common.generateMobileNumber()));
           log.info("User profile details updated successfully");
        } catch (Exception e) {
            log.error("An exception error occurred while entering user profile update details", e.getMessage());
            throw e;
        }
    }
      
    @Then("I should see profile updated successfully")
    public void iShouldSeeProfileUpdatedSuccessfully() {
    	try{
           String actualProfileUpdatedSuccessAlertMsg = userProfilePage.getUpdateuserProfileAlertSuccessMsg();
           String expectedProfileUpdatedSuccessAlertMsg = PropertiesManager.getProperty("user.profile.updated.success.message");
           assertEquals(expectedProfileUpdatedSuccessAlertMsg, actualProfileUpdatedSuccessAlertMsg);
           log.info("User profile update alert text is matched");
           userProfilePage.acceptUserUpdateprofileAlert();
        } catch (AssertionError e) {
            log.error("Assertion failed:User profile update alert text is mismatched ", e.getMessage());
            throw e;
        }catch (Exception e) {
            log.error("An exception error occurred while seeing user profile update success",e.getMessage());
            throw e;
        }
    }

}
