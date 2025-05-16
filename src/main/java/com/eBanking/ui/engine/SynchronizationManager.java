package com.eBanking.ui.engine;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

public class SynchronizationManager {
	@Getter
	private WebDriver driver;
	@Getter
	private WebDriverWait wait;

	private static final Logger logger = LoggerFactory.getLogger(SynchronizationManager.class);

	public SynchronizationManager(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Constants.maxWaitTime);
	}

	public WebElement waitForTheElementToBeVisible(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			logger.error("Element not visible: " + locator, e);
			throw new RuntimeException("Element not visible: " + locator, e);
		}
	}

	public WebElement moveToElement(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			new Actions(driver).moveToElement(element).perform();
			logger.info("Moved to element: {}", locator);
			return element;
		} catch (Exception e) {
			logger.error("Failed to moved to element: {}", locator, e);
			throw new RuntimeException("Exception occured while moving to the element: " + locator, e);
		}
	}

	public WebElement waitForTheElementIsPresent(By locator) {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			logger.error("Element not visible: " + locator, e);
			throw new RuntimeException("Element not present in DOM: " + locator, e);
		}
	}

	public Boolean waitForTheElementNtToBeVisible(By locator) {
		try {
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			logger.error("Element is visible: " + locator, e);
			throw new RuntimeException("Element is visible: " + locator, e);
		}
	}

	public Boolean waitForTheElementToBeSelected(By locator) {
		try {
			boolean isSelected = wait.until(ExpectedConditions.elementToBeSelected(locator));
			logger.info("Element is selected: " + locator.toString());
			return isSelected;
		} catch (Exception e) {
			logger.error("Timeout waiting for element to be selected: " + locator.toString(), e);
			throw new RuntimeException("Element not selected within timeout: " + locator, e);
		}

	}

	public WebElement waitForTheElementToBeClickable(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			logger.info("Element {} is clickable: " + locator);
			return element;
		} catch (Exception e) {
			logger.error("Element {} is not clickable with in the excepted time" + locator, e);
			throw new RuntimeException("Exception occured while waiting for element to be clickable: " + locator, e);
		}

	}

	public Alert waitForAlert() {
		try {
			return wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			logger.error("Alert not present", e);
			throw new RuntimeException("Alert not present", e);
		}
	}
	
	

	public void scrollToView(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		} catch (Exception e) {
			logger.error("Failed to scroll to element: {}", locator, e);
			throw new RuntimeException("Unable to scroll to element:  + locator ,e");
		}
	}
}
