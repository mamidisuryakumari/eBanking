package Practise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public static String takeScreenShot(WebDriver driver, String screenShotName) throws IOException {
		String destination = "./Screenshots/" + screenShotName + ".png";
		try {
			File sourse = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourse, new File(destination));
		} catch (Exception e) {
		System.out.println("Screenshot Failed"+screenShotName);	
		}
		return destination;
	}
	
	public static String takeScreenshotByUsingBytes(WebDriver driver,String screenshotName) throws IOException {
		
		String destination = "./Screenshots/" + screenshotName + ".png";
		try {
			byte[] byteArr=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			File destFile=new File(destination);
			FileOutputStream fos=new FileOutputStream(destFile);
			fos.write(byteArr);
			fos.close();
		} catch (Exception e) {
			
		}
		
		return destination;
	}
	
	public static String takeScreenshotByUsingBase64(WebDriver driver,String screenshotName) throws IOException {
		String destination="./Screenshots"+screenshotName+".png";
		try {
			String base64Code=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			byte[] byteArr=Base64.getDecoder().decode(base64Code);
			File destFile=new File(destination);
			FileOutputStream fos=new FileOutputStream(destFile);
			fos.write(byteArr);
			fos.close();	
		} catch (Exception e) {
			
		}
		
		return destination;
	}
	
}
