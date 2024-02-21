package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TC1_RegisterUser extends BrowserLaunchAndClose {
	 
	 HomePage homePage; 	
		    	      
	    @Test(priority = 1)
	    public void verifyHomePage() {
	       homePage = new HomePage(driver);	
	       Assert.assertTrue(homePage.isHomePageVisible());
	    }
	    
	    @Test(priority = 2)
	    public void signUp() {
	    	homePage.clickSignUpLoginButton();
	        Assert.assertTrue(homePage.isNewUserSignupVisible());
	        homePage.signUp("Thamil","thamilgowtham@gmail.com");
	        Assert.assertTrue(homePage.isEnterAccountInformationVisible());
	        homePage.fillAccountInfo("India123","20","January","1990");
	        homePage.selectNewsletterCheckbox();
	        homePage.receivespecialofferCheckbox();
	        homePage.fillAddressInfo("Thamil","Arasi","ABC","Nethaji strt","Main Road", "India","Tamilnadu","Chennai",625016,234876923);
	        homePage.clickcreateaccountbutton();
	        Assert.assertTrue(homePage.isAccountCreatedVisible());
	        homePage.clickContinueButton();
	        WebElement loggedinuser = homePage.loggeduser();
	        System.out.println("Loggedin User: "+loggedinuser.getText());
	        Assert.assertTrue(homePage.isLoggedInAsUserVisible());
	        homePage.clickDeleteAccountButton();
	        WebElement Accountdelete = homePage.AccountDelete();
	        System.out.println(Accountdelete.getText());
	        Assert.assertTrue(homePage.isAccountDeletedVisible());
	        homePage.ContinueButton();
	    }
	    
	}