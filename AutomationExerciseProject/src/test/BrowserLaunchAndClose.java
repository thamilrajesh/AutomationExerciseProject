package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BrowserLaunchAndClose {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thamil\\Desktop\\Selenium\\Jars\\chromedriver-win64\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\Thamil\\Desktop\\Selenium\\Jars\\ohahllgiabjaoigichmmfljhkcfikeof-3.8.21-Crx4Chrome.com.crx")); 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://automationexercise.com");
	}

	@AfterTest
	public void closebrowser() {
	      driver.quit();
	}
}
