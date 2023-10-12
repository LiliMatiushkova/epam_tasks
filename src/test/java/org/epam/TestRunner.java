package org.epam;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.epam.stepdefinitions"},
        plugin = {"pretty",
                "json:target/reports/cucmber-reports/cucmber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
