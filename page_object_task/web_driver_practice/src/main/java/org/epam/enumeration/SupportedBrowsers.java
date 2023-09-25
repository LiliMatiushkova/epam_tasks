package org.epam.enumeration;

import org.epam.invoker.WebDriverInvoker;
import org.epam.invoker.implementations.ChromeInvoker;
import org.epam.invoker.implementations.FirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {
    FIREFOX(new FirefoxInvoker()),
    CHROME(new ChromeInvoker());

    private WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver() {
        return webDriverInvoker.invokeWebDriver();
    }
}
