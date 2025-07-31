package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OtpPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private final By otpPageLocator = AppiumBy.accessibilityId("Code eingeben");
    private final By otpFieldLocator = By.xpath("//android.widget.EditText");
    private final By submitBtnLocator = AppiumBy.accessibilityId("Senden");

    public OtpPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(otpPageLocator));
            System.out.println("Login successful.");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void enterOTP(){

    }


}
