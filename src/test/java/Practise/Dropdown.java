package Practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.ecommerce.utilities.Constants;
import com.ecommerce.utilities.Elements;
import com.ecommerce.utilities.WaitUtils;

public class Dropdown {
	private static boolean bstatus;

	public void selectByvalue(WebDriver driver, By locator, String text) {
		WebElement element = driver.findElement(locator);
		Select dropDown = new Select(element);
		List<WebElement> options = dropDown.getOptions();
		for (WebElement option : options) {
			dropDown.selectByValue(text);
		}
	}

	// Select By value
	public boolean selectByValue1(WebDriver driver, By locator, String value) {
		bstatus = WaitUtils.waitForElementIsVisible(driver, locator, Constants.maxWaitTime);
		if (bstatus) {
			Select select = new Select(Elements.getWebElement(driver, locator));
			select.selectByValue(value);
			return true;
		} else {
			System.err.println("Dropdown " + locator + " was not present.");
			return false;
		}
	}

	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.softwaretestingonline.com/2024/08/DropdownTypes.html");
	//	By dropDown = By.id("singleSelect");
	//	Dropdown drop = new Dropdown();
		// drop.selectByvalue(driver, dropDown, "1");
	//	drop.selectByValue1(driver, dropDown, "1");

		 WebElement element =driver.findElement(By.id("singleSelect"));
		 Select dropDown = new Select(element);
		// List<WebElement> options = dropDown.getOptions();
		// for(WebElement option : options) {
		// System.out.println(option.getText());
		// }
		 dropDown.selectByValue("1");
	}

}
