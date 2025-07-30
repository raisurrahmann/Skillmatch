package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private final By splashScreenLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View");
    private final By skipButtonLocator = AppiumBy.accessibilityId("Überspringen");

    public LandingPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean verifySplashScreenVisible() {
        WebElement splash = wait.until(ExpectedConditions.visibilityOfElementLocated(splashScreenLocator));
        System.out.println("Splash screen is visible.");
        return splash.isDisplayed();
    }

    public void tapSkipButton() {
        try {
            WebElement skip = wait.until(ExpectedConditions.elementToBeClickable(skipButtonLocator));
            skip.click();
            System.out.println("Tapped on the 'Überspringen' (Skip) button.");
        } catch (TimeoutException e) {
            System.out.println("Skip button not found – possibly already skipped.");
        }
    }
}
