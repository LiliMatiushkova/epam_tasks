package org.epam;

import org.epam.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected final WebDriver webDriver
            = new WebDriverFactory().getWebDriver();

    protected void setUpWebDriver() {
        webDriver.manage().window().maximize();
    }
    protected void quit() {
        webDriver.quit();
    }
}
