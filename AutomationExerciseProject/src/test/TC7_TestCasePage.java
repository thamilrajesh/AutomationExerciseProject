package test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TC7_TestCasePage extends BrowserLaunchAndClose {
	
	HomePage homePage;
	
	@Test(priority = 1)
     public void verifyTestCasePage() {
	 homePage = new HomePage(driver);	
	 Assert.assertTrue(homePage.isHomePageVisible());	
     homePage.clickTestCaseButton();
     Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/test_cases"); 
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
