package com.eBanking.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.ui.engine.Bot;
import com.eBanking.ui.engine.BrowserFactory;
import com.eBanking.ui.engine.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private TestContext context;
	public Hooks(TestContext context) {
		this.context = context;
	}
	
	private final Logger logger = LoggerFactory.getLogger(Hooks.class);

	@Before
	public  void initDriver(Scenario scenario) {
		
		BrowserFactory browserFactory = new BrowserFactory();
		
		WebDriver driver = browserFactory.theTargetBrowserisOpen();
		Bot bot = browserFactory.getBot();
		
		context.setDriver(driver);
		context.setBot(bot);

	}

	@After
	public void tearDown() {
		WebDriver driver = context.getDriver();
//	if (driver != null) {
//			driver.quit();
//		
//}

	//	ReportManager.flush();
	}

	
}
