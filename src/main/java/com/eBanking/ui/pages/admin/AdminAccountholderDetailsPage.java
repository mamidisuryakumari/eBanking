package com.eBanking.ui.pages.admin;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.engine.TestContext;

public class AdminAccountholderDetailsPage extends BasePage {
	
private TestContext context;
	
	public AdminAccountholderDetailsPage(TestContext context) {
		super(context);
		this.context = context;
	}
	
	private final By takeActionBtn = By.xpath("//button[text()='Take Action']");
	private final By popupWindowTitle = By.xpath("//h5[text()='Take Action']");
	private final  By remarkTextFld = By.xpath("//textarea[@name='remark']");
	private  final By statusDropdwn = By.id("status");
	private  final  By initialAmountFld = By.name("iniamt");
	private  final By updateBtn = By.xpath("//button[text()='Update']");
	
	public AdminAccountholderDetailsPage openTakeActionPopup(){
		context.getBot().click(takeActionBtn);
		System.out.println(context.getBot().getWebElement(popupWindowTitle).getText());
		context.setPopupWindowTitle(context.getBot().getWebElement(popupWindowTitle).getText());
		return this;
	}
	public AdminAccountholderDetailsPage accountApproval(String remark, String status, String initialAmount) {

		context.getBot().enterText(remarkTextFld,remark)
		.selectByValue(statusDropdwn,status)
		.enterText(initialAmountFld,initialAmount )
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
