package com.eBanking.ui.pages.admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBanking.ui.pages.Page;
import com.eBanking.utilities.BrowserUtils;
import com.eBanking.utilities.CommonUtils;
import com.eBanking.utilities.DropdownUtil;
import com.eBanking.utilities.Elements;

public class AdminPage extends Page{
	
	
	private static By viewLink = By.xpath("//a[text()='View ']");
	private static By takeActionBtn = By.xpath("//button[text()='Take Action']");
	private static By remarkTextFld = By.xpath("//textarea[@name='remark']");
	private static By statusDropdwn = By.id("status");
	private static By initialAmount = By.name("iniamt");
	private static By updateBtn = By.xpath("//button[text()='Update']");
	
	public void accountApproval() throws IOException {
		Elements.doClick(driver, viewLink);
		Elements.doClick(driver, takeActionBtn);
		Elements.doSendKeys(driver, remarkTextFld, CommonUtils.getProperties().getProperty("remark"));
		DropdownUtil.selectByValue(driver, statusDropdwn, CommonUtils.getProperties().getProperty("status"));
		Elements.doSendKeys(driver, initialAmount, CommonUtils.getProperties().getProperty("initialAmount"));
		Elements.doClick(driver, updateBtn);
		
	}
	
	public boolean isOnAdminPage() {
		String expTitle = "e-Banking System | Admin";
		return BrowserUtils.verifyTitle(driver, expTitle);
	}
}
