package org.epam.pageobject.pages;

import org.epam.pageobject.BasePage;
import org.epam.pageobject.modules.ProfileInfoModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//button[@aria-label=\"Open user account menu\"]")
    private WebElement profileInfoButton;

    protected HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProfileInfoModule openProfileInfoModule() {
        profileInfoButton.click();
        return new ProfileInfoModule(webDriver);
    }
}
