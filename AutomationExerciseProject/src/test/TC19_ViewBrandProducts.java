package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TC19_ViewBrandProducts extends BrowserLaunchAndClose{
	  
		HomePage homePage;
		ProductPage product;
		
		@Test(priority = 1)
	    public void verifyViewBrandProducts() {
		 homePage = new HomePage(driver);
		 product = new ProductPage(driver);
		 product.clickProductButton();
		 Assert.assertTrue(product.isBrandsDisplayed());
		 System.out.println(product.brandsTitle().getText());
		 product.clickPoloBrand().click();
		 Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/brand_products/Polo");
		 for (WebElement element : product.polobrandProducts()) {
			 element.isDisplayed();
			 System.out.println(element.getText());
		 }
		 product.clickHMBrand().click();
		 Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/brand_products/H&M");
		 for (WebElement element : product.hmbrandProducts()) {
			 element.isDisplayed();
			 System.out.println(element.getText());
		 }
		}
}
