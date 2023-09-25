package org.epam.factory;

import org.epam.enumeration.SupportedBrowsers;
import org.epam.properties.convertors.SupportedBrowserConvertor;
import org.epam.properties.holder.PropertyHolder;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver getWebDriver() {
       // PropertyHolder ph = new PropertyHolder();
       // String browserValue = ph.readProperty("browser");
       // SupportedBrowsers sb = SupportedBrowserConvertor.valueOfWebBrowser(browserValue);
      //  return sb.getWebDriver();
        return SupportedBrowserConvertor.valueOfWebBrowser(
                new PropertyHolder().readProperty("browser")).getWebDriver();
    }
}
