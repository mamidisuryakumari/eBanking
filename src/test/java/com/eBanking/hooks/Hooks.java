package com.eBanking.hooks;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.eBanking.ui.engine.BrowserFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	static WebDriver driver;

	@Before
	public static void initDriver(Scenario scenario) {
		driver = BrowserFactory.initializeDriver();
		// Retrieve tags from the scenario and pass to createTest
		//String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
		

	}

	@After
	public void tearDown() {
//	if (driver != null) {
//			driver.quit();
//			driver = null;
//}

	//	ReportManager.flush();
	}

	@AfterStep
	public void actionAfterEachStep(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);

			// Attaching screenshot to the Cucumber report
			scenario.attach(screenshot, "image/png", scenario.getName());

			// Converting screenshot to Base64 for ExtentReports
			String base64Screenshot = java.util.Base64.getEncoder().encodeToString(screenshot);

			// Logging the failure in ExtentReports with the screenshot
			// ReportManager.getTest().fail("").addScreenCaptureFromBase64String(java.util.Base64.getEncoder().encodeToString(screenshot),
			// "Failed Step Screenshot");
			
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
