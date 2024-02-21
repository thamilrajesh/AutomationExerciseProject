package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAndLogoutPage {
	
	WebDriver driver;
	
	    @FindBy(css = "div[class='login-form'] h2")
	    WebElement loginToYourAccount;

	    @FindBy(css = "input[data-qa='login-email']")
	     WebElement loginEmailInput;

	    @FindBy(css = "input[data-qa='login-password']")
	    WebElement loginPasswordInput;

	    @FindBy(css = "button[data-qa='login-button']")
	    WebElement loginButton;
	    
	    @FindBy(xpath = "/html/body/section/div/div/div[1]/div/form/p")
	    WebElement errorLogin;
	    
	    @FindBy(xpath = "//section/div/div/div[3]/div/form/p")
	    WebElement emailAddressAlreadyExist;
	    
	   @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
	    WebElement lusername;

	    @FindBy(xpath = "//header/div/div/div/div[2]/div/ul/li[5]/a")
	    WebElement deleteAccountButton;

	   @FindBy(xpath = "//a[@href='/logout']")
	    WebElement logoutButton;
	
	  public LoginAndLogoutPage(WebDriver driver) {
	         this.driver = driver;
	         PageFactory.initElements(driver, this);
	     }
     
	  public boolean LogintoYouraccount() {
	        return loginToYourAccount.isDisplayed();
	    }
	  public void LoginHomepage(String email, String password) {
	        loginEmailInput.sendKeys(email);
	        loginPasswordInput.sendKeys(password);
	        loginButton.click();
	    }
	  public void Logout() {
		   logoutButton.click();
	  }
	  public boolean isErrormsgVisible(){
		 return errorLogin.isDisplayed(); 
	  }
	  public WebElement ErrorLogin() {
	        return errorLogin;
	    }
	  public WebElement EmailAddressAlreadyExist() {
	        return emailAddressAlreadyExist;
	    }
	  
	  
}
