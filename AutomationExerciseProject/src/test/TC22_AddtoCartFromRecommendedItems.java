package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TC22_AddtoCartFromRecommendedItems extends BrowserLaunchAndClose {

	HomePage homePage;
	CartPage cart;
	ProductPage product;
	
	@Test(priority = 1)
    public void VerrifyRecommendedProductsAdded() {
	homePage = new HomePage(driver);
	cart = new CartPage(driver);
	product = new ProductPage(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,5000)", "");
	Assert.assertTrue(homePage.isRecommendedItemsVisible());
    System.out.println(homePage.RecommededItemTitle().getText());
    homePage.clickRecommendedAddToCart();
    product.clickpopupviewCart();
    Assert.assertTrue(cart.IsproductDetailsInCartDisplayed());
    System.out.println(cart.productDetailInCart().getText());
    	
	}
	
}
