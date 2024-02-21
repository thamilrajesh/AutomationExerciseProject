package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TC25_26_ScrollupAndDownWithAndWithoutArrow extends BrowserLaunchAndClose {
	HomePage homePage;
	
	@Test(priority = 1)
    public void verifyScrollupWithArrow() {
	 homePage = new HomePage(driver);	
	 Assert.assertTrue(homePage.isHomePageVisible());
	 JavascriptExecutor js = (JavascriptExecutor) driver;
 	 js.executeScript("window.scrollBy(0,3500)", "");
 	 Assert.assertTrue(homePage.isSubscriptionVisible());
 	 WebDriverWait wait = new WebDriverWait(driver, 20);
     wait.until(ExpectedConditions.visibilityOf(homePage.SubscriptionText()));
 	 System.out.println(homePage.SubscriptionText().getText());
 	 homePage.clickArrowUpButton();
 	 Assert.assertTrue(homePage.isFullfledgedTextVisible());
 	 System.out.println(homePage.FullfledgedText().getText());
	}
	
	@Test(priority = 1)
    public void verifyScrollupWithoutArrow() {
	 homePage = new HomePage(driver);	
	 Assert.assertTrue(homePage.isHomePageVisible());
	 JavascriptExecutor js = (JavascriptExecutor) driver;
 	 js.executeScript("window.scrollBy(0,3500)", "");
 	 Assert.assertTrue(homePage.isSubscriptionVisible());
 	 WebDriverWait wait = new WebDriverWait(driver, 20);
     wait.until(ExpectedConditions.visibilityOf(homePage.SubscriptionText()));
 	 System.out.println(homePage.SubscriptionText().getText());
 	 JavascriptExecutor jse = (JavascriptExecutor) driver;
	 jse.executeScript("window.scrollBy(0,-3500)", "");
 	 Assert.assertTrue(homePage.isFullfledgedTextVisible());
 	 System.out.println(homePage.FullfledgedText().getText());
	}

}
