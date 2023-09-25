package org.epam.pageobject.pages;

import org.epam.pageobject.BasePage;
import org.epam.pageobject.modules.ComputeEngineModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends BasePage {

    private WebElement searchItem;

    protected SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ComputeEngineModule openCalculatorPage() {
        searchItem = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//*[@class=\"gs-title\"]//b[contains(text(),'Google Cloud Pricing Calculator')][1]")));
        searchItem.click();
        return new ComputeEngineModule(webDriver);
    }
}
