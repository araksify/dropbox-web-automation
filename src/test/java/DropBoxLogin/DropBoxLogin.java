package DropBoxLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class DropBoxLogin {
    ChromeDriver driver;
    LoginPage loginPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close(); //Close the current window..
    }

    @AfterClass
    public void afterClass() {
        driver.quit(); //Quits this driver, closing every associated window.
    }

    @Test
    public void verifyDropBoxLoginFunctionality() throws InterruptedException {

        driver.navigate().to("https://www.dropbox.com/");
        loginPage.clickToOpenSignInSection();
        loginPage.fillInLoginEmail();
        loginPage.fillInLoginPassword();
        loginPage.clickOnSignInButton();

        assertTrue(loginPage.isUpgradeAccountButtonPresent(), "User is not logged in properly!");
        }
}
