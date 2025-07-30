package pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    private final String skipButtonId = "Überspringen";
    private final String emailXpath = "//android.widget.ScrollView/android.widget.EditText[1]";
    private final String passwordXpath = "//android.widget.ScrollView/android.widget.EditText[2]";
    private final String loginButtonText = "Einloggen"; // if available by text

    // Actions
    public void tapSkipButton() {
        WebElement skip = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(skipButtonId)));
        skip.click();
    }

    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(emailXpath)));
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(passwordXpath)));
        passwordField.sendKeys(password);
    }

    public void tapLoginButton() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + loginButtonText + "\")")));
        loginBtn.click();
    }
}
