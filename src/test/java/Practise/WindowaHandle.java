package Practise;

import org.openqa.selenium.WebDriver;

public class WindowaHandle {
	
	
	
	public static void switchToChildWindow(WebDriver driver) {
		
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		
	}

}
