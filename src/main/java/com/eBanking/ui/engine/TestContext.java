package com.eBanking.ui.engine;



import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class TestContext {
	
	private WebDriver driver;
	private Bot bot;

	private  String userEmailId;
	private  String userPassword;

	private String SearchUserAccount;
	private String cashierEmpId;
	private String cashierFirstName;
	private String cashierLastName;
	public String getCashierFullName() {
		return cashierFirstName + " " + cashierLastName;
	}
	private String cashierAddress;
	private String cashierPassword;
	private String PopupWindowTitle;
	private String AccountCurrentStatus;

	private String actualUserAccountSubmissionSuccessMsg;
	private String actualUserRegistrationSuccessMsg;
	private String actualApproveRequestMsg;
	private String actualRejectRequestMsg;

	private double calculateBalance;

	
}
