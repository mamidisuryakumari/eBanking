package com.eBanking.driverManager;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eBanking.utilities.CommonUtils;

public class DriverManager {
	
	public static WebDriver driver;
	private static final Logger log = LoggerFactory.getLogger(DriverManager.class);
	
//	private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
	  
	  
    public static WebDriver initDriver() throws IOException {
        String browser =  CommonUtils.getProperties().getProperty("browserName").toLowerCase();
        String os = System.getProperty("os.name").toLowerCase();
       String url = CommonUtils.getProperties().getProperty("baseUrl");

        // OS check with if-else condition
        if (os.contains("windows")) {
            driver = initDriverForWindows(browser);
        //    driverThreadLocal.set(new ChromeDriver());
        } else if (os.contains("mac")) {
            driver = initDriverForMac(browser);
        } else if (os.contains("linux")) {
            driver = initDriverForLinux(browser);
        } else {
            throw new IllegalArgumentException("Operating system not supported: " + os);
        }

        if (driver != null) {
            driver.manage().window().maximize();
            driver.get(url);
        }

        return driver;
    }

    private static WebDriver initDriverForWindows(String browser) {
        // Use switch-case inside each OS block
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
           //     chromeOptions.addArguments("--headless=new");
                
                driver = new ChromeDriver(chromeOptions);
                // Add more options as needed
                return driver;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                // Add options as needed
                return new FirefoxDriver(firefoxOptions);
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                // Add options as needed
                return new EdgeDriver(edgeOptions);
            default:
                throw new IllegalArgumentException("Browser not supported on Windows: " + browser);
        }
    }

    private static WebDriver initDriverForMac(String browser) {
        // Use switch-case inside mac block
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                return new ChromeDriver(chromeOptions);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
            case "safari":
                return new SafariDriver(); // Safari WebDriver comes pre-installed on macOS
            default:
                throw new IllegalArgumentException("Browser not supported on macOS: " + browser);
        }
    }

    private static WebDriver initDriverForLinux(String browser) {
        // Use switch-case inside Linux block
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
             //   chromeOptions.addArguments("--headless");
                return new ChromeDriver(chromeOptions);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new IllegalArgumentException("Browser not supported on Linux: " + browser);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


}
