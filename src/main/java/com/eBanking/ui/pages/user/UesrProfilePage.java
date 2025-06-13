package com.eBanking.ui.pages.user;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.TestContext;

public class UesrProfilePage extends BasePage {
	
private TestContext context;
	
	public UesrProfilePage(TestContext context) {
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

	public UesrProfilePage updateUserProfile(String firstName, String lastName , String mobileNumber) {
		context.getBot().enterText(firstNameFld, firstName)
		.enterText(lastNameFld, lastName)
		.enterText(mobileNumberFld, mobileNumber)
		.click(updateBtn);
		return this;
	}
	
	public String getUpdateuserProfileSuccessMsg() {
		return context.getBot().getAlertMessage();
	}
	
	public  UesrProfilePage acceptUserUpdateprofileAlert() {
		context.getBot().acceptAlert();
		 return this;
	}
}
