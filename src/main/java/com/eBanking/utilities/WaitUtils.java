package com.eBanking.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitUtils {

	private static final Logger logger = LoggerFactory.getLogger(WaitUtils.class);
	
	public static boolean waitUntilTitle(WebDriver driver, String expectedTitle, Duration timeout) {
	    try {
	    	WebDriverWait wait = new WebDriverWait(driver, timeout);
	        return wait.until(ExpectedConditions.titleIs(expectedTitle));
	    } catch (Exception e) {
	    	logger.error("Timeout waiting for title: " + expectedTitle, e);
	        return false;
	    }
	}

	// Wait for Element Visible
	public static boolean waitForElementIsVisible(WebDriver driver, By locator, Duration timeout) {
		if (driver == null || locator == null || timeout == null) {
			logger.error("driver, locator, or timeout is null");
			return false;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			logger.info("Element is visible with in the time period" + locator);
			return true;
		} catch (TimeoutException e) {
			logger.error("Element  is not visible with in the time period" + locator, e);
			return false;
		} catch (Exception e) {
			logger.error("An unexpected error occurred while waiting for element visibility", e);
			throw e;
		}
	}

	// wait for Element presence
	public static boolean waitForElementIsPresence(WebDriver driver, By locator, Duration timeout) {
		if (driver == null || locator == null || timeout == null) {
			logger.error("driver, locator, or timeout is null");
			return false;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			logger.info("Element is present with in the time period" + locator);
			return true;
		} catch (TimeoutException e) {
			logger.error("Element  is not present with in the time period" + locator, e);
			return false;
		} catch (Exception e) {
			logger.error("An unexpected error occurred while waiting for element present", e);
			throw e;
		}
	}

	// wait for element to be clickable
	public static boolean waitForElementToBeClickable(WebDriver driver, By locator, Duration timeout) {
		if (driver == null || locator == null || timeout == null) {
			logger.error("Driver,locator,timeout is null");
			return false;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			logger.info("Element is clickable with in the time period" + locator);
			return true;
		} catch (TimeoutException e) {
			logger.error("Element is not clickable with in the time period" + e);
			return false;
		} catch (Exception e) {
			logger.error("An unexpected error occured while clicking the element" + e);
			throw e;
		}
	}

	// wait for element to be selected
	public static boolean waitForElementToBeSelected(WebDriver driver, By locator, Duration timeout) {
		if (driver == null || locator == null || timeout == null) {
			logger.error("Driver,locator,timeout is null");
			return false;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeSelected(locator));
			logger.info("Element is selected with in the time period" + locator);
			return true;
		} catch (TimeoutException e) {
			logger.error(" Element is not selected with in the time period" + e);
			return false;
		} catch (Exception e) {
			logger.error("An unexpected error occured while selecting the element" + e);
			throw e;
		}
	}

	// Wait for alert
	public static boolean waitForAlertIsPresent(WebDriver driver,Duration timeout) {
		if (driver == null  || timeout == null) {
			logger.error("Driver,locator,timeout is null");
			return false;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.alertIsPresent());
			logger.info("Alert is present" );
			return true;
		} catch (TimeoutException e) {
			logger.error("Alert is not present with in the time period" + e);
			return false;
		} catch (Exception e) {
			logger.error("An unexpected error occured while present alert" + e);
			throw e;
		}
		
	}

	

}