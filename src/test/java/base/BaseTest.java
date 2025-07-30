package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Android Device");
        options.setPlatformName("Android");
        options.setApp("C:\\Users\\Dinnova AG BD\\Downloads\\APKs\\[SM][STG][04-07-2025-v3].apk");
        options.setAppPackage("ch.dinnova.skillmatch");
        options.setAppActivity("ch.dinnova.skillmatch.MainActivity");
        options.setNewCommandTimeout(Duration.ofSeconds(300));

        driver = new AndroidDriver(new URL("http://localhost:4723"), options);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}