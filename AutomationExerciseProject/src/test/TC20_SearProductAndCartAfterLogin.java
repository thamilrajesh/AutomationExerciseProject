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

public class TC20_SearProductAndCartAfterLogin extends BrowserLaunchAndClose {
	
	HomePage homePage;
	ProductPage product;
	CartPage cart;
	LoginAndLogoutPage lp;
	
	@Test(priority = 1)
    public void verifyCartAfterLogin() {
	homePage = new HomePage(driver);	
	product = new ProductPage(driver);
	cart = new CartPage(driver);
	lp = new LoginAndLogoutPage(driver);
	Assert.assertTrue(homePage.isHomePageVisible());	
    product.clickProductButton();
    System.out.println(driver.getCurrentUrl());
    Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/products");
    product.searchProduct("Blue Top");
	 Assert.assertEquals(product.searchedProducts().getText(),"SEARCHED PRODUCTS");
	 List<WebElement> allSearchResults = driver.findElements(By.cssSelector(".product-overlay"));
    for (WebElement items : allSearchResults)
      {
        items.isDisplayed();
       }
	product.AddProduct();
	product.ContinueShoppingButton();
	cart.clickCartbutoon();
	homePage.clickSignUpLoginButton();
	lp.LoginHomepage("thamilgowtham@gmail.com","India123");
	cart.clickCartbutoon();
	Assert.assertTrue(product.isProductDetailsDisplayedInCartPage());
	}


}
