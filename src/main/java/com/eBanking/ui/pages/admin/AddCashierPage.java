package com.eBanking.ui.pages.admin;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;

public class AddCashierPage extends BasePage {

	private TestContext context;

	public AddCashierPage(TestContext context) {
		super(context);
		this.context = context;
	}

	private final By addCashierlabel = By.xpath("//h1[text()='Add Cashier']");
	private final By firstNameTextFld = By.name("fname");
	private final By lastNameTextFld = By.name("lname");
	private final By mobileNumberTextFld = By.name("mobnum");
	private final By emailTextFld = By.name("email");
	private final By genderDropDownFld = By.xpath("//select[@name='gender']");
	private final By dobFld = By.name("dob");
	private final By empIDFld = By.name("empid");
	private final By addressInputFld = By.name("address");
	private final By passwordFld = By.name("password");
	private final By addBtn = By.id("submit");
	private final By adminDashboard = By.xpath("//span[text()='Dashboard']");
	
	
	public AdminDashBoardPage navigateToAdminDashBoardPage() {
		context.getBot().click(adminDashboard);
		return new AdminDashBoardPage(context);
	}

	public String getAddCashierText() {
		return context.getBot().getText(addCashierlabel);
	}

	public AddCashierPage addCashier(String firstName, String lastName, String mobileNumber, String email, String dob,
			String empId, String addressFld, String password) {
		context.getBot().enterText(firstNameTextFld, firstName)
		                .enterText(lastNameTextFld, lastName)
				        .enterText(mobileNumberTextFld, mobileNumber)
				        .enterText(emailTextFld, email)
				        .selectByValue(genderDropDownFld, PropertiesManager.getProperty("gender.value"))
				        .enterText(dobFld, dob)
				        .enterText(empIDFld, empId)
				        .enterText(addressInputFld, addressFld)
				        .enterText(passwordFld, password)
				        .click(addBtn);
		context.setCashierEmpId(empId);
		context.setCashierFirstName(firstName);
		context.setCashierLastName(lastName);
		context.setCashierAddress(addressFld);
		context.setCashierPassword(password);
		return this;
	}

	public String getCashierAddAlertMsg() {
		return context.getBot().getAlertMessage();
	}

	public AddCashierPage acceptCashierAddAlertMsg() {
		context.getBot().acceptAlert();
		return this;
	}

}
