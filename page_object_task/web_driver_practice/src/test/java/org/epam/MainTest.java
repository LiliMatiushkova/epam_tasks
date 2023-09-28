package org.epam;


import org.epam.pageobject.modules.EstimateModule;
import org.epam.pageobject.pages.GeneratorPage;
import org.epam.pageobject.pages.GoogleCloudPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class MainTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        setUpWebDriver();
    }
    @AfterMethod
    public void closeDriver() {
        quit();
    }
    @Test
    public void calculatorTest() {

        GoogleCloudPage googleCloudPage = new GoogleCloudPage(webDriver);
        String totalEstimatedCostText = googleCloudPage
                .open()
                .search("Google Cloud Platform Pricing Calculator")
                .openCalculatorPage()
                .fillForm("4")
                .getTotalEstimatedCostText();

        EstimateModule estimateModule = new EstimateModule(webDriver);
        String totalEstimatedCostByEmailText = estimateModule
                .openNewTab()
                .openGeneratorPage().generateEmail()
                .goToInBoxPage()
                .checkTotalEstimatedMonthlyCost();
        String regex = "[^\\d{1,2}[\\,\\.]\\d{3}\\.\\d{1,2}]";
        String numberOfEstimated = totalEstimatedCostText.replaceAll(regex, "");
        String numberOfEstimatedByEmail = totalEstimatedCostByEmailText.replaceAll(regex, "");
        Assert.assertEquals(numberOfEstimated, numberOfEstimatedByEmail);
    }
}
