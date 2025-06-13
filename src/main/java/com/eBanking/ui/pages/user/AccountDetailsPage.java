package com.eBanking.ui.pages.user;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;

public class AccountDetailsPage extends BasePage {
	
	private TestContext context;
	
	public AccountDetailsPage(TestContext context) {
        super(context);
        this.context = context;
	}

	private final By accountDetailsText = By.xpath("//h3[text()='Account Details']");
	private final By AddressProffDropdown = By.xpath("//select[@name='addproof']");
	private final By addressProffIDNumberFld = By.xpath("//input[@id='addpidnum']");
	private final By pancardNumberFld = By.id("pancardnum");
	private final By addressFld = By.name("address");
	private final By submitBtn = By.id("submit");
	private final By acceptCheckbox = By.id("tandc");
	private final By dobDate = By.id("dob");

	private final By uploadAddressProffFilePath = By.xpath("//input[@id='attaddproof']");
	private final By uploadPanCardFilePath = By.id("uplpancard");

	public String getAccountDetailsText() {
		return context.getBot().getText(accountDetailsText);
	}
	
	public AccountDetailsPage acceptAccountSubmition() {
    String actualUserAccountSubmissionSuccessMsg = context.getBot().getAlertMessage();
    context.setActualUserAccountSubmissionSuccessMsg(actualUserAccountSubmissionSuccessMsg);
    context.getBot().acceptAlert();
    return this;
	}
	

	public UserDashboardPage enterAccountDetails(String addressProffIDNumber, String pancardNumber, String address, String dob) {
		context.getBot().selectByValue(AddressProffDropdown, PropertiesManager.getProperty("addressProof"))
				.enterText(addressProffIDNumberFld, addressProffIDNumber)
				.fileUpload(uploadAddressProffFilePath,PropertiesManager.getProperty("upload.AddressProof.FilePath"))
				.fileUpload(uploadPanCardFilePath,PropertiesManager.getProperty("upload.pancard.FilePath"))
				.enterText(pancardNumberFld, pancardNumber)
				.enterText(addressFld, address).enterText(dobDate, dob).checkCheckbox(acceptCheckbox).click(submitBtn);
		return new UserDashboardPage(context);
	}

	

}
