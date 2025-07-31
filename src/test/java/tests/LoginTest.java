package tests;

import base.BaseTest;
import config.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.OtpPage;

public class LoginTest extends BaseTest {
    private LandingPage landingPage;
    private LoginPage loginPage;
    private OtpPage otpPage;



    @Test
    public void testLoginWithValidCredentials() {
        landingPage = new LandingPage(driver);
        landingPage.verifySplashScreenVisible();
        landingPage.tapSkipButton();

        loginPage = new LoginPage(driver);
        assert loginPage.verifyLoginPageVisible();

        loginPage.enterUsername(TestData.get("valid.email"));
        loginPage.enterPassword(TestData.get("valid.password"));
        loginPage.tapLoginButton();

        Assert.assertTrue(otpPage.isLoginSuccessful(), "Login failed with valid credentials.");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        landingPage = new LandingPage(driver);
        landingPage.verifySplashScreenVisible();
        landingPage.tapSkipButton();

        loginPage = new LoginPage(driver);
        assert loginPage.verifyLoginPageVisible();

        loginPage.enterUsername(TestData.get("invalid.email"));
        loginPage.enterPassword(TestData.get("invalid.password"));
        loginPage.tapLoginButton();

        assert loginPage.isErrorMessageDisplayed();
    }
}
