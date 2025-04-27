package com.ecommerce.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Calendar {
public static Boolean bstatus;
	

	public static boolean selectCurrentDate(WebDriver driver, By calLocator, By dateLocator) {

		if (WaitUtils.waitForElementIsVisible(driver, calLocator, Constants.maxWaitTime)) {
			Elements.doClick(driver, calLocator);

			if (WaitUtils.waitForElementIsVisible(driver, dateLocator, Constants.maxWaitTime)) {

				Elements.doClick(driver, dateLocator);
				return true;

			}
		} else {
			System.err.println("Calendar widget not found");
			return false;
		}
		return false;

	}

	public static boolean selectFutureDate(WebDriver driver, By calLocator, By calHeader, By nextLocator,
			By dateLocator) {

		WaitUtils.waitForElementIsVisible(driver, calLocator, Constants.maxWaitTime);
		Elements.doClick(driver, calLocator);
		String currentMonthYear = Elements.getText(driver, calHeader);
		if (currentMonthYear.equals(CommonUtils.getFutureMonthYear())) {

			Elements.doClick(driver, dateLocator);
			return true;
		} else {
			Elements.doClick(driver, nextLocator);
			Elements.doClick(driver, dateLocator);
			return true;
		}
		
	}
	
	public static String getCalHeaderText(WebDriver driver, By headerLocator) {
		String headerText = driver.findElement(headerLocator).getText();
		return headerText;
	}

}
