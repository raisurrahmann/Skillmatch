package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LandingPage;

public class SplashTest extends BaseTest {
    private LandingPage landingPage;


    @Test
    public void testSplashScreenAndSkip() {
        landingPage = new LandingPage(driver); // <- instantiate it here
        landingPage.verifySplashScreenVisible();
        landingPage.tapSkipButton();
    }
}
