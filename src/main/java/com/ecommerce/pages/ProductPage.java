package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ecommerce.utilities.Constants;
import com.ecommerce.utilities.Elements;
import com.ecommerce.utilities.MouseActionsUtil;

public class ProductPage {

	private WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	private By menMenu = By.linkText("Men");
	private By menFootware = By.linkText("Men Footwear");
	private By productNameLink = By.xpath("//a[contains(normalize-space(text()),'" + Constants.productName + "')]");
	private By addToCartBtn = By.xpath("//span[@class='add_product']");
	private static By viewCartBtn = By.linkText("View Cart");

	private By productTitles = By.xpath("//h2[@class='post-title item_name']");
	private By womenMenu = By.linkText("Women");
	private By womenKurties = By.linkText("Kurtis");
	private By firstProduct = By
			.xpath("//a[contains(text(), 'Georgette Traditional Ethnic Long Sequins Embroidered Anarkali Gown')]");
	private By secondproduct = By.xpath("//a[contains(text(),'Anarkali Kurti')]");

	private By product1 = By.xpath("(//i[@class='fa fa-shopping-bag'])[1]");
	private By product2 = By.xpath("(//i[@class='fa fa-shopping-bag'])[2]");

	public String getProductPageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();

	}

	public ProductDetailsPage selectSingleProduct() {

		MouseActionsUtil.moveToElement(driver, womenMenu);
		MouseActionsUtil.moveToElement(driver, womenKurties);
		Elements.doClick(driver, womenKurties);
		List<WebElement> allProducts = driver.findElements(productTitles);
		WebElement firstProduct = allProducts.get(0);
		firstProduct.click();
		return new ProductDetailsPage(driver);
	}
	
	public ProductDetailsPage selectFirstProduct() {
		MouseActionsUtil.moveToElement(driver, womenMenu);
		MouseActionsUtil.moveToElement(driver, womenKurties);
		Elements.doClick(driver, womenKurties);
		List<WebElement> allProducts = driver.findElements(productTitles);
		WebElement firstProduct = allProducts.get(0);
		firstProduct.click();
		return new ProductDetailsPage(driver);
		
	}
	public ProductDetailsPage selectSecondProduct() {
		MouseActionsUtil.moveToElement(driver, womenMenu);
		MouseActionsUtil.moveToElement(driver, womenKurties);
		Elements.doClick(driver, womenKurties);
		List<WebElement> allProducts = driver.findElements(productTitles);
		WebElement firstProduct = allProducts.get(1);
		firstProduct.click();
		return new ProductDetailsPage(driver);
	}
	public void selectProductFromWomensCategeory() {

		MouseActionsUtil.moveToElement(driver, womenMenu);
		MouseActionsUtil.moveToElement(driver, womenKurties);
		Elements.doClick(driver, womenKurties);
		for (int i = 0; i < 2; i++) {
			List<WebElement> allProducts = driver.findElements(productTitles);
			int count = 0;
			WebElement product = allProducts.get(i);
			product.click();
			Elements.doClick(driver, addToCartBtn);
			
			if (count != 2) {
				driver.navigate().back();
				count++;
			} else {
				Elements.doClick(driver, viewCartBtn);
				break;
			}

		}

	}

	public void selectProductFromWomensCategeory1() throws InterruptedException {

		MouseActionsUtil.moveToElement(driver, womenMenu);
		MouseActionsUtil.moveToElement(driver, womenKurties);
		Elements.doClick(driver, womenKurties);

		List<WebElement> allProducts = driver.findElements(productTitles);
		int count = 1;
		for (WebElement product : allProducts) {
			product.click();
			Elements.doClick(driver, addToCartBtn);

			if (count != 2) {
				driver.navigate().back();
				count++;
			} else {
				Elements.doClick(driver, viewCartBtn);
				break;
			}

		}

	}

	public ProductDetailsPage selectFirstProduct1() {
		MouseActionsUtil.moveToElement(driver, womenMenu);
		MouseActionsUtil.moveToElement(driver, womenKurties);
		Elements.doClick(driver, womenKurties);
		Elements.doClick(driver, firstProduct);
		return new ProductDetailsPage(driver);
	}

	public ProductDetailsPage selectSecondProduct2() {

		Elements.doClick(driver, secondproduct);
		return new ProductDetailsPage(driver);
	}

	public void addMultipleProducts() {
		Elements.doClick(driver, product1);
		Elements.doClick(driver, product2);
	}

}
