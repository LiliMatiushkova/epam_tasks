package org.epam.pageobject.pages;

import org.epam.pageobject.BasePage;
import org.openqa.selenium.WebDriver;

public class GeneratorPage extends BasePage {
    public GeneratorPage(WebDriver webDriver) {
        super(webDriver);
    }
    public GeneratorPage openGeneratorPage() {
        webDriver.get("https://yopmail.com/");
        return this;
    }
}
