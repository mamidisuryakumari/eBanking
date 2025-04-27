package com.eBanking.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {

	public static String takeScreenshot(WebDriver driver, String screenshotName) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance is null");
		}

		String timestamp = CommonUtils.getCurrentDateTime();
		String destination = "./screenshots/" + screenshotName + "_" + timestamp + ".png";
		try {
			File screenshotDir = new File("./screenshots/");
			if (!screenshotDir.exists()) {
				screenshotDir.mkdirs();
			}

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}
}
