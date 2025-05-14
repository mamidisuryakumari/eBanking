package com.eBanking.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertUtil {
	private static boolean bStatus;
	
	//accept alert
	public static boolean acceptAlert(WebDriver driver) {
		bStatus=WaitUtils.waitForAlertIsPresent(driver, Constants.maxWaitTime);
		if(bStatus) {
			driver.switchTo().alert().accept();
			return true;
			
		}else {
			System.out.println("Alert was not present");
		}
		return false;
	}
//dismiss alert
	public static boolean dismissAlert(WebDriver driver,By locator) {
		bStatus=WaitUtils.waitForAlertIsPresent(driver, Constants.maxWaitTime);
		if(bStatus) {
			driver.switchTo().alert().dismiss();
			return true;
			
		}else {
			System.out.println("Alert"+locator+" was not present");
		}
		return false;
	}
	
	
	public static boolean isAlertPresent(WebDriver driver) {
	    try {
	        driver.switchTo().alert();
	        System.out.println("Alert is present");
	        return true;
	    } catch (NoAlertPresentException e) {
	    	System.out.println("Alert is not present");
	        return false;
	        
	    }
	}
	


//get alert message

}