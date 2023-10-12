package org.epam.stepdefinitions;

import io.cucumber.java.en.Then;
import org.epam.pageobject.pages.InBoxPage;
import org.testng.Assert;

import static org.epam.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org.epam.stepdefinitions.EstimateModuleSteps.estimatedCost;

public class InBoxPageSteps {
    String estimateCostEmail;

    @Then("Received email is present with info about estimated monthly cost on the {string}")
    public String estimatedCostIsPresentInReceivedEmail(String pageName) {
        return estimateCostEmail = ((InBoxPage) PAGES_STORAGE.get(pageName)).checkTotalEstimatedMonthlyCost();
    }
    @Then("Cost present in Estimate Module equals to the cost present on InBox Page")
    public void checkCostInEstimateModuleEqualsCostInEmail() {
        String regex = "[^\\d{1,2}[\\,\\.]\\d{3}\\.\\d{1,2}]";
        String numberOfEstimated = estimatedCost.replaceAll(regex, "");
        String numberOfEstimatedByEmail = estimateCostEmail.replaceAll(regex, "");
        Assert.assertEquals(numberOfEstimated, numberOfEstimatedByEmail);
    }
}
