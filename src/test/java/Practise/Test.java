package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Test {
	
	

	
	    private static final Logger logger = LoggerFactory.getLogger(Test.class);

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

	    public static void main(String[] args) throws InterruptedException  {
	    	WebDriverManager.chromedriver().setup(); 
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.google.com"); // Open a sample webpage

	        // Locate the search box
	        WebElement searchBox = driver.findElement(By.name("q"));
	        
	        // Enter some text
	        searchBox.sendKeys("Selenium WebDriver");
	        
	        // Select the text using CTRL + A
	        Actions actions = new Actions(driver);
	        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	        Thread.sleep(2000);

	        // Call copyPaste method to copy and paste the text
	       actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
	       Thread.sleep(2000);
	       actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	       
	    }
	}



