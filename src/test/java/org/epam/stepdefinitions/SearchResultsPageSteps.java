package org.epam.stepdefinitions;

import io.cucumber.java.en.Then;
import org.epam.pageobject.pages.SearchResultsPage;

import static org.epam.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class SearchResultsPageSteps {
    @Then("User is successfully navigated from {string} to the {string}")
    public void userSelectSearchTerm(String pageNameFirst, String pageName) {
        PAGES_STORAGE.put(pageName, ((SearchResultsPage) PAGES_STORAGE.get(pageNameFirst)).openCalculatorPage());
    }
}
