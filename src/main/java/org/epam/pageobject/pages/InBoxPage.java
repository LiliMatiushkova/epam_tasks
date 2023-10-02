package org.epam.pageobject.pages;

import org.epam.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InBoxPage extends BasePage {
    @FindBy(xpath = "//*[contains(text(),\"Estimated Monthly Cost:\")]")
    private WebElement estimatedCostText;
    private WebElement iFrame;
    private String ifMailFrame = "ifmail";

    protected InBoxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String checkTotalEstimatedMonthlyCost() {
        webDriver.navigate().refresh();
        iFrame = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(ifMailFrame)));
        webDriver.switchTo().frame(ifMailFrame);
        waitForElements(estimatedCostText);
        return estimatedCostText.getText();
    }
}
