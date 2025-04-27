package com.eBanking.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DropdownUtil {
	private static boolean bstatus;
	private static Logger logger = LoggerFactory.getLogger(DropdownUtil.class);

	// Select By value
	public static boolean selectByValue(WebDriver driver, By locator, String value) {
		if (driver == null || locator == null || value == null) {
			logger.error("Driver, locator or value is null");
			return false;
		}
		try {
			bstatus = WaitUtils.waitForElementIsVisible(driver, locator, Constants.maxWaitTime);
			if (bstatus) {
				Select select = new Select(Elements.getWebElement(driver, locator));
				select.selectByValue(value);
				logger.info("Successfully selected value from dropdown" + locator , value );
				return true;
			} else {
				logger.error("Dropdown was not present" + locator);
				return false;
			}
		} catch (Exception e) {
			logger.error("An unexpected error occured while selecting the value from dropdown" + e);
			throw e;
		}

	}

	// Select By visibleText
	public static boolean selectByVisibleText(WebDriver driver, By locator, String text) {
		if (driver == null || locator == null || text == null) {
			logger.error("Driver, locator or text is null");
			return false;
		}
		try {
			bstatus = WaitUtils.waitForElementIsVisible(driver, locator, Constants.maxWaitTime);
			if (bstatus) {
				Select select = new Select(Elements.getWebElement(driver, locator));
				select.selectByVisibleText(text);
				logger.info("Successfully selected text from dropdown" + locator , text );
				return true;
			} else {
				logger.error("Dropdown was not present" + locator);
				return false;
			}
		} catch (Exception e) {
			logger.error("An unexpected error occured while selecting the text from dropdown" + e);
			throw e;
		}

	}

	// Select By index
	public static boolean selectByIndex(WebDriver driver, By locator, int index) {
		if (driver == null || locator == null ) {
			logger.error("Driver or locator is null");
			return false;
		}
		try {
			bstatus = WaitUtils.waitForElementIsVisible(driver, locator, Constants.maxWaitTime);
			if (bstatus) {
				Select select = new Select(Elements.getWebElement(driver, locator));
				select.selectByIndex(index);
				logger.info("Successfully selected index from dropdown" + locator , index );
				return true;
			} else {
				logger.error("Dropdown was not visible for " + locator);
				return false;
			}
		} catch (Exception e) {
			logger.error("An unexpected error occured while selecting the index from dropdown" + e);
			throw e;
		}

	}
}
