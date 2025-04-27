package Practise;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecommerce.utilities.CommonUtils;

public class PractiseScreenShot {
	public static void main(String[] args) throws IOException {
		
	//	WebDriver driver = new ChromeDriver();
	//	driver.manage().window().maximize();
	//	driver.get("https://www.softwaretestingonline.com");
		
	//	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//	 FileUtils.copyFile(screenshot, new File("screenshot.png"));
   
	//	driver.quit();
		
		CommonUtils.getCurrentDate();
		System.out.println(CommonUtils.getCurrentDate());
		CommonUtils.getFutureDay();
		System.out.println(CommonUtils.getFutureDay());
	}
	public void screenShot() {
		
	}

}
