package com.eBanking.ui.engine;



import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

import java.util.List;

@Getter
@Setter
public class TestContext {
	
	private WebDriver driver;
	private Bot bot;

	private  String userEmailId;
	private  String userPassword;
	private String userNewPassword;

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
	private String cashierUserAccount;
	private String cashierNewPassword;

	private String actualUserAccountSubmissionSuccessMsg;
	private String actualUserRegistrationSuccessMsg;
	private String actualApproveRequestMsg;
	private String actualRejectRequestMsg;

	private String AdminEmail;
	private String adminPassword;
	private String adminNewPassword;
	private String payeeName;
	private String payeeAccountNumber;

	private List<String> managePayyeAccount;
	private List<String> approvedAccount;

	private double calculateBalance;

	
}
