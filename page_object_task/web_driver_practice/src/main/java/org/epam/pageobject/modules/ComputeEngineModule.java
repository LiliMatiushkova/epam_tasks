package org.epam.pageobject.modules;

import org.epam.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComputeEngineModule extends BasePage {
    private WebElement iFrame;
    private WebElement computeEngineButton;
    private WebElement numberOfInstancesField;
    @FindBy(id = "select_111")
    private WebElement operatingSystemSoftwareField;
    @FindBy(xpath = "//*[@id=\"select_115\"]")
    private WebElement provisioningModelField;
    @FindBy(id = "select_121")
    private WebElement machineFamilyField;
    @FindBy(id = "select_value_label_93")
    private WebElement seriesField;
    @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
    private WebElement machineTypeField;
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Add GPUs\"][1]")
    private WebElement addGpusCheckBox;
    private WebElement gpuTypeField;
    private WebElement numberOfGpusField;
    private WebElement numberOfGpusOption;
    @FindBy(xpath = "//*[@id=\"select_value_label_463\"]")
    private WebElement localSsdField;
    @FindBy(xpath = "//*[@id=\"select_value_label_96\"]")
    private WebElement datacenterLocationField;
    @FindBy(xpath = "//*[@id=\"select_value_label_143\"]")
    private WebElement committedUsageField;
    @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')][1]")
    private WebElement addToEstimateButton;
    public ComputeEngineModule(WebDriver webDriver) {
        super(webDriver);
    }

    public EstimateModule fillForm(String quantity) {

        webDriver.switchTo().frame(0);
        iFrame = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        webDriver.switchTo().frame("myFrame");
        webDriver.findElement(By.xpath("//input[@id=\"input_98\"]")).click();


        numberOfInstancesField = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"input_98\"]")));
        this.numberOfInstancesField.sendKeys(quantity);

       // operatingSystemSoftwareField.click();
       // operatingSystemSoftwareField.findElement(By.xpath("//*[@value=\"free\"]")).click();

       // provisioningModelField.click();
       // provisioningModelField.findElement(By.xpath("//*[@value=\"regular\"]")).click();

       // machineFamilyField.click();
        //  machineFamilyField.findElement(By.xpath("//*[@value=\"n1\"]")).click();

        seriesField.click();
        seriesField.findElement(By.xpath("//*[@value=\"n1\"]")).click();

        machineTypeField.click();
        machineTypeField.findElement(By.xpath("//div[contains(text(), 'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]")).click();

        addGpusCheckBox.click();

        gpuTypeField = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-select[@placeholder=\"GPU type\"]")));
        gpuTypeField.click();
        gpuTypeField.findElement(By.xpath("//div[contains(text(), 'NVIDIA Tesla V100')]")).click();

       /* numberOfGpusField = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-select[@placeholder=\"Number of GPUs\"]")));
        numberOfGpusField.click();
        numberOfGpusOption = new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select_option_512\"]")));
        numberOfGpusOption.click(); */

        localSsdField.click();
        localSsdField.findElement(By.xpath("//div[contains(text(), '2x375 GB')]")).click();

        datacenterLocationField.click();
        datacenterLocationField.findElement(By.xpath("//div[contains(text(), 'Frankfurt (europe-west3)')]")).click();

        committedUsageField.click();
        committedUsageField.findElement(By.xpath("//div[contains(text(), '1 Year')]")).click();

        addToEstimateButton.click();

        return new EstimateModule(webDriver);
    }
}
