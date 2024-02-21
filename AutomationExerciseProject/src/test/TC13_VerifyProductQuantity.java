package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TC13_VerifyProductQuantity extends BrowserLaunchAndClose{
	
	HomePage homePage;
	ProductPage product;
	CartPage cart;
	
	@Test(priority = 1)
     public void verifyProductQuantityInCart() {
	 homePage = new HomePage(driver);
	 product = new ProductPage(driver);
	 cart = new CartPage(driver);
	 Assert.assertTrue(homePage.isHomePageVisible());
	 product.ClickViewProductButton();
	 product.IsPoductDetailsPageDisplayed();
	 product.VerifytheProductQuantity(4);
	 Assert.assertEquals(cart.productQuantityInCart().getText(),"4");
	 }

}
