package org.epam.pageobject.pages;

import org.epam.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InBoxPage extends BasePage {
    private WebElement estimatedCostValue;
    protected InBoxPage(WebDriver webDriver) {
        super(webDriver);
    }
    public String checkTotalEstimatedMonthlyCost() {
        webDriver.navigate().refresh();
        WebElement iFrame = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ifmail\"]")));
        webDriver.switchTo().frame("ifmail");
        estimatedCostValue = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//*[contains(text(),\"Estimated Monthly Cost:\")]")));
        return estimatedCostValue.getText();
    }
}
