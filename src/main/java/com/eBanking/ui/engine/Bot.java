package com.eBanking.ui.engine;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

public class Bot {

	private final Logger logger = LoggerFactory.getLogger(Bot.class);

	@Getter
	protected WebDriver driver;

	@Getter
	protected SynchronizationManager wait;

	public Bot(WebDriver driver) {
		this.driver = driver;
		this.wait = new SynchronizationManager(driver);
	}

	

	public Bot click(By locator) {
		try {
			wait.waitForOverLayToDisapper();
			wait.scrollToView(locator);
			WebElement element = wait.waitForTheElementToBeClickable(locator);
			new Actions(driver).moveToElement(element).perform();
			element.click();
			logger.info("Clicked on the element : {} ", locator);
		} catch (Exception e) {
			logger.error("Click failed for : {}", locator);
			throw new RuntimeException("An exception occured while clicking on the locator " + e);
		}
		return this;
	}

	public Bot enterText(By locator, String inputText) {
		try {
			wait.scrollToView(locator);
			WebElement element = wait.waitForTheElementToBeVisible(locator);
			new Actions(driver).moveToElement(element).perform();
			element.click();
			element.clear();
			element.sendKeys(inputText);
			logger.info("Entered text '{}' into element: {} ", inputText, locator);
		} catch (Exception e) {
			logger.error("Failed to enter text '{}' in element: {}", inputText, locator,e);
			throw new RuntimeException("An exception occurred while entering text in element: " + locator, e);
		}
		return this;
	}
	
	public Bot fileUpload(By locatror, String relativePath) {
		String filePath = System.getProperty("user.dir") + File.separator + (relativePath);
		try {
			wait.scrollToView(locatror);
			WebElement element = wait.waitForTheElementToBeVisible(locatror);
			new Actions(driver).moveToElement(element).perform();
			element.sendKeys(filePath);
			 logger.info("Successfully uploaded file: '{}'", filePath);
		} catch (Exception e) {
			logger.error("Exception occurred during file upload for: '{}'", filePath, e);
	        throw new RuntimeException("File upload failed for: " + filePath, e);
		}
		return this;
	}

	public String getTitle() {
		try {
			String title = driver.getTitle();
			logger.info("Page title is: " + title);
			return title;
		} catch (Exception e) {
			logger.error("Failed to get page title", e);
			return null;
		}
	}

	public String getAlertMessage() {
		try {
			wait.waitForAlert();
			String alertMessage = driver.switchTo().alert().getText();
			logger.info("Alert message captured: {}", alertMessage);
			return alertMessage;
		} catch (Exception e) {
			logger.error("Failed to retrieve alert message", e);
			throw new RuntimeException("An exception occurred while fetching the alert message", e);
		}
	}
	
	public String getAttributValue(By locator)
	{
		WebElement element =  driver.findElement(locator);
		String capturedValue = element.getDomAttribute("value");
		return capturedValue;
		
	}
	
	public void acceptAlert() {
		try {
			wait.waitForAlert();
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			logger.info("Accepted alert with message: {}", alertText);
		} catch (NoAlertPresentException e) {
			logger.warn("No alert present to accept", e);
		} catch (Exception e) {
			logger.error("Failed to accept the alert", e);
			throw new RuntimeException("An exception occurred while accepting the alert", e);
		}
	}

	public void dismissAlert() {
		try {
			wait.waitForAlert();
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.dismiss();
			logger.info("Dismissed alert with message: {}", alertText);
		} catch (NoAlertPresentException e) {
			logger.warn("No alert present to dismiss", e);
		} catch (Exception e) {
			logger.error("Failed to dismiss the alert", e);
			throw new RuntimeException("An exception occurred while dismissing the alert", e);
		}
	}

	// get text

