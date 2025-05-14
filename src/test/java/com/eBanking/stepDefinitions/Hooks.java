package com.eBanking.stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.BrowserFactory;
import com.eBanking.ui.engine.PropertiesManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(Hooks.class);

	
	
	@BeforeAll
	public static void beforeAll() {
		logger.info("initilizing Engine....");
		PropertiesManager.loadConfigProperties();
	}

	@Before
	public static void initDriver(Scenario scenario) {
		
		new BrowserFactory().theTargetBrowserisOpen();

	}

	@After
	public void tearDown() {
//	if (driver != null) {
//			driver.quit();
//			driver = null;
//}

	//	ReportManager.flush();
	}

	
}
