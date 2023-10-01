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
    private String myFrame = "myFrame";
    private WebElement computeEngineButton;
    private WebElement numberOfInstancesField;
    private String numberOfInstances = "//input[@id=\"input_98\"]";
    @FindBy(id = "select_value_label_93")
    private WebElement seriesField;
    private String seriesOptions = "//div[@id=\"select_container_124\"]//md-content[@class=\"_md\"]/md-option";
    @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
    private WebElement machineTypeField;
    private String machineTypeOptions = "//div[@id=\"select_container_126\"]//md-content[@class=\"_md\"]//md-optgroup[@label=\"standard\"]/md-option";
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Add GPUs\"][1]")
    private WebElement addGpusCheckBox;
    @FindBy(xpath = "//md-select[@id=\"select_505\"]")
    private WebElement gpuTypeField;
    private String gpuTypeOptions = "//*[@id=\"select_option_512\"]";
    @FindBy(xpath = "//md-select[@id=\"select_507\"]")
    private WebElement numberOfGpusField;
    private String numberOfGpusOptions = "//div[@id=\"select_container_508\"]//md-content[@class=\"_md\"]/md-option";
    @FindBy(xpath = "//*[@id=\"select_value_label_463\"]")
    private WebElement localSsdField;
    private String localSsdOptions = "//div[@id=\"select_container_465\"]//md-content[@class=\"_md\"]/md-option";
    @FindBy(xpath = "//*[@id=\"select_value_label_96\"]")
    private WebElement datacenterLocationField;
    private String datacenterLocationOptions = "//div[@id=\"select_container_132\"]//md-optgroup/md-option";
    @FindBy(xpath = "//input[@id=\"input_130\"]")
    private WebElement searchInput;
    @FindBy(xpath = "//*[@id=\"select_value_label_97\"]")
    private WebElement committedUsageField;
    private String committedUsageOptions = "//div[@id=\"select_container_139\"]//md-content[@class=\"_md\"]/md-option";
    @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')][1]")
    private WebElement addToEstimateButton;
    @FindBy(xpath = "//button[@id='Email Estimate']")
    private WebElement emailButton;
    public CalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }

   /* public void fillForm(String quantity) {

        webDriver.switchTo().frame(0);
        iFrame = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        webDriver.switchTo().frame("myFrame");


      /*  numberOfInstancesField = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"input_98\"]")));
        numberOfInstancesField.sendKeys(quantity); */

       /* seriesField.click();
        List<WebElement> seriesList = webDriver.findElements(By.xpath("//div[@id=\"select_container_124\"]//md-content[@class=\"_md\"]/md-option"));
        waitForElements(seriesList.get(0)).click(); */

     /*   machineTypeField.click();
        List<WebElement> machineTypeList = webDriver.findElements(By.xpath("//div[@id=\"select_container_126\"]//md-content[@class=\"_md\"]//md-optgroup[@label=\"standard\"]/md-option"));
        waitForElements(machineTypeList.get(3)).click(); */

       // addGpusCheckBox.click();

      /*  gpuTypeField.click();
        gpuTypeField = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select_option_512\"]")));
        gpuTypeField.findElement(By.xpath("//*[@id=\"select_option_512\"]"));
        waitForElements(gpuTypeField).click(); */

      /*  numberOfGpusField.click();
        List<WebElement> numberOfGpusList = webDriver.findElements(By.xpath("//div[@id=\"select_container_508\"]//md-content[@class=\"_md\"]/md-option"));
        waitForElements(numberOfGpusList.get(1)).click(); */

       /* localSsdField.click();
        List<WebElement> localSsdList = webDriver.findElements(By.xpath("//div[@id=\"select_container_465\"]//md-content[@class=\"_md\"]/md-option"));
        waitForElements(localSsdList.get(2)).click(); */

       /* datacenterLocationField.click();
        datacenterLocationField = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"input_130\"]")));
        searchInput = webDriver.findElement(By.xpath("//input[@id=\"input_130\"]"));
        searchInput.sendKeys("F");
        searchInput = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@id=\"select_option_263\"]")));
        searchInput.findElement(By.xpath("//md-option[@id=\"select_option_263\"]")).click(); */

       /* committedUsageField.click();
        List<WebElement> committedUsageList = webDriver.findElements(By.xpath("//div[@id=\"select_container_139\"]//md-content[@class=\"_md\"]/md-option"));
        waitForElements(committedUsageList.get(1)).click(); */

       // addToEstimateButton.click();
       // emailButton.click();

       // return new EstimateModule(webDriver);
  //  }
       public CalculatorPage fillNumberOfInstances(String quantity){
        webDriver.switchTo().frame(0);
        iFrame = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        webDriver.switchTo().frame(myFrame);
        numberOfInstancesField = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(numberOfInstances)));
        numberOfInstancesField.sendKeys(quantity);
        return this;
    }
      public CalculatorPage fillSeries(String name){
        seriesField.click();
        List<WebElement> seriesList = webDriver.findElements(By.xpath(seriesOptions));
        waitForElements(seriesList
                .stream()
                .filter(p -> p.getText().equals(name))
                .findFirst().orElse(null))
                .click();
        return this;
    }
    public CalculatorPage fillMachineType(String name){
        machineTypeField.click();
        List<WebElement> machineTypeList = webDriver.findElements(By.xpath(machineTypeOptions));
        waitForElements(machineTypeList
                .stream()
                .filter(p -> p.getText().equals(name))
                .findFirst().orElse(null))
                .click();
        return this;
    }
    public CalculatorPage clickGpusCheckBox(){
        addGpusCheckBox.click();
        return this;
    }
    public CalculatorPage fillGpuType(String name){
        gpuTypeField.click();
        List<WebElement> gpuTypeList = webDriver.findElements(By.xpath(gpuTypeOptions));
        waitForElements(gpuTypeList
                .stream()
                .filter(p -> p.getText().equals(name))
                .findFirst().orElse(null))
                .click();
        return this;
    }
    public CalculatorPage fillNumberOfGpusType(String name){
        numberOfGpusField.click();
        List<WebElement> numberOfGpusList = webDriver.findElements(By.xpath(numberOfGpusOptions));
        waitForElements(numberOfGpusList
                .stream()
                .filter(p -> p.getText().equals(name))
                .findFirst().orElse(null))
                .click();
        return this;
    }
    public CalculatorPage fillLocalSsd(String name){
        localSsdField.click();
        List<WebElement> localSsdList = webDriver.findElements(By.xpath(localSsdOptions));
        waitForElements(localSsdList
                .stream()
                .filter(p -> p.getText().equals(name))
                .findFirst().orElse(null))
                .click();
        return this;
    }
    public CalculatorPage fillDatacenterLocation(String searchTerm, String name){
        datacenterLocationField.click();
        waitForElements(searchInput);
        searchInput.click();
        searchInput.sendKeys(searchTerm);
        List<WebElement> datacenterLocationList = webDriver.findElements(By.xpath(datacenterLocationOptions));
        waitForElements(datacenterLocationList
                .stream()
                .filter(p -> p.getText().equals(name))
                .findFirst().orElse(null))
                .click();
        return this;
    }
    public CalculatorPage fillCommittedUsageLocation(String name){
        committedUsageField.click();
        List<WebElement> committedUsageList = webDriver.findElements(By.xpath(committedUsageOptions));
        waitForElements(committedUsageList
                .stream()
                .filter(p -> p.getText().equals(name))
                .findFirst().orElse(null))
                .click();
        return this;
    }
    public EstimateModule addToEstimate() {
        addToEstimateButton.click();
        return new EstimateModule(webDriver);
    }
}
