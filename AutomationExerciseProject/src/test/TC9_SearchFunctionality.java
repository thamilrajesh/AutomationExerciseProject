package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginAndLogoutPage;
import pages.ProductPage;

public class TC9_SearchFunctionality extends BrowserLaunchAndClose {
	HomePage homePage;
	ProductPage product;
	CartPage cart;
	
	@Test(priority = 1)
    public void verifySearchProduct() {
	 homePage = new HomePage(driver);	
	 product = new ProductPage(driver);
	 cart = new CartPage(driver);
	 Assert.assertTrue(homePage.isHomePageVisible());	
     product.clickProductButton();
     Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/products");
     product.searchProduct("Blue Top");
	 Assert.assertEquals(product.searchedProducts().getText(),"SEARCHED PRODUCTS");
	 List<WebElement> allSearchResults = driver.findElements(By.cssSelector(".product-overlay"));
     for (WebElement items : allSearchResults)
       {
         items.isDisplayed();
        }
	}
	

}
