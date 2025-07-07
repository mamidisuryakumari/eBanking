package com.eBanking.ui.pages.admin;

import com.eBanking.ui.engine.BasePage;
import com.eBanking.ui.engine.TestContext;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ApporvedAccountOpeningRequestsPage extends BasePage {

    private TestContext context;

    public ApporvedAccountOpeningRequestsPage(TestContext context) {
        super(context);
        this.context = context;
    }

    private final By accountHolderNamesFields = By.xpath("//tbody/tr/td[2]");
    private final By accountHolderSearchFld = By.xpath("//input[@type='search']");
    private final By viewBtn = By.xpath("(//a[text()='View '])[1]");

    public List<String> listOfAccountHolders() {
        List<WebElement> accountHolderNamesList = context.getDriver().findElements(accountHolderNamesFields);
        List<String> availableNames = new ArrayList<>();
        for (WebElement name : accountHolderNamesList) {
            availableNames.add(name.getText());
        }

        System.out.println("Admin page account holders list "+availableNames);
        return availableNames;


    }


    public void searchApprovedAccount(String accountName) {
        context.getBot().enterText(accountHolderSearchFld, accountName)
                .click(viewBtn);
    }

}
