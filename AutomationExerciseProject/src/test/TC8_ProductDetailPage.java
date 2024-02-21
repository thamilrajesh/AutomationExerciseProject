package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class TC8_ProductDetailPage extends BrowserLaunchAndClose {
	
	HomePage homePage;
	ProductPage product;
	
	@Test(priority = 1)
    public void verifyProductDetailsPage() {
	 homePage = new HomePage(driver);	
	 product = new ProductPage(driver);
	 Assert.assertTrue(homePage.isHomePageVisible());	
     product.clickProductButton();
     Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/products");
     List<WebElement> Products = driver.findElements(By.xpath("//div[@class='product-overlay']"));
      for (WebElement element : Products) {
         element.isDisplayed();
         element.isEnabled();
       }
     product.clickViewFirstProduct();
     Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/product_details/1");
     Assert.assertTrue(product.isProductDetailsDisplayed());
    }
		
}
