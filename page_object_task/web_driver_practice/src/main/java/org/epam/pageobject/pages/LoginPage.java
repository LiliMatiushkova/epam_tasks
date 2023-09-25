package org.epam.pageobject.pages;

import org.epam.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "login_field")
    private WebElement userName;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "commit")
    private WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage open() {
        webDriver.get("https://github.com/login");
        return this;
    }

    public HomePage login(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);

        signInButton.click();

        return new HomePage(webDriver);
    }
}
