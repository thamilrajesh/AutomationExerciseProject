package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginAndLogoutPage;

public class TC2_3_4_5_LoginAndLogoutFunction extends BrowserLaunchAndClose {
	HomePage homePage;
	LoginAndLogoutPage lp;
	
		    	      
	    @Test(priority = 1)
	    public void InvalidLogin() {
	    	homePage = new HomePage(driver);
	    	lp = new LoginAndLogoutPage(driver);
	        Assert.assertTrue(homePage.isHomePageVisible());
	    	homePage.clickSignUpLoginButton();
	    	Assert.assertTrue(lp.LogintoYouraccount());
	    	lp.LoginHomepage("123d@gmail.com","dfdgl");
	    	Assert.assertTrue(lp.isErrormsgVisible());
	        WebElement emsg = lp.ErrorLogin();
	        System.out.println(emsg.getText());
	    }
	    
	    @Test(priority = 2)
	    public void Logout() {
	    	homePage.clickSignUpLoginButton();
	    	Assert.assertTrue(lp.LogintoYouraccount());
	    	lp.LoginHomepage("thamilgowtham@gmail.com", "India123");
	    	Assert.assertTrue(homePage.isLoggedInAsUserVisible());
	    	WebElement loggedinuser = homePage.loggeduser();
	        System.out.println("Loggedin User: "+loggedinuser.getText());
	        lp.Logout();
	    }

	    @Test(priority = 3)
	    public void AlreadyExistedEmail() {
	    	homePage.clickSignUpLoginButton();
	    	Assert.assertTrue(homePage.isNewUserSignupVisible());
	        homePage.signUp("Thamil","thamilgowtham@gmail.com");
	        WebElement emailalreadyexisted = lp.EmailAddressAlreadyExist();
	        System.out.println(emailalreadyexisted.getText());
	    }
	    
	    @Test(priority = 4)
	    public void validLogin() {
	    	homePage.clickSignUpLoginButton();
	    	Assert.assertTrue(lp.LogintoYouraccount());
	    	lp.LoginHomepage("thamilgowtham@gmail.com", "India123");
	    	Assert.assertTrue(homePage.isLoggedInAsUserVisible());
	    	WebElement loggedinuser = homePage.loggeduser();
	        System.out.println("Loggedin User: "+loggedinuser.getText());
	        homePage.clickDeleteAccountButton();
	        WebElement Accountdelete = homePage.AccountDelete();
	        System.out.println(Accountdelete.getText());
	        Assert.assertTrue(homePage.isAccountDeletedVisible());
	    }
	 
}
