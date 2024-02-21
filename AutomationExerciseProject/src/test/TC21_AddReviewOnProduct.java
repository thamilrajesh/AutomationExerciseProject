package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.ProductPage;

public class TC21_AddReviewOnProduct extends BrowserLaunchAndClose {
	
	ProductPage product;
	CartPage cart;
		
	@Test(priority = 1)
    public void VerrifyReviewAddedOnProduct() {
	product = new ProductPage(driver);
	cart = new CartPage(driver);
	product.clickProductButton();
	Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/products");
	product.ClickViewProductButton();
	cart.isWriteyourReviewVisible();
	System.out.println(cart.writeyourReviewElement().getText());
	cart.writeAndSubmitReview("Latha","latha@gmail.com","Good Product");
	Assert.assertTrue(cart.isReviewSuccessMsgVisible());
	System.out.println(cart.ReviewSuccessMsg().getText());
		
	}
}
