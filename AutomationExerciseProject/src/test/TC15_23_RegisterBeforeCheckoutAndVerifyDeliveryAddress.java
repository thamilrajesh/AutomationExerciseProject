package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutAndPaymentPage;
import pages.HomePage;
import pages.ProductPage;

public class TC15_23_RegisterBeforeCheckoutAndVerifyDeliveryAddress extends BrowserLaunchAndClose {
	HomePage homePage;
	CartPage cart;
	ProductPage product;
	CheckoutAndPaymentPage checkoutPay;
	
	@Test(priority = 1)
    public void verifyHomePage() {
	 homePage = new HomePage(driver);
	 cart = new CartPage(driver);
	 product = new ProductPage(driver);
	 checkoutPay = new CheckoutAndPaymentPage(driver);
	 Assert.assertTrue(homePage.isHomePageVisible());
	}
	@Test(priority = 2)
    public void verifydeliveryAddressincheckoutPage() {
		homePage.clickSignUpLoginButton();
		homePage.signUp("Rajesh","rajesh@gmail.com");
		homePage.fillAccountInfo("India123","20","January","1990");
	    homePage.selectNewsletterCheckbox();
	    homePage.receivespecialofferCheckbox();
	    homePage.fillAddressInfo("Rajesh","S","ABC","Nethaji strt","Main Road", "India","Tamilnadu","Chennai",625016,237876923);
	    homePage.clickcreateaccountbutton();
	    homePage.clickContinueButton();
	    WebElement loggedinuser = homePage.loggeduser();
	    System.out.println("Loggedin User: "+loggedinuser.getText());
	    Assert.assertTrue(homePage.isLoggedInAsUserVisible());
	    product.AddProduct();
		product.ContinueShoppingButton();
		cart.clickCartbutoon();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
	    cart.clickProceedtoCheckoutButton();
	    Assert.assertTrue(checkoutPay.IsAddressDetailsDisplayed());
	    String RegisteredDeliveryAddress = "YOUR DELIVERY ADDRESS\n"+
                "Mr. Rajesh S\n"+
                "ABC\n"+
                "Nethaji strt\n"+
                "Main Road\n"+
                "Chennai Tamilnadu 625016\n"+
                "India\n"+
                "237876923";
	    Assert.assertEquals(checkoutPay.addressDetailsInfo().getText(),RegisteredDeliveryAddress);
	    System.out.println(checkoutPay.addressDetailsInfo().getText());
	    String RegisteredBillingAddress = "YOUR BILLING ADDRESS\n"+
                "Mr. Rajesh S\n"+
                "ABC\n"+
                "Nethaji strt\n"+
                "Main Road\n"+
                "Chennai Tamilnadu 625016\n"+
                "India\n"+
                "237876923";
	    Assert.assertEquals(checkoutPay.billingAddress().getText(),RegisteredBillingAddress);
	    System.out.println(checkoutPay.billingAddress().getText());
	 }
	@Test(priority = 3)
    public void verifyPlaceOrderAfterRegister() {
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
	}
	@Test(priority = 4)
    public void verifyAccountDeleted() {
		homePage.clickDeleteAccountButton();
		System.out.println(homePage.AccountDelete().getText());
	    Assert.assertTrue(homePage.isAccountDeletedVisible());
	    homePage.ContinueButton();
	}

}
