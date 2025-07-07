package com.eBanking.ui.pages.user;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;

public class UserProfilePage extends BasePage {
	
private TestContext context;
	
	public UserProfilePage(TestContext context) {
        super(context);
        this.context = context;
	}
	
	private  final By userProfileLabel = By.xpath("//h6[text()='User Profile']");
	private  final By firstNameFld = By.id("fname");
	private  final By lastNameFld = By.id("lname");
	private  final By mobileNumberFld = By.name("mobno");
	private  final By updateBtn = By.id("submit");
	
	public String getUserProfileText() {
		return context.getBot().getText(userProfileLabel);
	}

	public UserProfilePage updateUserProfile(String lastName , String mobileNumber) {
		context.getBot()
		.enterText(lastNameFld, lastName)
		.enterText(mobileNumberFld, mobileNumber)
		.click(updateBtn);
		return this;
	}
	
	public String getUpdateuserProfileAlertSuccessMsg() {
		return context.getBot().getAlertMessage();
	}
	
	public UserProfilePage acceptUserUpdateprofileAlert() {
		context.getBot().acceptAlert();
		 return this;
	}
}
