package Practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {
	
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
	WebDriver	driver = new ChromeDriver();
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	
	driver.manage().window().maximize();
	
     List<WebElement>  rows = driver.findElements(By.xpath("//tbody/tr/td[2]"));
     
     
     List<WebElement>   columns=driver.findElements(By.xpath("//tbody/tr[1]/th"));
     
     
     
     for (WebElement column : columns) {
    	 System.out.println(column.getText());
	}
     
    
	
	
	
	}

} 
