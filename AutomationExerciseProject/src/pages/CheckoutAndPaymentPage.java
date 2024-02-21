package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutAndPaymentPage {
	
	WebDriver driver;
	
	    @FindBy(xpath = "//textarea[@class='form-control']")
	    WebElement checkoutPageCommentTextArea;
	    @FindBy(xpath = "//a[@href='/payment']")
	    WebElement checkoutPagePlaceOrder;
	    @FindBy(xpath = "//button[@class='disabled']")
	    WebElement PaymentFormVerification;
	    @FindBy(id = "address_delivery")
	    WebElement AddressDetails;
	    @FindBy(id = "address_invoice")
	    WebElement AddressInvoice;
	    @FindBy(id = "cart_info")
	    WebElement ReviewOrder;
	    @FindBy(xpath = "//input[@name='name_on_card']")
	    WebElement NameOnCard;
	    @FindBy(xpath = "//input[@name='card_number']")
	    WebElement CardNumber;
	    @FindBy(xpath = "//input[@name='cvc']")
	    WebElement CvcNumber;
	    @FindBy(xpath = "//input[@name='expiry_month']")
	    WebElement ExpirationMonth;
	    @FindBy(xpath = "//input[@name='expiry_year']")
	    WebElement ExpirationYear;
	    @FindBy(xpath = "//button[@id='submit']")
	    WebElement PayAndConfirmOrderButton;
	    @FindBy(xpath = "//p[@style='font-size: 20px; font-family: garamond;']")
	    WebElement paymentDonePageSuccessMessageText;
	    @FindBy(xpath = "//a[@data-qa='continue-button']")
	    WebElement paymentDonePageContinueButton;
	    @FindBy(xpath = "//div[contains(text(),'Your order has been placed successfully!')]")
	    WebElement orderSuccessMsg;
	    @FindBy(id = "success_message")
	    WebElement SuccessMsg;
	    @FindBy(css = "a[class='btn btn-default check_out']")
        WebElement downloadInvoiceButton;
	    
	    public CheckoutAndPaymentPage(WebDriver driver) {
	    	this.driver= driver;
	    	PageFactory.initElements(driver, this);
	    }
        public void checkoutComment(String comment) {
        	checkoutPageCommentTextArea.sendKeys(comment);
        }
        public void clickPlaceOrder() {
        	checkoutPagePlaceOrder.click();
        }
        public void fillPaymentInfo(String name, String cardnumber, int cvcnumber, String month, String year) {
        	NameOnCard.sendKeys(name);
        	CardNumber.sendKeys(cardnumber);
        	CvcNumber.sendKeys(String.valueOf(cvcnumber));
        	ExpirationMonth.sendKeys(month);
        	ExpirationYear.sendKeys(year);
         }
        public void clickConfirmationButton() {
        	PayAndConfirmOrderButton.click();
        }
        public WebElement SuccessMsg() {
        	return paymentDonePageSuccessMessageText;
        }
        public WebElement OrderSuccessMsg() {
        	return orderSuccessMsg;
        }
        public void clickPaymentPageContinueButton() {
        	paymentDonePageContinueButton.click();
        }
        public WebElement addressDetailsInfo() {
        	return AddressDetails;
        }
        public boolean IsAddressDetailsDisplayed() {
        	return AddressDetails.isDisplayed();
        }
        public boolean IsAddressInvoiceDisplayed() {
        	return AddressInvoice.isDisplayed();
        }
        public WebElement billingAddress() {
        	return AddressInvoice;
        }
        public boolean IsReviewOrderDisplayed() {
        	return ReviewOrder.isDisplayed();
        }
        public boolean ISsuccessMsgDisplayed() {
        	return SuccessMsg.isDisplayed();
        }
        public WebElement orderPlacedSuccessMsg() {
        	return SuccessMsg;
        }
        public void clickDownloadInvoice()
        {
        	downloadInvoiceButton.click();
        }
        public boolean isFileDownloaded(String downloadPath, String fileName) {
        	 File file = new File(downloadPath + fileName);
             return file.exists();
        }
}
