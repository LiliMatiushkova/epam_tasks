package org.epam.pageobject.modules;

import org.epam.pageobject.BasePage;
import org.epam.pageobject.pages.GeneratorPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EstimateModule extends BasePage {

    private static String totalCostCss = "//*[@id=\"resultBlock\"]/md-card/md-toolbar/div/h2[2]";
    @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
    private WebElement machineTypeField;

    private WebElement totalEstimatedCost;
    private String totalEstimatedCostText;
    public EstimateModule(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTotalEstimatedCostText() {
        totalEstimatedCost = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(totalCostCss)));
        return totalEstimatedCost.getText();
    }

    private EstimateModule fillMachineType(String name){
        machineTypeField.click();
        List<WebElement> machineTypeList = webDriver.findElements(By.xpath("//div[@id=\"select_container_126\"]//md-content[@class=\"_md\"]//md-optgroup[@label=\"standard\"]/md-option"));
        waitForElements(machineTypeList
                .stream()
                .filter(p -> p.getText().equals(name))
                .findFirst().orElse(null)).click();
        return this;
    }

    public GeneratorPage openNewTab() {
        String originalWindowHandle = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
        return new GeneratorPage(webDriver);
    }
}
