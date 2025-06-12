package com.eBanking.ui.engine;

import org.openqa.selenium.WebDriver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestContext {
	
	private WebDriver driver;
	private Bot bot;
	
	public  String userEmailId;
	public  String userPassword;
	
	public String cashierEmpId;
	public String cashierFirstName;
	public String cashierLastName;
	public String cashierAddress;
	
	public String actualUserAccountSubmissionSuccessMsg;
	public String actualUserRegistrationSuccessMsg;
	public String actualApproveRequestMsg;
	public String actualRejectRequestMsg;
	
	public double calculateBalance;

	
}
