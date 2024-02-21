package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class TC12_AddproducttoCart extends BrowserLaunchAndClose {
	
	HomePage homePage;
	ProductPage product;
		
	@Test(priority = 1)
     public void verifyAddtoCartProduct() {
	 homePage = new HomePage(driver);
	 product = new ProductPage(driver);
	 Assert.assertTrue(homePage.isHomePageVisible());
	 product.clickProductButton();
	 product.AddProductsToCart();
	 JavascriptExecutor js = (JavascriptExecutor) driver;
 	 js.executeScript("window.scrollBy(0,500)", "");
 	 Assert.assertEquals(product.FirstProduct().getText(),"Blue Top");
 	 Assert.assertEquals(product.SecondProduct().getText(),"Men Tshirt");
 	}
	@Test(priority = 2)
    public void verifyAddtoCartProductDetails() {
		String firstProductPrice = product.getFirstProductPrice();
		String firstProductQuantity = product.getFirstProductQuantity();
		String firstProductTotal = product.getFirstProductTotal();
		String secondProductPrice = product.getSecondProductPrice();
		String secondProductQuantity = product.getSecondProductQuantity();
		String secondProductTotal = product.getSecondProductTotal();
		Assert.assertEquals(firstProductPrice, "Rs. 500");
        Assert.assertEquals(firstProductQuantity, "1");
        Assert.assertEquals(firstProductTotal, "Rs. 500");
        Assert.assertEquals(secondProductPrice, "Rs. 400");
        Assert.assertEquals(secondProductQuantity, "1");
        Assert.assertEquals(secondProductTotal, "Rs. 400");
	}
	
}
