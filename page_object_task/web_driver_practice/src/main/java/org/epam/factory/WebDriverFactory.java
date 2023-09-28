package org.epam.factory;

import org.epam.properties.convertors.SupportedBrowserConvertor;
import org.epam.properties.holder.PropertyHolder;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver getWebDriver() {
        return SupportedBrowserConvertor.valueOfWebBrowser(
                new PropertyHolder().readProperty("browser")).getWebDriver();
    }
}
