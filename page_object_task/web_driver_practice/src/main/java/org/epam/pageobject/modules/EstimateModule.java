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
    @FindBy(xpath = "//button[@id='Email Estimate']")
    private WebElement emailButton;
    public EstimateModule(WebDriver webDriver) {
        super(webDriver);
    }
    public void sendToEmail() {
        emailButton.click();
    }
    public String getTotalEstimatedCostText() {
        totalEstimatedCost = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//*[@id=\"resultBlock\"]/md-card/md-toolbar/div/h2[2]")));
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
