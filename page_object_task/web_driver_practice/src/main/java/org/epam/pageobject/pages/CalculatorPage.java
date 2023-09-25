package org.epam.pageobject.pages;

import org.epam.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage extends BasePage {
    private WebElement computeEngineButton;

    protected CalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CalculatorPage openComputeEngineForm() {
        computeEngineButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-item-1")));
        computeEngineButton.click();
        return new CalculatorPage(webDriver);
    }
}
