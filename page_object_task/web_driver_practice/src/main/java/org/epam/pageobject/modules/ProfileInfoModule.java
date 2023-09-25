package org.epam.pageobject.modules;

import org.epam.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileInfoModule extends BasePage {

    private WebElement userInfoText;
    public ProfileInfoModule(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUserInfoText() {
        userInfoText = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//div[@class=\"Overlay-headerContentWrap\"]//span[@class=\"Truncate-text\"]")));
        return userInfoText.getText();
    }
}
