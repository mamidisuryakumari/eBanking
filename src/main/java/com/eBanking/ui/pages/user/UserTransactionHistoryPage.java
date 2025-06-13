package com.eBanking.ui.pages.user;

import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.util.Iterator;
import java.util.List;

import com.eBanking.ui.engine.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eBanking.ui.engine.TestContext;

public class UserTransactionHistoryPage extends BasePage {
	
private TestContext context;
	
	public UserTransactionHistoryPage(TestContext context) {
        super(context);
        this.context = context;
	}
	
	
	
	private final  By statusField = By.xpath("//table//tbody//tr//td[6]");
	private final  By amountField = By.xpath("//table//tbody//tr//td[4]");
	private final By rowsField = By.xpath("//table//tbody//tr");
	
	
	double balance = 0; 
	
		
	
	public  Double checkBalance() {
		List<WebElement> allRows= context.getDriver().findElements(rowsField);
		
		for(WebElement row : allRows)
		{
			String amountText = row.findElement(By.xpath("./td[4]")).getText();
            String statusText = row.findElement(By.xpath("./td[6]")).getText();
			if(statusText.equalsIgnoreCase("debit"))
			{
				balance -= Double.parseDouble(amountText);
			}
			 if(statusText.equalsIgnoreCase("credit"))
			{
				balance +=  Double.parseDouble(amountText);
			} 
		}
		System.out.println("Final balance: " + balance);
		context.setCalculateBalance(balance);
		return balance;
		
		}
	
   }