	public String getText(By locator) {
		try {
			WebElement element = wait.waitForTheElementToBeVisible(locator);
			String text = element.getText();
			logger.info("Text retrieved from element {}: {}", locator, text);
			return text;
		} catch (Exception e) {
			logger.error("Failed to retrieve text from element: {}", locator, e);
			throw new RuntimeException("An exception occurred while getting text from element: " + locator, e);
		}
	}

//select by value
	public Bot selectByValue(By locator, String value) {
		try {
			WebElement dropdown = wait.waitForTheElementToBeVisible(locator);
			Select select = new Select(dropdown);
			select.selectByValue(value);
			logger.info("Selected value '{}' from dropdown: {}", value, locator);
		} catch (Exception e) {
			logger.error("Failed to select value '{}' from dropdown: {}", value, locator, e);
			throw new RuntimeException("An exception occurred while selecting value from dropdown: " + locator, e);
		}
		return this;
	}

//select by index
	public Bot selectByIndex(By locator, int index) {
		try {
			WebElement dropdown = wait.waitForTheElementToBeVisible(locator);
			Select select = new Select(dropdown);
			select.selectByIndex(index);
			logger.info("Selected index '{}' from dropdown: {}", index, locator);
		} catch (Exception e) {
			logger.error("Failed to select index '{}' from dropdown: {}", index, locator, e);
			throw new RuntimeException("An exception occurred while selecting index from dropdown: " + locator, e);
		}
		return this;
	}

//select by visible text
	public Bot selectByVisibleText(By locator, String visibleText) {
		try {
			WebElement dropdown = wait.waitForTheElementToBeVisible(locator);
			Select select = new Select(dropdown);
			select.selectByVisibleText(visibleText);
			logger.info("Selected visible text '{}' from dropdown: {}", visibleText, locator);
		} catch (Exception e) {
			logger.error("Failed to select visible text '{}' from dropdown: {}", visibleText, locator, e);
			throw new RuntimeException("An exception occurred while selecting visible text from dropdown: " + locator,
					e);
		}
		return this;
	}

	// js click
	public Bot jsClick(By locator) {
		try {
			wait.scrollToView(locator);
			WebElement element = wait.waitForTheElementToBeVisible(locator);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].click();", element);
			logger.info("Performed JavaScript click on element: {}", locator);
		} catch (Exception e) {
			logger.error("JavaScript click failed for element: {}", locator, e);
			throw new RuntimeException("An exception occurred while performing JS click on: " + locator, e);
		}
		return this;
	}

	public Bot jsSendKeys(By locator, String inputText) {
		try {
			WebElement element = wait.waitForTheElementToBeVisible(locator);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].value = arguments[1];", element, inputText);
			logger.info("Set value '{}' using JavaScript in element: {}", inputText, locator);
		} catch (Exception e) {
			logger.error("Failed to set value '{}' using JavaScript in element: {}", inputText, locator, e);
			throw new RuntimeException("An exception occurred while sending keys via JS to: " + locator, e);
		}
		return this;
	}

	public Bot checkCheckbox(By locator) {
		try {
			wait.scrollToView(locator);
			WebElement checkbox = wait.waitForTheElementToBeClickable(locator);
			if (!checkbox.isSelected()) {
				checkbox.click();
				logger.info("Checkbox selected: {}", locator);
			} else {
				logger.info("Checkbox already selected: {}", locator);
			}
		} catch (Exception e) {
			logger.error("Failed to select checkbox: {}", locator, e);
			throw new RuntimeException("An exception occurred while selecting checkbox: " + locator, e);
		}
		return this;
	}

	public Bot uncheckCheckbox(By locator) {
		try {
			wait.scrollToView(locator);
			WebElement checkbox = wait.waitForTheElementToBeClickable(locator);
			if (checkbox.isSelected()) {
				checkbox.click();
				logger.info("Checkbox unselected: {}", locator);
			} else {
				logger.info("Checkbox already unselected: {}", locator);
			}
		} catch (Exception e) {
			logger.error("Failed to unselect checkbox: {}", locator, e);
			throw new RuntimeException("An exception occurred while unchecking checkbox: " + locator, e);
		}
		return this;
	}
	
	public Bot pressEnterUsingActions(By locator) {
	    try {
	        WebElement element = wait.waitForTheElementToBeVisible(locator);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).sendKeys(Keys.ENTER).build().perform();
	        logger.info("Pressed ENTER using Actions on element: {}", locator);
	    } catch (Exception e) {
	        logger.error("Failed to press ENTER using Actions on element: {}", locator, e);
	        throw new RuntimeException("An exception occurred while pressing ENTER with Actions on: " + locator, e);
	    }
	    return this;
	}
	
	public Bot searchAccount(By locator, String text) {
	    try {
	        WebElement element = wait.waitForTheElementToBeVisible(locator);
	        element.clear();
	        element.sendKeys(text + Keys.ENTER);
	        logger.info("Entered text '{}' and pressed ENTER on element: {}", text, locator);
	    } catch (Exception e) {
	        logger.error("Failed to enter text and press ENTER on element: {}", locator, e);
	        throw new RuntimeException("An error occurred while entering text and pressing ENTER on: " + locator, e);
	    }
	    return this;
	}



	public int getRandomNumber(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	


}
