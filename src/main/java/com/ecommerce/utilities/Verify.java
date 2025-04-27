package com.ecommerce.utilities;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Verify {
	private static boolean bStatus;
	private static final Logger logger = LoggerFactory.getLogger(Verify.class);

	// Element visible
	public static boolean verifyElementIsVisible(WebDriver driver, By locator) {
		try {
			bStatus = driver.findElement(locator).isDisplayed();
			if(bStatus) {
			logger.info("Element {} is visible",locator);
			return true;
			}else {
				logger.warn("Element {} is not visible",locator);
				return false;
			}
		} catch (Exception e) {
			logger.warn("Element {} is not visible.Exception: {}",locator, e.getMessage());
			return false;
		}
		
	}

	//Element selected
	public static boolean verifyElementIsSelected(WebDriver driver, By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element.isSelected();
		} catch (NoSuchElementException e) {
			System.err.println("Element "+locator+" is not selected");
		} catch (Exception e) {
			System.err.println("An error occurred while checking selecting : " + e.getMessage());
		}
		return false;
	}

	//Element enabled
	public static boolean verifyElementIsEnabled(WebDriver driver, By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element.isEnabled();
		} catch (NoSuchElementException e) {
			System.err.println("Element "+locator+"is not enabled: " + locator);
		} catch (Exception e) {
			System.err.println("An error occurred while checking enabling : " + e.getMessage());
		}
		return false;
	}
	
}
