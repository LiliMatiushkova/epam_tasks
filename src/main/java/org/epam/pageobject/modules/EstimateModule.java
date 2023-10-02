package org.epam.pageobject.modules;

import org.epam.pageobject.BasePage;
import org.epam.pageobject.pages.GeneratorPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class EstimateModule extends BasePage {
    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-toolbar/div/h2[2]")
    private WebElement totalEstimatedCost;
    @FindBy(xpath = "//button[@id='Email Estimate']")
    private WebElement emailButton;

    public EstimateModule(WebDriver webDriver) {
        super(webDriver);
    }

    public EstimateModule sendToEmail() {
        emailButton.click();
        return this;
    }
    public String getTotalEstimatedCostText() {
        waitForElements(totalEstimatedCost);
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
