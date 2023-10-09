package org.epam.stepdefinitions;

import io.cucumber.java.en.Then;
import org.epam.pageobject.modules.EstimateModule;
import org.epam.pageobject.pages.InBoxPage;
import org.testng.Assert;

import static org.epam.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class InBoxPageSteps {
    @Then("Received email is present with info {string} on the {string}")
    public void estimatedCostIsPresentInReceivedEmail(String expectedEstimateCostEmail, String pageName) {
        String estimateCostEmail = ((InBoxPage) PAGES_STORAGE.get(pageName)).checkTotalEstimatedMonthlyCost();
        Assert.assertEquals(expectedEstimateCostEmail, estimateCostEmail);
    }
    @Then("Cost present in {string} equals to the cost present on {string}")
    public void checkCostInEstimateModuleEqualsCostInEmail(String pageNameEstimateModule, String pageNameInBox) {
        String estimateCost = ((EstimateModule) PAGES_STORAGE.get(pageNameEstimateModule)).getTotalEstimatedCostText();
        String estimateCostEmail = ((InBoxPage) PAGES_STORAGE.get(pageNameInBox)).checkTotalEstimatedMonthlyCost();
        String regex = "[^\\d{1,2}[\\,\\.]\\d{3}\\.\\d{1,2}]";
        String numberOfEstimated = estimateCost.replaceAll(regex, "");
        String numberOfEstimatedByEmail = estimateCostEmail.replaceAll(regex, "");
        Assert.assertEquals(numberOfEstimated, numberOfEstimatedByEmail);
    }
}
