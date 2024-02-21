package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUs;
import pages.HomePage;

public class TC6_ContactUsForm extends BrowserLaunchAndClose {
	
	HomePage homePage;
	ContactUs contact;
	
	  @Test(priority = 1)
	    public void CheckContactUsForm() {
		  homePage = new HomePage(driver);	
	      contact = new ContactUs(driver);
	      Assert.assertTrue(homePage.isHomePageVisible());
		  contact.clickContactUsButton();
		  Assert.assertTrue(contact.isGetInTouchVisible());
		  contact.ContactUsForm("Latha","latha@gmail.com","Issue with Cart","Not able to add the product to the cart","C:\\Users\\Thamil\\Desktop\\Manual and Selinium Testing\\Selenium Testing Assignments\\image1.jpg");
		  WebElement successmsg = contact.SuccessMsg();
	      String actualmsg = successmsg.getText();
	      String expectedmsg = "Success! Your details have been submitted successfully.";
	      Assert.assertEquals(actualmsg,expectedmsg);
	      contact.clickHomeButton();
	      Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
	    }
	
}
