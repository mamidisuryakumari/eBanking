package Practise;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecommerce.utilities.DropdownUtil;
import com.ecommerce.utilities.Elements;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example {
	
	public static void main(String args[]) {
		
		WebDriverManager.chromedriver().setup(); 
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.softwaretestingonline.com/2024/10/HandleMultipleWindows.html");
        
        By submitBtn = By.id("submitBtn");
        By resetBtn = By.xpath("//button[text()='Reset']");
        
    //    driver.findElement(By.id("submitBtn")).submit();
    //    Elements.moveToElement(driver, resetBtn);
        
        By textBox = By.id("textbox");
  //     Elements.doJsSendKeys(driver, textBox, "kumari");
        
        By checkBox = By.id("checkbox");
     //   Elements.moveToElement(driver, checkBox);
     //   Elements.selectCheckbox(driver, checkBox);
        
        By selectCheckbox = By.id("selectedCheckbox");
    //    Elements.moveToElement(driver, selectCheckbox);
    //    Elements.unSelectCheckbox(driver, selectCheckbox);
        
        By dropDown = By.id("dropdown");
    //DropdownUtil.selectByIndex(driver, dropDown, 1);
        
    //    DropdownUtil.selectByValue(driver, dropDown, "us");
        
   //     By textBoxText = By.xpath("//label[text()='Text Box:']");
        
        
  //      System.out.println(Elements.getText(driver, textBoxText));
        
        By windowHandle = By.xpath("//button[text()='Open Single Window']");
        Elements.doClick(driver, windowHandle);
        com.ecommerce.utilities.Window.switchToChildWindow(driver);
        
        System.out.println(driver.getTitle());
        
        
	}

}
