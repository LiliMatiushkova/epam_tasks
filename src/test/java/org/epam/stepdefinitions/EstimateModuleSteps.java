package org.epam.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.epam.pageobject.modules.EstimateModule;

import static org.epam.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class EstimateModuleSteps {
    public static String estimatedCost;

    @Then("{string} is present with info monthly cost")
    public String estimateCostIsPresent(String pageName) {
        return estimatedCost = ((EstimateModule) PAGES_STORAGE.get(pageName)).getTotalEstimatedCostText();
    }
    @When("User click on Email Estimate button on the {string}")
    public void userClickOnEmailEstimateButton(String pageName) {
        ((EstimateModule) PAGES_STORAGE.get(pageName)).sendToEmail();
    }
    @And("Open a new tab from the {string}")
    public void userOpenNewTab(String pageName) {
        PAGES_STORAGE.put("Generator Page", ((EstimateModule) PAGES_STORAGE.get(pageName)).openNewTab());
    }
}
