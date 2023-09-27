package org.epam.pageobject.pages;

import org.epam.pageobject.BasePage;
import org.epam.pageobject.modules.EstimateModule;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CalculatorPage extends BasePage {
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
    @FindBy(xpath = "//md-select[@id=\"select_505\"]")
    private WebElement gpuTypeField;
    @FindBy(xpath = "//md-select[@id=\"select_507\"]")
    private WebElement numberOfGpusField;
    @FindBy(xpath = "//*[@id=\"select_value_label_463\"]")
    private WebElement localSsdField;
    @FindBy(xpath = "//*[@id=\"select_value_label_96\"]")
    private WebElement datacenterLocationField;
    private WebElement searchInput;
    @FindBy(xpath = "//*[@id=\"select_value_label_97\"]")
    private WebElement committedUsageField;
    @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')][1]")
    private WebElement addToEstimateButton;
    @FindBy(xpath = "//button[@id='Email Estimate']")
    private WebElement emailButton;
    public CalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public EstimateModule fillForm(String quantity) {

        webDriver.switchTo().frame(0);
        iFrame = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        webDriver.switchTo().frame("myFrame");


        numberOfInstancesField = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"input_98\"]")));
        numberOfInstancesField.sendKeys(quantity);

        seriesField.click();
        List<WebElement> seriesList = webDriver.findElements(By.xpath("//div[@id=\"select_container_124\"]//md-content[@class=\"_md\"]/md-option"));
        waitForElements(seriesList.get(0)).click();

        machineTypeField.click();
        List<WebElement> machineTypeList = webDriver.findElements(By.xpath("//div[@id=\"select_container_126\"]//md-content[@class=\"_md\"]//md-optgroup[@label=\"standard\"]/md-option"));
        waitForElements(machineTypeList.get(3)).click();

        addGpusCheckBox.click();

        gpuTypeField.click();
        gpuTypeField = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select_option_512\"]")));
        gpuTypeField.findElement(By.xpath("//*[@id=\"select_option_512\"]"));
        waitForElements(gpuTypeField).click();

        numberOfGpusField.click();
        List<WebElement> numberOfGpusList = webDriver.findElements(By.xpath("//div[@id=\"select_container_508\"]//md-content[@class=\"_md\"]/md-option"));
        waitForElements(numberOfGpusList.get(1)).click();

        localSsdField.click();
        List<WebElement> localSsdList = webDriver.findElements(By.xpath("//div[@id=\"select_container_465\"]//md-content[@class=\"_md\"]/md-option"));
        waitForElements(localSsdList.get(2)).click();

        datacenterLocationField.click();
        datacenterLocationField = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"input_130\"]")));
        searchInput = webDriver.findElement(By.xpath("//input[@id=\"input_130\"]"));
        searchInput.sendKeys("F");
        searchInput = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@id=\"select_option_263\"]")));
        searchInput.findElement(By.xpath("//md-option[@id=\"select_option_263\"]")).click();

        committedUsageField.click();
        List<WebElement> committedUsageList = webDriver.findElements(By.xpath("//div[@id=\"select_container_139\"]//md-content[@class=\"_md\"]/md-option"));
        waitForElements(committedUsageList.get(1)).click();

        addToEstimateButton.click();
        emailButton.click();

        return new EstimateModule(webDriver);
    }
}
