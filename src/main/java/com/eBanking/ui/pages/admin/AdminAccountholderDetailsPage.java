package com.eBanking.ui.pages.admin;

import org.openqa.selenium.By;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;

public class AdminAccountholderDetailsPage {
	
private TestContext context;
	
	public AdminAccountholderDetailsPage(TestContext context) {
		this.context = context;
	}
	
	private final By takeActionBtn = By.xpath("//button[text()='Take Action']");
	private final  By remarkTextFld = By.xpath("//textarea[@name='remark']");
	private  final By statusDropdwn = By.id("status");
	private  final  By initialAmount = By.name("iniamt");
	private  final By updateBtn = By.xpath("//button[text()='Update']");
	
	
	public AdminAccountholderDetailsPage accountApproval() {
		context.getBot().click(takeActionBtn)
		.enterText(remarkTextFld,PropertiesManager.getProperty("remark"))
		.selectByValue(statusDropdwn,PropertiesManager.getProperty("status"))
		.enterText(initialAmount, PropertiesManager.getProperty("initialAmount"))
		.click(updateBtn);
		return this;
		}
	
	public AdminAccountholderDetailsPage accountReject() {
		context.getBot().click(takeActionBtn)
		.enterText(remarkTextFld,PropertiesManager.getProperty("reject.remark"))
		.selectByValue(statusDropdwn,PropertiesManager.getProperty("reject.status"))
		.click(updateBtn);
		return this;
	}
	
	public String getAdminAccountholderDetailsPage() {
		return context.getBot().getTitle();
	}
	
	
	public AdminAccountholderDetailsPage acceptRejectRequest() {
		String actualRejectRequestMsg	= context.getBot().getAlertMessage();
		context.setActualRejectRequestMsg(actualRejectRequestMsg);
		context.getBot().acceptAlert();
		return this;
	}
	
	
	public AdminAccountholderDetailsPage acceptApproveRequest() {
	String actualApproveRequestMsg	= context.getBot().getAlertMessage();
	context.setActualApproveRequestMsg(actualApproveRequestMsg);
		context.getBot().acceptAlert();
		return this;
	}
}
