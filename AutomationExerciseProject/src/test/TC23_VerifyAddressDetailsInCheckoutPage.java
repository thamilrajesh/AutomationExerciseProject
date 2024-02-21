package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutAndPaymentPage;
import pages.HomePage;
import pages.ProductPage;

public class TC23_VerifyAddressDetailsInCheckoutPage extends BrowserLaunchAndClose {
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
	    System.out.println(checkoutPay.addressDetailsInfo().getText());
	    Assert.assertEquals(checkoutPay.addressDetailsInfo().getText(),"YOUR DELIVERY ADDRESS\n"+
                "Mr. Rajesh S\n"+
                "ABC\n"+
                "Nethaji strt\n"+
                "Main Road\n"+
                "Chennai Tamilnadu 625016\n"+
                "India\n"+
                "237876923");
	    Assert.assertEquals(checkoutPay.billingAddress().getText(),"YOUR BILLING ADDRESS\n"+
                "Mr. Rajesh S\n"+
                "ABC\n"+
                "Nethaji strt\n"+
                "Main Road\n"+
                "Chennai Tamilnadu 625016\n"+
                "India\n"+
                "237876923");
	    System.out.println(checkoutPay.billingAddress().getText());
	    homePage.clickDeleteAccountButton();
	    System.out.println(homePage.AccountDelete().getText());
	    Assert.assertTrue(homePage.isAccountDeletedVisible());
	}
}
