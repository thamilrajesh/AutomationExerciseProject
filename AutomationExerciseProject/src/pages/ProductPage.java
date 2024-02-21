package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	
	WebDriver driver;
	    
	    @FindBy(xpath = "//a[@href='/products']")
        WebElement ProductsButton;
	    @FindBy(xpath = "//a[@href='/product_details/1']")
        WebElement firstProduct;
	    @FindBy(id = "search_product")
	    WebElement productPageSearchPanel;
	    @FindBy(id = "submit_search")
	    WebElement submitsearchbutton;
	    @FindBy(xpath = "(//a[@data-product-id='1'])[1]")
	    WebElement productPageAddtoCartFirstItem;
	    @FindBy(xpath = "(//a[@data-product-id='2'])[1]")
	    WebElement productPageAddtoCartSecondItem;
	    @FindBy(css = "h2[class]")
	    WebElement productPageTopTitle;
	    @FindBy(css = ".product-information")
	    WebElement ProductInformationPanel;
	    @FindBy(css = "div[class='product-information'] h2")
	    WebElement ProductName;
	    @FindBy(css = "div[class='product-information'] p:nth-of-type(1)")
	    WebElement ProductCategory;
	    @FindBy(css = "div[class='product-information'] span span")
	    WebElement ProductPrice;
	    @FindBy(css = "div[class='product-information'] p:nth-of-type(2)")
	    WebElement ProductAvalibility;
	    @FindBy(css = "div[class='product-information'] p:nth-of-type(3)")
	    WebElement ProductCondition;
	    @FindBy(css = "div[class='product-information'] p:nth-of-type(4)")
	    WebElement ProductBrand;
	    @FindBy(css = "#quantity")
	    WebElement oneProductPageProductQuantity;
	    @FindBy(xpath = "//a[@href='/product_details/1']")
	    WebElement viewProductButton;
	    @FindBy(xpath = "//button[@type='button']")
	    WebElement AddToCardButton;
	    @FindBy(xpath = "//u[text()='View Cart']")
	    WebElement popUpViewCartButton;
	    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
	    WebElement popUpContinueShoppingButton;
	    @FindBy(xpath = "//a[text()='Blue Top']")
	    WebElement firstproductName;		
	    @FindBy(xpath = "//a[text()='Men Tshirt']")
	    WebElement secondproductName;
	    @FindBy(css = "tr[id='product-1'] td[class='cart_price'] p")
	    WebElement firstProductPrice;
        @FindBy(css = "tr[id='product-1'] button[class='disabled']")
	    WebElement firstProductQuantity;
	    @FindBy(css = "tr[id='product-1'] p[class='cart_total_price']")
	    WebElement firstProductTotal;
	    @FindBy(css = "tr[id='product-2'] td[class='cart_price'] p")
	    WebElement secondProductPrice;
	    @FindBy(css = "tr[id='product-2'] button[class='disabled']")
	    WebElement secondProductQuantity;
	    @FindBy(css = "tr[id='product-2'] p[class='cart_total_price']")
	    WebElement secondProductTotal;
	    @FindBy(css = ".left-sidebar")
	    WebElement CategorySideBar;
	    @FindBy(css = "a[href='#Women']")
	    WebElement CategoryWomen;
	    @FindBy(css = "a[href='/category_products/1']")
	    WebElement WomenSubcategoryDress;
	    @FindBy(css = "a[href='/category_products/2']")
	    WebElement WomenSubcategoryTops;
	    @FindBy(css = "a[href='#Men']")
	    WebElement CategoryMen;
	    @FindBy(css = "a[href='/category_products/3']")
	    WebElement MenSubcategoryTshirts;
	    @FindBy(css = ".title.text-center")
	    WebElement ProductPageCategoryTitle;
	    @FindBy(css = "a[href='/brand_products/Polo']")
	    WebElement PoloBrands;
	    @FindBy(css = "a[href='/brand_products/H&M']")
	    WebElement HMBrands;  
	    @FindBy(className = "brands_products")
	    WebElement BrandsTitle;
	    @FindBy(xpath = "//div[@class='productinfo text-center']")
	    List<WebElement> PoloBrandProducts;
	    @FindBy(xpath = "//div[@class='productinfo text-center']")
	    List<WebElement> HMBrandProducts;
	    
	    
	    public ProductPage(WebDriver driver) {
	    	 this.driver = driver; 
	    	 PageFactory.initElements(driver, this);
	    }
        public void clickProductButton() {
        	ProductsButton.click();
        }
        public void clickViewFirstProduct() {
        	firstProduct.click();
        }
        public boolean isProductDetailsDisplayed() {
        	return ProductName.isDisplayed()&&
        	       ProductPrice.isDisplayed()&&
        	       ProductBrand.isDisplayed()&&
        	       ProductCategory.isDisplayed()&&
        	       ProductAvalibility.isDisplayed()&&
        	       ProductCondition.isDisplayed();
        }
        public void searchProduct(String productname) {
        	productPageSearchPanel.sendKeys(productname);
        	submitsearchbutton.click();
        	
        }
        public WebElement searchedProducts() {
        	return productPageTopTitle;
        }
        public void AddProductsToCart() {
        	productPageAddtoCartFirstItem.click();
        	popUpContinueShoppingButton.click();
        	productPageAddtoCartSecondItem.click();
        	popUpViewCartButton.click();
        }
        public WebElement FirstProduct() {
        	return firstproductName;
        }
        public WebElement SecondProduct() {
        	return secondproductName;
        }
        public String getFirstProductPrice() {
        	return firstProductPrice.getText();
        }
        public String getFirstProductQuantity() {
            return firstProductQuantity.getText();
        }

        public String getFirstProductTotal() {
            return firstProductTotal.getText();
        }

        public String getSecondProductPrice() {
            return secondProductPrice.getText();
        }

        public String getSecondProductQuantity() {
            return secondProductQuantity.getText();
        }

        public String getSecondProductTotal() {
            return secondProductTotal.getText();
        }
        public void ClickViewProductButton() {
        	viewProductButton.click();
        }
        public boolean IsPoductDetailsPageDisplayed() {
        	return ProductInformationPanel.isDisplayed();
        }       
        public void VerifytheProductQuantity(int quantity) {
        	oneProductPageProductQuantity.clear();
        	oneProductPageProductQuantity.sendKeys(String.valueOf(quantity));       	
        	AddToCardButton.click();
        	popUpViewCartButton.click();
        }
        public void AddProduct() {
        	productPageAddtoCartFirstItem.click();
        }
        public void ContinueShoppingButton() {
        	popUpContinueShoppingButton.click();
        }
        public void clickpopupviewCart() {
        	popUpViewCartButton.click();
        }
        public boolean isCategoriesVisible() {
        	return CategorySideBar.isDisplayed();
        }
        public void clickWomenCategory() {
        	CategoryWomen.click();
         }
        public void clickWomenSubCategory()
        {
        	JavascriptExecutor executor = (JavascriptExecutor)driver;
        	executor.executeScript("arguments[0].click();", WomenSubcategoryTops);
        }
        public WebElement WomenSubCategory()
        {
        	return WomenSubcategoryTops;	
        }
        public WebElement ProductPageTitle() {
        	return ProductPageCategoryTitle;
        }
        public boolean isProductPageTitleDisplayed() {
        	return ProductPageCategoryTitle.isDisplayed();
        }
        public void clickMenCategory() {
        	CategoryMen.click();
         }
        public void clickMenSubCategory()
        {
        	Actions actions = new Actions(driver);
        	actions.moveToElement(MenSubcategoryTshirts).click().perform();
        	
        }
        public WebElement MenSubCategory()
        {
        	return MenSubcategoryTshirts;	
        }
        public boolean isBrandsDisplayed() {
        	return BrandsTitle.isDisplayed();
        }
        public WebElement brandsTitle() {
        	return BrandsTitle;
        }
        public WebElement clickPoloBrand() {
        	return PoloBrands;
        }
        public WebElement clickHMBrand() {
        	return HMBrands;
        }
        public List<WebElement> polobrandProducts() {
        	return PoloBrandProducts;
        }
        public List<WebElement> hmbrandProducts() {
        	return HMBrandProducts;
        }
        public boolean isProductDetailsDisplayedInCartPage() {
        	return firstproductName.isDisplayed()&&
        	       firstProductPrice.isDisplayed()&&
        	       firstProductQuantity.isDisplayed()&&
        	       firstProductTotal.isDisplayed();
        }
       
}
