package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

//This class contains basic methods for actions.

public class Utils {

    private WebDriver driver;
    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    long timeout = 30;

    public void highlightElement(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element,
                    "color: black; border: 4px solid yellow;");
        }
    }

    private WebElement locateElement(By by) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            WebElement element = driver.findElement(by);
            highlightElement(element);
            return element;
    }

    public void click(By by) {
        WebElement webElement = locateElement(by);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 50);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        webElement.click();
    }

    public void enterText(By by, String string) {
            WebElement webElement = locateElement(by);
            webElement.sendKeys(string, Keys.ENTER);
        }

    public boolean isElementPresent(By by) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        List<WebElement> elements;
        elements = driver.findElements(by);
        if (elements.size() > 0)
            return true;
        else
            return false;
    }

}
