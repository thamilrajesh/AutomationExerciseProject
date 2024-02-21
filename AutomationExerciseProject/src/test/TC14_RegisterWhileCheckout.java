package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutAndPaymentPage;
import pages.HomePage;
import pages.ProductPage;

public class TC14_RegisterWhileCheckout extends BrowserLaunchAndClose{
	
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
    public void verifyPlaceOrder() {
	product.AddProduct();
	product.ContinueShoppingButton();
	cart.clickCartbutoon();
	Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart");
	cart.clickProceedtoCheckoutButton();
	cart.clickRegisterLoginButton();
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
    cart.clickCartbutoon();
    cart.clickProceedtoCheckoutButton();
    Assert.assertTrue(checkoutPay.IsAddressDetailsDisplayed());
    Assert.assertTrue(checkoutPay.IsAddressInvoiceDisplayed());
    Assert.assertTrue(checkoutPay.IsReviewOrderDisplayed());
    checkoutPay.checkoutComment("Comments for Product");
    checkoutPay.clickPlaceOrder();
    checkoutPay.fillPaymentInfo("Rajesh","1234567891234567",567, "11", "2027");
    checkoutPay.clickConfirmationButton();
    driver.navigate().back();
    Assert.assertTrue(checkoutPay.ISsuccessMsgDisplayed());
    System.out.println(checkoutPay.orderPlacedSuccessMsg().getText());
    driver.navigate().to("https://automationexercise.com/payment_done/0");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    Assert.assertEquals(checkoutPay.SuccessMsg().getText(), "Congratulations! Your order has been confirmed!");
    System.out.println(checkoutPay.SuccessMsg().getText());
    checkoutPay.clickPaymentPageContinueButton();
    homePage.clickDeleteAccountButton();
    System.out.println(homePage.AccountDelete().getText());
    Assert.assertTrue(homePage.isAccountDeletedVisible());
    homePage.ContinueButton();
	}

}
