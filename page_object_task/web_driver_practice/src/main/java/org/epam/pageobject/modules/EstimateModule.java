package org.epam.pageobject.modules;

import org.epam.pageobject.BasePage;
import org.epam.pageobject.pages.GeneratorPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class EstimateModule extends BasePage {
    private WebElement totalEstimatedCost;
    private String totalEstimatedCostText;
    public EstimateModule(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTotalEstimatedCostText() {
        totalEstimatedCost = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//*[@id=\"resultBlock\"]//h2/b")));
        return totalEstimatedCost.getText();
    }
    public GeneratorPage openNewTab() {
        String originalWindowHandle = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
        return new GeneratorPage(webDriver);
    }
}
