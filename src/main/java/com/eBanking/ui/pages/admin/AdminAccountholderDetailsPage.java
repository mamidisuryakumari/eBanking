package com.eBanking.ui.pages.admin;

import org.openqa.selenium.By;

import com.eBanking.ui.engine.PropertiesManager;
import com.eBanking.ui.pages.Page;

public class AdminAccountholderDetailsPage extends Page{
	
	private static final By takeActionBtn = By.xpath("//button[text()='Take Action']");
	private static final  By remarkTextFld = By.xpath("//textarea[@name='remark']");
	private static final By statusDropdwn = By.id("status");
	private static final  By initialAmount = By.name("iniamt");
	private static final By updateBtn = By.xpath("//button[text()='Update']");
	
	public void accountApproval() {
		
		bot.click(takeActionBtn)
		.enterText(remarkTextFld,PropertiesManager.getProperty("remark"))
		.selectByValue(statusDropdwn,PropertiesManager.getProperty("status"))
		.enterText(initialAmount, PropertiesManager.getProperty("initialAmount"))
		.click(updateBtn);
		}
	
	
	public String getAdminAccountholderDetailsPage() {
		return driver.getTitle();
	}

}
