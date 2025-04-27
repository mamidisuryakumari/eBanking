package com.ecommerce.utilities;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Elements {
	private static boolean bStatus;
	private static Logger logger = LoggerFactory.getLogger(Elements.class);

	// getElement
	public static WebElement getWebElement(WebDriver driver, By locator) {
		if (driver == null || locator == null) {
			logger.error("Driver or locator is null");
			return null;
		}
		try {
			WebElement element = driver.findElement(locator);
			return element;
		} catch (NoSuchElementException e) {
			logger.error("Element is not found" + e);
		} catch (Exception e) {
			logger.error("An unexpected error occured while locating element" + e);
			throw e;
		}
		return null;
	}

	// get text
	public static String getText(WebDriver driver, By locator) {
		if (driver == null || locator == null) {
			logger.error("Driver or locator is null");
			return null;
		}
		try {
			WebElement element = getWebElement(driver, locator);
			if (element != null) {
				return element.getText();
			} else {
				logger.error("Element is not found" + locator);
				return null;
			}
		} catch (Exception e) {
			logger.error("An unexpected error occured while getting text from the element" + e);
			throw e;
		}

	}
	
	//get attribute value
	public static String getAttributeValue(WebDriver driver, By locator,String value) {
		if (driver == null || locator == null || value == null) {
			logger.error("Driver, locator or value is null");
			return null;
		}
		try {
			WebElement element = getWebElement(driver, locator);
			if (element != null) {
				return element.getAttribute(value);
			} else {
				logger.error("Element is not found" + locator);
				return null;
			}
		} catch (Exception e) {
			logger.error("An unexpected error occured while getting attribute value from the element" + e);
			throw e;
		}

	}

	

	// Do click
	public static boolean doClick(WebDriver driver, By locator) {
		if (driver == null || locator == null) {
			logger.error("Driver or locator is null");
			return false;
		}
		try {
			bStatus = WaitUtils.waitForElementToBeClickable(driver, locator, Constants.maxWaitTime);
			if (bStatus) {
				getWebElement(driver, locator).click();
				logger.info("Successfully clicked to the element" + locator);
				return true;
			} else {
				logger.error("Element was not available for click" + locator);
				return false;
			}
		} catch (Exception e) {
			logger.error("Exception occurred while trying to click the element" + locator, e);
			throw e;
		}
	}

	// Do JSclick
	public static boolean doJsClick(WebDriver driver, By locator) {
		if (driver == null || locator == null) {
			logger.error("Driver or locator is null");
			return false;
		}
		try {
			bStatus = WaitUtils.waitForElementToBeClickable(driver, locator, Constants.maxWaitTime);
			if (bStatus) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
               executor.executeScript("arguments[0].click();" , getWebElement(driver, locator));
				logger.info("Successfully clicked to the element " + locator);
				return true;
			} else {
				logger.error("Element  was not available for click" + locator);
				return false;
			}
		} catch (Exception e) {
			logger.error("Exception occurred while trying to click the element" + locator, e);
			throw e;
		}
	}

	// Do sendKeys
	public static boolean doSendKeys(WebDriver driver, By locator, String inputText) {
		if (driver == null || locator == null || inputText == null) {
			logger.error("Driver, locator or inputtext  is null");
			return false;
		}
		try {
			boolean bStatus = WaitUtils.waitForElementIsVisible(driver, locator, Constants.maxWaitTime);
			if (bStatus) {
				WebElement element = getWebElement(driver, locator);
				element.clear();
				element.sendKeys(inputText);
				logger.info("Successfully entered text into the element", inputText, locator);
				return true;
			} else {
				logger.error("Element  was not visible for entering text ", locator, inputText);
				return false;
			}
		} catch (Exception e) {
			logger.error("Exception occurred while entering text  into the element", inputText, locator,e);
			throw e;
		}
	}

	// Do JsSendKeys
	public static boolean doJsSendKeys(WebDriver driver, By locator, String inputText) {
		if (driver == null || locator == null || inputText == null) {
			logger.error("Driver, locator or inputTest is null");
			return false;
		}
		try {
			bStatus = WaitUtils.waitForElementIsVisible(driver, locator, Constants.maxWaitTime);
			if (bStatus) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].value = '';", getWebElement(driver, locator)); // clear text
				executor.executeScript("arguments[0].value=arguments[1];" , getWebElement(driver, locator), inputText);
				logger.info("Successfully entered text into the element ", inputText, locator);
				return true;
			} else {
				logger.error("Element was not visible for entering text ", locator, inputText);
				return false;
			}
		} catch (Exception e) {
			logger.error("Exception occurred while entering text  into the element", inputText, locator,e);
			throw e;
		}
	}
	// check box selected

	public static boolean selectCheckbox(WebDriver driver, By locator) {
		if (driver == null || locator == null) {
			logger.error("Driver or locator is null");
			return false;
		}
		try {
			bStatus = WaitUtils.waitForElementToBeSelected(driver, locator, Constants.maxWaitTime);
			if (!bStatus) {
				doClick(driver, locator);
				logger.info("Checkbox  was successfully selected", locator);
				return true;
			} else {
				logger.error("Failed to click the checkbox", locator);
				return false;
			}
		} catch (Exception e) {
		logger.error("Unexcepted error occured while selecting the checkbox" , e);
		throw e;
		}
	}
	// check box unselected

	public static boolean unSelectCheckbox(WebDriver driver, By locator) {
		if (driver == null || locator == null) {
			logger.error("Driver or locator is null");
			return false;
		}
		try {
			bStatus = WaitUtils.waitForElementToBeSelected(driver, locator, Constants.maxWaitTime);
			if (bStatus) {
				doClick(driver, locator);
				logger.info("Checkbox  was successfully unselected", locator);
				return true;
			} else {
				logger.error("Failed to unselect the checkbox", locator);
				return false;
			}
		} catch (Exception e) {
		logger.error("Unexcepted error occured while unselecting the checkbox" , e);
		throw e;
		}

	}

	public static boolean doSendKeysWithTab(WebDriver driver, By locator, String inputText) {
		if (driver == null || locator == null) {
			logger.error("Driver or locator is null");
			return false;
		}

		try {
			boolean isVisible = WaitUtils.waitForElementIsVisible(driver, locator, Constants.maxWaitTime);
			if (isVisible) {
				WebElement element = getWebElement(driver, locator);
				element.sendKeys(inputText, Keys.TAB); 
				logger.info("Successfully sent keys  with Tab to the element" + inputText, locator);
				return true;
			} else {
				logger.error("Element {} was not visible within the maximum wait time." +locator);
				return false;
			}
		} catch (Exception e) {
			logger.error("Exception occurred while sending keys  with Tab to the element" + inputText, locator,
					e);
		throw e;
		}
	}

}
