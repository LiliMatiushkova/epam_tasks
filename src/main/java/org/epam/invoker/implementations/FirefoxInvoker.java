package org.epam.invoker.implementations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.epam.invoker.WebDriverInvoker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxInvoker implements WebDriverInvoker {
    @Override
    public WebDriver invokeWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
