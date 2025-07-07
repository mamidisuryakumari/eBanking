package com.eBanking.ui.pages.user;

import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.eBanking.ui.engine.BasePage;
import enums.TransactionType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eBanking.ui.engine.TestContext;
@Slf4j
public class UserTransactionHistoryPage extends BasePage {

	private TestContext context;

	public UserTransactionHistoryPage(TestContext context) {
		super(context);
		this.context = context;
	}


	private final By statusField = By.xpath("//table//tbody//tr//td[6]");
	private final By amountField = By.xpath("//table//tbody//tr//td[4]");
	private final By rowsField = By.xpath("//table//tbody//tr");
	private final By nextPageBtn = By.xpath("//a[text()='Next']");
	private final By activePage = By.xpath("//ul[@class='pagination']//*[text()=\"+p+\"]");
	private final By totalPages = By.xpath("//a[@aria-controls= 'dataTable']");


	double balance = 0;


	public Double checkBalance() {
		double balance = 0.0;

		int totalPagesCount = context.getDriver().findElements(totalPages).size();
		log.info("Total pages available: " + totalPagesCount);

		for (int page = 1; page <= totalPagesCount - 2; page++) {
			// Wait for table rows to load
			List<WebElement> allRows = context.getDriver().findElements(rowsField);
			log.info("Page " + page + " has " + allRows.size() + " transactions");

			for (WebElement row : allRows) {
				try {
					String amountText = row.findElement(By.xpath("./td[4]")).getText().replace(",", "").trim();
					String statusText = row.findElement(By.xpath("./td[6]")).getText().trim();

					double amount = Double.parseDouble(amountText);

					if (statusText.equalsIgnoreCase(TransactionType.CREDIT.name())) {
						balance += amount;
					} else if (statusText.equalsIgnoreCase(TransactionType.DEBIT.name())) {
						balance -= amount;
					}
				} catch (Exception e) {
					log.error("Error reading row: " + e.getMessage());
				}
			}

			// Click next page if not on the last page
			if (page < totalPagesCount - 2) {
				try {
					if (context.getBot().getWebElement(nextPageBtn).isEnabled()) {

						log.info("Iteration"+page+""+context.getBot().getWebElement(nextPageBtn).isEnabled()+"");
						context.getBot().click(nextPageBtn);
						Thread.sleep(1000); // Replace with WebDriverWait if using dynamic loads
					} else {
						log.warn("Next button is disabled on page: " + page);
						break;
					}
				} catch (Exception e) {
					log.error("Could not go to page " + (page + 1) + ": " + e.getMessage());
					break;
				}
			}
		}

		log.info("Calculated balance: " + balance);
		context.setCalculateBalance(balance);
		return balance;
	}


}