package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TC17_RemoveProductsFromCart extends BrowserLaunchAndClose{
  
	HomePage homePage;
	CartPage cart;
	ProductPage product;
	
	@Test(priority = 1)
    public void verifyHomePage() {
	 homePage = new HomePage(driver);
	 cart = new CartPage(driver);
	 product = new ProductPage(driver);
	 Assert.assertTrue(homePage.isHomePageVisible());
	}
	@Test(priority = 2)
    public void verifyRemoveProduct() {
	 product.AddProduct();
	 product.ContinueShoppingButton();	
	 cart.clickCartbutoon();
	 Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
	 cart.clickXremoveButton();
	 WebDriverWait wait = new WebDriverWait(driver, 10);
     wait.until(ExpectedConditions.visibilityOf(cart.IsemptyCartMsg()));
	 Assert.assertEquals(cart.IsemptyCartMsg().getText(),"Cart is empty! Click here to buy products.");
	 System.out.println(cart.IsemptyCartMsg().getText());
	}
}
