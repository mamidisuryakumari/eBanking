package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utilities.Elements;

public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	private static By cartQuantity = By.xpath("//h2[text()='You have ']");
	private static By itemQuantity = By.xpath("(//span[@class='simpleCart_quantity'])[2]");
	
	public String getCartPageTitle() {
		System.out.println(driver.getTitle());
	return	driver.getTitle();
	}

	public int getItemQuantity() {
		String itemQuantitytext =  Elements.getText(driver, itemQuantity);
		
	return 	Integer.parseInt(itemQuantitytext);
	}
	
	
}
