package org.epam.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.epam.pageobject.pages.GoogleCloudPage;

import static org.epam.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org.epam.stepdefinitions.BaseSteps.webDriver;

public class GoogleCloudPageSteps {
    @Given("User is on {string}")
    public void userIsOnGoogleCloudPage(String pageName) {
        GoogleCloudPage googleCloudPage = new GoogleCloudPage(webDriver);
        PAGES_STORAGE.put(pageName, googleCloudPage);
        googleCloudPage.open();
    }
    @When("User perform search for {string} on {string}")
    public void userPerformSearch(String searchPhrase, String pageName) {
        PAGES_STORAGE.put("Search Results Page",((GoogleCloudPage) PAGES_STORAGE.get(pageName)).search(searchPhrase));
    }
}
