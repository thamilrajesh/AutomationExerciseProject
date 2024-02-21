package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class TC10_11_HomeAndCartPageSubscription extends BrowserLaunchAndClose {

	HomePage homePage;
	CartPage cartPage;
	
	@Test(priority = 1)
    public void verifyHomePageSubcription() {
	 homePage = new HomePage(driver);	
	 Assert.assertTrue(homePage.isHomePageVisible());
	 JavascriptExecutor js = (JavascriptExecutor) driver;
 	 js.executeScript("window.scrollBy(0,1500)", "");
 	 Assert.assertTrue(homePage.isSubscriptionVisible());
 	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	 homePage.subscriptionDetails("latha@gmail.com");
 	 Assert.assertTrue(homePage.IsSubscriptionSuccessMsgDisplayed());
 	 System.out.println(homePage.SubscriptionSuccessMsg().getText());
	}
	
	@Test(priority = 2)
    public void verifyCartPageSubcription() {
	 cartPage = new CartPage(driver);
	 Assert.assertTrue(homePage.isHomePageVisible());
	 cartPage.clickCartbutoon();
	 JavascriptExecutor js = (JavascriptExecutor) driver;
 	 js.executeScript("window.scrollBy(0,1500)", "");
 	 Assert.assertTrue(cartPage.isSubscriptionVisible());
 	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	 cartPage.cartSubscription("latha@gmail.com");
 	 Assert.assertTrue(cartPage.IsSubscriptionSuccessMsgDisplayed());
	}
}
