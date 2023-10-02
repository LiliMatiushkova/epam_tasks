package org.epam.pageobject.pages;

import org.epam.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a[@class='gs-title']")
    private WebElement searchItem;

    protected SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CalculatorPage openCalculatorPage() {
        searchItem.click();
        return new CalculatorPage(webDriver);
    }
}
