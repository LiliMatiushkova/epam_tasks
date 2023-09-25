package org.epam.pageobject.modules;

import org.epam.pageobject.BasePage;
import org.epam.pageobject.pages.GeneratorPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.awt.SystemColor.window;

public class EstimateModule extends BasePage {
    private WebElement totalEstimatedCost;
    @FindBy(xpath = "EmailYourEstimateModule")
    private WebElement emailButton;
    private String totalEstimatedCostText = "\n" +
            "          Total Estimated Cost:\n" +
            "          USD 6,341.26\n" +
            "          per 1 month\n" +
            "        ";
    protected EstimateModule(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTotalEstimatedCostText() {
        totalEstimatedCost = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//*[@id=\"resultBlock\"]//h2/b")));
        return totalEstimatedCost.getText();
    }
    public EmailYourEstimateModule sendToEmail() {
        emailButton.click();
        return new EmailYourEstimateModule(webDriver);
    }
    public GeneratorPage openNewBrowserWindow() {
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
        return new GeneratorPage(webDriver);
    }
}
