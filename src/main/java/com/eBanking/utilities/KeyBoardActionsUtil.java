package com.eBanking.utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyBoardActionsUtil {
	
	//Send Keys to an Element
	
	 private static final Logger logger = LoggerFactory.getLogger(KeyBoardActionsUtil.class);

	   

	    public static void sendKeys(WebDriver driver, By locator, String text) {
	        try {
	            WebElement element = driver.findElement(locator);
	            element.sendKeys(text);
	            logger.info("Sent keys '{}' to element: {}", text, locator);
	        } catch (Exception e) {
	            logger.error("Failed to send keys '{}' to element {}. Exception: {}", text, locator, e.getMessage());
	        }
	    }
	
	//Press Enter Key
	
	public static void pressEnter(WebDriver driver, By locator) {
	    try {
	        WebElement element = driver.findElement(locator);
	        element.sendKeys(Keys.ENTER);
	        logger.info("Pressed Enter on element: {}", locator);
	    } catch (Exception e) {
	        logger.error("Failed to press Enter on element {}. Exception: {}", locator, e.getMessage());
	    }
	}
	// Press Tab Key
	
	public static void pressTab(WebDriver driver, By locator) {
	    try {
	        WebElement element = driver.findElement(locator);
	        element.sendKeys(Keys.TAB);
	        logger.info("Pressed Tab on element: {}", locator);
	    } catch (Exception e) {
	        logger.error("Failed to press Tab on element {}. Exception: {}", locator, e.getMessage());
	    }
	}
	// Press and Release Shift Key
	
	public static void pressShift(WebDriver driver) {
	    try {
	        Actions actions = new Actions(driver);
	        actions.keyDown(Keys.SHIFT).keyUp(Keys.SHIFT).perform();
	        logger.info("Pressed and released Shift key.");
	    } catch (Exception e) {
	        logger.error("Failed to press Shift key. Exception: {}", e.getMessage());
	    }
	}
	// Copy and Paste Text (Ctrl + C and Ctrl + V)
	
	public static void copyPaste(WebDriver driver) {
	    try {
	        Actions actions = new Actions(driver);
	        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform(); // Copy
	        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform(); // Paste
	        logger.info("Performed Copy-Paste action.");
	    } catch (Exception e) {
	        logger.error("Failed to perform Copy-Paste. Exception: {}", e.getMessage());
	    }
	}
	// Press Backspace to Delete Text
	
	
	public static void pressBackspace(WebDriver driver, By locator) {
	    try {
	        WebElement element = driver.findElement(locator);
	        element.sendKeys(Keys.BACK_SPACE);
	        logger.info("Pressed Backspace on element: {}", locator);
	    } catch (Exception e) {
	        logger.error("Failed to press Backspace on element {}. Exception: {}", locator, e.getMessage());
	    }
	}
	// Perform Keyboard Shortcut (e.g., Ctrl + A)
	
	public static void performKeyboardShortcut(WebDriver driver, Keys key1, Keys key2) {
	    try {
	        Actions actions = new Actions(driver);
	        actions.keyDown(key1).sendKeys(key2).keyUp(key1).perform();
	        logger.info("Performed keyboard shortcut: {} + {}", key1, key2);
	    } catch (Exception e) {
	        logger.error("Failed to perform keyboard shortcut {} + {}. Exception: {}", key1, key2, e.getMessage());
	    }
	}
	// Press ESC Key
	
	public static void pressEscape(WebDriver driver) {
	    try {
	        Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.ESCAPE).perform();
	        logger.info("Pressed Escape key.");
	    } catch (Exception e) {
	        logger.error("Failed to press Escape key. Exception: {}", e.getMessage());
	    }
	}
	// Type Using Robot Class (Alternative)
	

	

	public static void typeUsingRobot(String text) {
	    try {
	        Robot robot = new Robot();
	        for (char c : text.toCharArray()) {
	            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
	            robot.keyPress(keyCode);
	            robot.keyRelease(keyCode);
	        }
	        logger.info("Typed '{}' using Robot class.", text);
	    } catch (Exception e) {
	        logger.error("Failed to type using Robot class. Exception: {}", e.getMessage());
	    }
	}
	

}
