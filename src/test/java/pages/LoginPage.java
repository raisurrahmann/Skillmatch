package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private final By loginTitleLocator = AppiumBy.accessibilityId("Anmelden");
    private final By usernameFieldLocator = By.xpath("(//android.widget.EditText)[1]");
    private final By passwordFieldLocator = By.xpath("(//android.widget.EditText)[2]");
    private final By loginButtonLocator = By.xpath("(//android.view.View[@content-desc='Anmelden']");
    private final By errorMessageLocator = AppiumBy.accessibilityId("Anmelden\\nFalsches Passwort oder Benutzername/E-Mail. Bitte versuch es erneut");


    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean verifyLoginPageVisible() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(loginTitleLocator));
        System.out.println("Login page is visible.");
        return title.isDisplayed();
    }

    public void enterUsername(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldLocator));
        usernameField.click();
        usernameField.clear();
        usernameField.sendKeys(username);
        System.out.println("Entered username.");
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Entered password.");
    }

    public void tapLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        loginButton.click();
        System.out.println("Tapped login button.");
    }


    public boolean isErrorMessageDisplayed() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
            System.out.println("Error message displayed: " + error.getText());
            return true;
        } catch (TimeoutException e) {
            System.out.println("Error message not shown within wait time.");
            return false;
        }
    }
}
