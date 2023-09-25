package org.epam;


import org.epam.pageobject.pages.GoogleCloudPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

        Assert.assertEquals(totalEstimatedCostText, "\n" +
                "          Total Estimated Cost:\n" +
                "          USD 6,341.26\n" +
                "          per 1 month\n" +
                "        ");

    }

}
