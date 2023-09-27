package org.epam.pageobject.modules;

import org.epam.pageobject.BasePage;
import org.epam.pageobject.pages.GeneratorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailYourEstimateModule extends BasePage {
    public EmailYourEstimateModule(WebDriver webDriver) {
        super(webDriver);
    }

        public GeneratorPage returnToGeneratorPage() {
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
