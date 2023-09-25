package org.epam;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.epam.pageobject.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        setUpWebDriver();
    }
    @AfterMethod
    public void closeDriver() {
        quit();
    }

    @Test
    public void gitHubLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        String userInfoText = loginPage
                .open()
                        .login("lilia_0801@ukr.net","Rikkitikki27")
                                .openProfileInfoModule()
                                        .getUserInfoText();

       /* driver.get("https://github.com/login");

        WebElement loginField = driver.findElement(By.id("login_field"));
        loginField.sendKeys("lilia_0801@ukr.net");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Rikkitikki27");

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();

        WebElement profileInfoButton = driver.findElement(By.xpath("//button[@aria-label=\"Open user account menu\"]"));
        profileInfoButton.click();

        WebElement userInfoText = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//div[@class=\"Overlay-headerContentWrap\"]//span[@class=\"Truncate-text\"]")));

      //  WebElement userInfoText = driver.findElement(
       //         By.xpath("//div[@class=\"Overlay-headerContentWrap\"]//span[@class=\"Truncate-text\"]")); */
        Assert.assertEquals(userInfoText, "LiliMatiushkova");

    }

    @DataProvider(name = "wrongCredentials")
    public Object[][] wrongCredentials() {
        return new Object[][] {
                {"qwerty", "Rikkitikki27"},
                {"lilia_0801@ukr.net", "qwerty"},
                {"qwerty", "qwerty"}
        };
    }

    @Test(dataProvider = "wrongCredentials")
    public void gitHubLoginNegativeTest(String login, String password) {

        webDriver.get("https://github.com/login");

        WebElement loginField = webDriver.findElement(By.id("login_field"));
        loginField.sendKeys(login);

        WebElement passwordField = webDriver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        WebElement signInButton = webDriver.findElement(By.name("commit"));
        signInButton.click();


        WebElement errorLabel = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(
                        "js-flash-container")));

        Assert.assertEquals("Incorrect username or password.", errorLabel.getText());

    }
}
