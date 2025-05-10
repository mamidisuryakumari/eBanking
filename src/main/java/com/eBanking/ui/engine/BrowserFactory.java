package com.eBanking.ui.engine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver driver;
	private static final Logger log = LoggerFactory.getLogger(BrowserFactory.class);
	
	public WebDriver getDriver() {
		if(driver == null) {
			initializeDriver();
		}
		return driver;
	}

	public static WebDriver initializeDriver()  {
		String browserName = PropertiesManager.getProperty("browser.name");
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito","--start-maximized");
			driver = new ChromeDriver(chromeOptions);
			driver.get(PropertiesManager.getProperty("base.url"));
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--incognito").addArguments("--maximized");
			driver = new FirefoxDriver(firefoxOptions);
			break;
		
		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--incognito").addArguments("--maximized");
			driver = new EdgeDriver(edgeOptions);
			break;
		
		default:
			throw new IllegalArgumentException("Browser not supported " + browserName);
		}
		if(driver == null) {
			throw new IllegalStateException("WebDriver initialization failed");
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			log.info("Browser is closed");
		}
	}
	
	public static void main(String args[]) {
		initializeDriver();
	}

}
