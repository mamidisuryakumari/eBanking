package com.eBanking.utilities;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserUtils {

	private static Logger log = LoggerFactory.getLogger(BrowserUtils.class);

	public static String getTitle(WebDriver driver) {
		try {
			String title = driver.getTitle();
			log.info("Page title is: " + title);
			return title;
		} catch (Exception e) {
			log.error("Failed to get page title", e);
			return null;
		}
	}

	public static boolean verifyTitle(WebDriver driver, String expectedTitle) {
	    // Wait for the title to appear
	    boolean titleAppears = WaitUtils.waitUntilTitle(driver, expectedTitle, Constants.maxWaitTime);

	    // Verify if the title matches
	    if (titleAppears) {
	        String actualTitle = driver.getTitle();
	        boolean match = expectedTitle.equals(actualTitle);
	        log.info("Expected title: " + expectedTitle + " | Actual title: " + actualTitle + " | Match: " + match);
	        return match;
	    } else {
	        log.error("Title did not appear within the specified time: " + expectedTitle);
	        return false;
	    }
	}

}
