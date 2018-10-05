package pages;

import org.openqa.selenium.WebDriver;


public class AbstractPage {
    protected WebDriver driver;

    protected Utils utils;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }
}
