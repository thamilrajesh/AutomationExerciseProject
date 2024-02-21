package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	
	    @FindBy(xpath = "(//a[@href='/view_cart'])[1]")
	    WebElement mainPageCartButton;
	    @FindBy(xpath = "//h2[text()='Subscription']")
	    WebElement cartPageSubscriptionText;
	    @FindBy(xpath = "//input[@id='susbscribe_email']")
	    WebElement cartPageSubscriptionEmail;
	    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
	    WebElement cartPageSubscriptionArrowButton;
	    @FindBy(xpath = "//div[@class='alert-success alert']")
	    WebElement cartPageSubscriptionSuccessAlert;
	    @FindBy(xpath = "//button[@class='disabled']")
	    WebElement cartPageQuantity;
	    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
	    WebElement cartPageProceedToCheckOutButton;
	    @FindBy(xpath = "//u[text()='Register / Login']")
	    WebElement popUpRegisterLoginButton;
	    @FindBy(xpath = "/html/body/section/div/div[2]/table/tbody/tr/td[6]/a/i")
	    WebElement xRemoveButton1;
	    @FindBy(css = "a[href='/product_details/1']")
	    WebElement cartPageProduct1;
	    @FindBy(id = "empty_cart")
	    WebElement emptycart;
	    @FindBy(css = "a[href='#reviews']")
	    WebElement ReviewForm;
	    @FindBy(css = "#name")
	    WebElement ReviewName;
	    @FindBy(css = "#email")
	    WebElement ReviewEmail;
	    @FindBy(css = "#review")
	    WebElement ReviewMessage;
	    @FindBy(css = "#button-review")
	    WebElement ReviewSubmitButton;
	    @FindBy(css = "div[class='alert-success alert'] span")
	    WebElement ReviewSuccessAlert;
	    @FindBy(xpath = "//td[@class='cart_description']/h4/a")
	    List<WebElement> cartInProducts;
	    @FindBy(id = "cart_info_table")
	    WebElement cartInProductDetails;
	    
	     
	    public CartPage(WebDriver driver) {
	    	this.driver= driver;
	    	PageFactory.initElements(driver, this);
	    }
	    public void clickCartbutoon()
	    {
	    	mainPageCartButton.click();
	    }
	    public boolean isSubscriptionVisible() {
	    	  return cartPageSubscriptionText.isDisplayed();
	      }
	   public boolean IsSubscriptionSuccessMsgDisplayed() {
	    	  return cartPageSubscriptionSuccessAlert.isDisplayed();
	      }
	   public void cartSubscription(String cartEmail) {
	    	cartPageSubscriptionEmail.sendKeys("latha@gmail.com");
	    	cartPageSubscriptionArrowButton.click();
	   }
	   public WebElement productQuantityInCart() {
		   return cartPageQuantity;
	   }
	   public void clickProceedtoCheckoutButton() {
		   cartPageProceedToCheckOutButton.click();
	   }
	   public void clickRegisterLoginButton() {
		   popUpRegisterLoginButton.click();
	   }
	   public void clickXremoveButton() {
		   xRemoveButton1.click();
	   }
	   public WebElement XButton() {
			  return xRemoveButton1;
	   }
	   public WebElement RemovedProductName() {
			  return cartPageProduct1;
	   }
	   public WebElement IsemptyCartMsg() {
	    	  return emptycart;
	   }
	   public boolean isWriteyourReviewVisible() {
       	return ReviewForm.isDisplayed();
       }
       public WebElement writeyourReviewElement() {
       	return ReviewForm;
       }
       public void writeAndSubmitReview(String name, String email, String reviewmsg) {
       	ReviewName.sendKeys(name);
       	ReviewEmail.sendKeys(email);
       	ReviewMessage.sendKeys(reviewmsg);
       	ReviewSubmitButton.click();
       }
       public boolean isReviewSuccessMsgVisible() {
          	return ReviewSuccessAlert.isDisplayed();
          }
       public WebElement ReviewSuccessMsg() {
          	return ReviewSuccessAlert;
          }
       public List<WebElement> productDetailsInCart(){
    	   return cartInProducts;
       }
       public WebElement productDetailInCart(){
    	   return cartInProductDetails;
       }
       public boolean IsproductDetailsInCartDisplayed(){
    	   return cartInProductDetails.isDisplayed();
       }
}
