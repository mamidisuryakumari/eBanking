package com.eBanking.ui.engine;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.utilities.Constants;
import com.eBanking.utilities.WaitUtils;

import lombok.Getter;

public class Bot {
	
	private static final Logger logger = LoggerFactory.getLogger(Bot.class);
	
	@Getter
	protected WebDriver driver;
	
	@Getter
	protected SynchronizationManager wait;
	
	

	
	public Bot() {
		this.driver = BrowserFactory.getDriver();
		this.wait = new SynchronizationManager(driver);
		}


	public Bot click(By locator) {
		try {
		wait.scrollToView(locator);	
		WebElement element = wait.waitForTheElementToBeClickable(locator);
		new Actions(driver).moveToElement(element).perform();
		element.click();
		logger.info("Clicked on the element : {} ", locator);
		} catch (Exception e) {
			logger.error("Click failed for : {}" , locator);
			throw new RuntimeException("An exception occured while clicking on the locator " + e);
		}
		return this;
	}
	
	public Bot enterText(By locator,String inputText) {
		try {
			wait.scrollToView(locator);	
			WebElement element = wait.waitForTheElementToBeVisible(locator);
			new Actions(driver).moveToElement(element).perform();
			element.click();
			element.clear();
			element.sendKeys(inputText);
			logger.info("Entered text '{}' into element: {} ", inputText, locator);
			} catch (Exception e) {
				logger.error("Failed to enter text '{}' in element: {}" ,inputText, locator);
				throw new RuntimeException("An exception occured while entering text in element: " + locator, e);
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


	}
	

