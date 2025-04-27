package com.eBanking.utilities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Window {

	private static Logger logger = LoggerFactory.getLogger(Window.class);

	public static void switchToChildWindow(WebDriver driver) {
		if (driver == null) {
			logger.error("Driver is null");
			return;
		}

		try {
			String parentWindow = driver.getWindowHandle();
			logger.info("Parent window ID: " + parentWindow);

			Set<String> windowHandles = driver.getWindowHandles();
			for (String windowHandle : windowHandles) {
				if (!windowHandle.equals(parentWindow)) {
					driver.switchTo().window(windowHandle);
					logger.info("Switched to child window: " + windowHandle);
					break;
				}
			}
		} catch (Exception e) {
			logger.error("An error occurred while switching to the child window", e);
			throw e;
		}
	}
	
	
	

}
