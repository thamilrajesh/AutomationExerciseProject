package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@href='/contact_us']")
	WebElement ContactUsButton;
	@FindBy(xpath = "//h2[text()='Get In Touch']")
	WebElement GetInTouch;
	@FindBy(xpath = "//input[@data-qa='name']")
	WebElement contactUsFormName;
	@FindBy(xpath = "//input[@data-qa='email']")
	WebElement contactUsFormEmail;
	@FindBy(xpath = "//input[@data-qa='subject']")
	WebElement contactUsFormSubject;
	@FindBy(css = "#message")
	WebElement contactUsFormMessage;
	@FindBy(xpath = "//input[@name='upload_file']")
	WebElement contactUsFormUploadFile;
	@FindBy(xpath = "//input[@data-qa='submit-button']")
	WebElement contactUsSubmitButton;
	@FindBy(xpath = "//div[@class='status alert alert-success']")
	WebElement contactUsAlertSuccessMessage;
	@FindBy(xpath = "//a[@class='btn btn-success']")
	WebElement contactUsHomeButton;
	
	public ContactUs(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	public void clickContactUsButton() {
		ContactUsButton.click();
	}
	public boolean isGetInTouchVisible() {
		return GetInTouch.isDisplayed();
	}
	public void ContactUsForm(String name, String email,String sub, String msg, String file){
		contactUsFormName.sendKeys(name);
		contactUsFormEmail.sendKeys(email);
		contactUsFormSubject.sendKeys(sub);
		contactUsFormMessage.sendKeys(msg);
		contactUsFormUploadFile.sendKeys(file);
		contactUsSubmitButton.click();
		driver.switchTo().alert().accept();		
	}
	public WebElement SuccessMsg(){
		return contactUsAlertSuccessMessage;
	}
	
	public void clickHomeButton() {
		contactUsHomeButton.click();
	}
	
  }


