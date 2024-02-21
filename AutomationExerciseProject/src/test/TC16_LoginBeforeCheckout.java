package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutAndPaymentPage;
import pages.HomePage;
import pages.LoginAndLogoutPage;
import pages.ProductPage;

public class TC16_LoginBeforeCheckout extends BrowserLaunchAndClose {
	HomePage homePage;
	CartPage cart;
	ProductPage product;
	CheckoutAndPaymentPage checkoutPay;
	LoginAndLogoutPage lp;
	
	@Test(priority = 1)
    public void verifyHomePage() {
	 homePage = new HomePage(driver);
	 cart = new CartPage(driver);
	 product = new ProductPage(driver);
	 checkoutPay = new CheckoutAndPaymentPage(driver);
	 lp = new LoginAndLogoutPage(driver);
	 Assert.assertTrue(homePage.isHomePageVisible());
	}
	@Test(priority = 2)
    public void verifyPlaceOrderAfterRegister() {
		homePage.clickSignUpLoginButton();
		lp.LoginHomepage("rajesh@gmail.com","India123");
		Assert.assertTrue(homePage.isLoggedInAsUserVisible());
    	WebElement loggedinuser = homePage.loggeduser();
        System.out.println("Loggedin User: "+loggedinuser.getText());
        product.AddProduct();
		product.ContinueShoppingButton();
		cart.clickCartbutoon();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
		cart.clickProceedtoCheckoutButton();
		Assert.assertTrue(checkoutPay.IsAddressDetailsDisplayed());
		Assert.assertTrue(checkoutPay.IsReviewOrderDisplayed());
		checkoutPay.checkoutComment("Comments for Product");
		checkoutPay.clickPlaceOrder();
		checkoutPay.fillPaymentInfo("Rajesh","1234567891234567",567, "11", "2027");
		checkoutPay.clickConfirmationButton();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().back();
	    Assert.assertTrue(checkoutPay.ISsuccessMsgDisplayed());
	    System.out.println(checkoutPay.orderPlacedSuccessMsg().getText());
	    driver.navigate().to("https://automationexercise.com/payment_done/0");
		Assert.assertEquals(checkoutPay.SuccessMsg().getText(), "Congratulations! Your order has been confirmed!");
		System.out.println(checkoutPay.SuccessMsg().getText());
		checkoutPay.clickPaymentPageContinueButton();
		homePage.clickDeleteAccountButton();
		WebElement Accountdelete = homePage.AccountDelete();
		System.out.println(Accountdelete.getText());
		Assert.assertTrue(homePage.isAccountDeletedVisible());
		homePage.ContinueButton();
		
	}
	
}
