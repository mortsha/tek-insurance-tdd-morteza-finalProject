package tek.tdd.utility;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.tdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
    }

    private WebElement waitToBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    private WebElement waitToBeClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitToBeVisible(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    private List<WebElement> waitToBeVisibleList(List<WebElement> elements) {
        return getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void clickOnElement(WebElement element) {
        LOGGER.debug("Clicking on element {} ", element);
        waitToBeClickable(element).click();
    }

    public void clickOnElement(By locator) {
        LOGGER.debug("Clicking on locator {} ", locator);
        waitToBeClickable(locator).click();
    }

    public String getElementText(WebElement element) {
        return waitToBeVisible(element).getText();
    }

    public boolean isElementDisplayed(WebElement element) {
        LOGGER.debug("Checking element displayed status {} ", element);
        return waitToBeVisible(element).isDisplayed();

    }

    public void sendText(WebElement element, String text) {
        LOGGER.debug("Sending text {} on element {}", text, element);
        WebElement targetElement = waitToBeVisible(element);
        targetElement.clear();
        targetElement.sendKeys(text);
    }

    public void extentInfo(String info) {
        ExtentTestManager.getTest().info(info);
    }

    public void selectDropdownByText(WebElement element, String text) {
        LOGGER.info("Select dropdown by text {} element{}", text, element);
        WebElement dropdownElement = waitToBeVisible(element);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(text);
    }

    public void waitTime(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted during sleep: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

    }

    public List<WebElement> getAllElements(List<WebElement> elements) {
        LOGGER.info("Getting List of ALl Elements {}", elements);
        return waitToBeVisibleList(elements);
    }

    public void selectDropdownByValue(WebElement element, String value) {
        LOGGER.info("Selecting dropdown element {} by value {}", element, value);
        WebElement targetElement = waitToBeClickable(element);
        Select select = new Select(targetElement);
        select.selectByValue(value);
    }

    public String getAttributeValue(WebElement element) {
        return waitToBeVisible(element).getAttribute("data-status");
    }
}
