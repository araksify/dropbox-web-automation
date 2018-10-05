package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends AbstractPage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By TO_SIGN_IN_BUTTON = By.id("sign-up-in");
    private static final By LOGIN_EMAIL = By.className("text-input-input");
    private static final By LOGIN_PASSWORD = By.name("login_password");
    private static final By SIGNIN_BUTTON = By.className("signin-text");
    private static final By UPGRADE_ACCOUNT = By.className("sprite-text");

    ChromeDriver driver;


    public void clickToOpenSignInSection() {
        utils.click(TO_SIGN_IN_BUTTON);
    }

    public void fillInLoginEmail() {
        utils.enterText(LOGIN_EMAIL, "arakshq@gmail.com");
    }
    public void fillInLoginPassword() {
        utils.enterText(LOGIN_PASSWORD, "ThisIsTest");
    }
    public void clickOnSignInButton() {
        utils.click(SIGNIN_BUTTON);
    }

    public boolean isUpgradeAccountButtonPresent() {
        return utils.isElementPresent(UPGRADE_ACCOUNT);

    }

}
