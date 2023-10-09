package org.epam;


import org.epam.pageobject.modules.EstimateModule;
import org.epam.pageobject.pages.GoogleCloudPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
                .fillNumberOfInstances("4")
                .fillSeries("n1")
                .fillMachineType("CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8")
                .clickGpusCheckBox()
                .fillGpuType("NVIDIA_TESLA_V100")
                .fillNumberOfGpusType("1")
                .fillLocalSsd("2")
                .fillDatacenterLocation("europe-west3")
                .fillCommittedUsageLocation("1")
                .addToEstimate()
                .getTotalEstimatedCostText();

        EstimateModule estimateModule = new EstimateModule(webDriver);
        String totalEstimatedCostByEmailText = estimateModule
                .sendToEmail()
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