package org.epam.pageobject.pages;

import org.epam.pageobject.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPage extends BasePage {
    @FindBy(name = "q")
    private WebElement searchField;

    public GoogleCloudPage(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleCloudPage open() {
        webDriver.get("https://cloud.google.com/");
        return this;
    }
    public SearchResultsPage search(String searchData){
        this.searchField.sendKeys(searchData);
        searchField.sendKeys(Keys.ENTER);

        return new SearchResultsPage(webDriver);
    }
}
