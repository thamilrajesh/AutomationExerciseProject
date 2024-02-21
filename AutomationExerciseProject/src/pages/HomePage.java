package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
	
WebDriver driver;
	 
     @FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
     WebElement HomePagevisible ;
     @FindBy(css = "h2[data-qa='account-created']")
     WebElement accountCreatedbutton;
     @FindBy(css = "a[data-qa='continue-button']")
     WebElement continueButton;
     @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
     WebElement signUpLoginButton;
     @FindBy(css = "div[class='signup-form'] h2")
     WebElement newUserSignup;
     @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
     WebElement loggedInAsUser;
     @FindBy(xpath = "/html/body/section/div/div/div/h2/b")
     WebElement accountDeleted;
     @FindBy(xpath = "/html/body/section/div/div/div/div/h2/b")
     WebElement enterAccountInformation;
     @FindBy(xpath = "/html/body/section/div/div/div/h2/b")
     WebElement accountCreated;
     @FindBy(css = "input[data-qa='signup-name']")
     WebElement loginname;
     @FindBy(css = "input[data-qa='signup-email']")
     WebElement loginemail;
     @FindBy(css = "button[data-qa='signup-button']")
     WebElement signupbutton;
     @FindBy(id = "id_gender1")
     WebElement titleCheckbox1;
     @FindBy(id = "id_gender2")
     WebElement titleCheckbox2;
     @FindBy(id = "password")
     WebElement passwordInput;
     @FindBy(id = "days")
     WebElement daysSelect;
     @FindBy(id = "months")
     WebElement monthsSelect;
     @FindBy(id = "years")
     WebElement yearsSelect;
     @FindBy(id = "newsletter")
     WebElement newsletterCheckbox;
     @FindBy(id = "optin")
     WebElement specialOffersCheckbox;
     @FindBy(id = "first_name")
     WebElement firstNameInput;
     @FindBy(id = "last_name")
     WebElement lastNameInput;
     @FindBy(id = "company")
      WebElement companyInput;
     @FindBy(id = "address1")
     WebElement address1Input;
     @FindBy(id = "address2")
      WebElement address2Input;
     @FindBy(id = "country")
      WebElement countrySelect;
     @FindBy(id = "state")
      WebElement stateInput;
     @FindBy(id = "city")
      WebElement cityInput;
     @FindBy(id = "zipcode")
      WebElement zipcodeInput;
     @FindBy(id = "mobile_number")
      WebElement mobileNumberInput;
     @FindBy(css = "button[data-qa='create-account']")
      WebElement createAccountButton;
     @FindBy(xpath = "//header/div/div/div/div[2]/div/ul/li[5]/a")
      WebElement accountDeletebutton;
     @FindBy(xpath = "//button[text()='Test Cases']")
     WebElement TestCaseButton;
     @FindBy(css = "div[class='single-widget'] h2")
     WebElement mainPageSubscriptionText;
     @FindBy(xpath = "//input[@id='susbscribe_email']")
     WebElement mainPageSubscriptionEmail;
     @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
     WebElement mainPageSubscriptionArrowButton;
     @FindBy(xpath = "//div[@class='alert-success alert']")
     WebElement mainPageSubscriptionSuccessAlert;
     @FindBy(xpath = "//h2[text()='recommended items']")
     WebElement recommendedItems;
     @FindBy(xpath = "//a[@class='btn btn-default add-to-cart']")
     WebElement RecommendedAddtoCart;
     @FindBy(xpath = "//i[@class='fa fa-angle-up']")
     WebElement mainPageArrowUpto;
     @FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
     WebElement fullfledged;
          
     public HomePage(WebDriver driver) {
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }
         
     public boolean isHomePageVisible() {
         return HomePagevisible.isDisplayed(); 
     }
     public void clickSignUpLoginButton() {
         signUpLoginButton.click();
     }
                  
     public boolean isNewUserSignupVisible() {
         return newUserSignup.isDisplayed(); 
     }
     public void signUp(String name, String email) {
    	 loginname.sendKeys(name);
    	 loginemail.sendKeys(email);
    	 signupbutton.click();
       }
     
     public void selectNewsletterCheckbox() {
         newsletterCheckbox.click();
     }
     
     public void receivespecialofferCheckbox() {
         newsletterCheckbox.click();
     }
     
     public boolean isEnterAccountInformationVisible() {
    	 return enterAccountInformation.isDisplayed();
     }
     
     public void fillAccountInfo(String password,String day, String month, String year) {
    	 titleCheckbox1.click();
    	 passwordInput.sendKeys(password);
         Select days = new Select(daysSelect);
         days.selectByValue(day);
         Select months = new Select(monthsSelect);
         months.selectByVisibleText(month);
         Select years = new Select(yearsSelect);
         years.selectByValue(year);
         newsletterCheckbox.click();
         specialOffersCheckbox.click();
      }
      
      public void fillAddressInfo(String fname,String lname, String comp, String addres, String addres2, String country, String state, String city, int zip, int mobile ) {
       firstNameInput.sendKeys(fname);
       lastNameInput.sendKeys(lname);
       companyInput.sendKeys(comp);
       address1Input.sendKeys(addres);
       address2Input.sendKeys(addres2);
       Select countrybox = new Select(countrySelect);
       countrybox.selectByValue(country);
       stateInput.sendKeys(state);
       cityInput.sendKeys(city);
       zipcodeInput.sendKeys(String.valueOf(zip));
       mobileNumberInput.sendKeys(String.valueOf(mobile));
       }
      public void clickcreateaccountbutton() {
    	  createAccountButton.click();
    	  System.out.println(accountCreated.getText());
      } 
      public boolean isAccountCreatedVisible() {
         return accountCreated.isDisplayed();
      }
      public void clickContinueButton() {
    	 continueButton.click();
      }
      public void ContinueButton() {
     	 continueButton.click();
      }
      public WebElement loggeduser() {
    	  return loggedInAsUser;
      }
      public boolean isLoggedInAsUserVisible() {
         return loggedInAsUser.isDisplayed();
      }
      public void clickDeleteAccountButton() {
          accountDeletebutton.click();
      }
      public WebElement AccountDelete() {
    	  return accountDeleted;
      }
      public boolean isAccountDeletedVisible() {
          return accountDeleted.isDisplayed(); 
      }
      public void clickTestCaseButton() {
          TestCaseButton.click();
      }
      public WebElement TestCaseButton() {
          return TestCaseButton;
      }
      public boolean isSubscriptionVisible() {
    	  return mainPageSubscriptionText.isDisplayed();
      }
      public WebElement SubscriptionText() {
    	  return mainPageSubscriptionText;
      }
      public boolean IsSubscriptionSuccessMsgDisplayed() {
    	  return mainPageSubscriptionSuccessAlert.isDisplayed();
      }
      public WebElement SubscriptionSuccessMsg() {
    	  return mainPageSubscriptionSuccessAlert;
      }
      public void subscriptionDetails(String emailid) {
    	  mainPageSubscriptionEmail.sendKeys(emailid);
    	  mainPageSubscriptionArrowButton.click();
      }
      public boolean isRecommendedItemsVisible() {
    	  return recommendedItems.isDisplayed();
      }
      public WebElement RecommededItemTitle() {
    	  return recommendedItems;
      }
      public void clickRecommendedAddToCart() {
    	  RecommendedAddtoCart.click();
      }
      public void clickArrowUpButton() {
    	  mainPageArrowUpto.click();
      }
      public boolean isFullfledgedTextVisible() {
    	  return fullfledged.isDisplayed();
      }
      public WebElement FullfledgedText() {
    	  return fullfledged;
      }
 }
