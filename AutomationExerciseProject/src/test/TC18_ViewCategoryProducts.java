package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TC18_ViewCategoryProducts extends BrowserLaunchAndClose{
	  
		HomePage homePage;
		ProductPage product;
		
		@Test(priority = 1)
	    public void verifyCategoryProducts() {
		 homePage = new HomePage(driver);
		 product = new ProductPage(driver);
		 Assert.assertTrue(product.isCategoriesVisible());
		 product.clickWomenCategory();
		 WebDriverWait wait = new WebDriverWait(driver, 20);
	     wait.until(ExpectedConditions.visibilityOf(product.WomenSubCategory()));
		 product.clickWomenSubCategory();
		 Assert.assertTrue(product.isProductPageTitleDisplayed());
		 System.out.println(product.ProductPageTitle().getText());
		 product.clickMenCategory();
		 WebDriverWait wait2 = new WebDriverWait(driver, 20);
	     wait2.until(ExpectedConditions.visibilityOf(product.MenSubCategory()));
	     product.clickMenSubCategory();
	     System.out.println(product.ProductPageTitle().getText());
	     Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/category_products/3");
		}

}
