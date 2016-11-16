package webautomation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EditEvent 

{ 
	
	private WebDriver driver=null;
	
	private Properties prop = new Properties();

    @BeforeTest 
	public void Setup() throws IOException 
    {
		
    	InputStream inputStream = LoginSuccess.class.getResourceAsStream("metadata.properties");

		//FileInputStream filepath = new FileInputStream("E:\\Unation Automation\\UnationWebAutomation\\src\\test\\resources\\metadata.properties");
		//FileInputStream filepath = new FileInputStream(inputStream);

		prop.load(inputStream);
		
		if (prop.getProperty("browser").equals("firefox")) 
		
		{
//			System.setProperty("webdriver.gecko.driver", "E:\\Downloads\\geckodriver-v0.10.0-win64\\geckodriver.exe");
//			driver =new FirefoxDriver();
			ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();

		}

		else if (prop.getProperty("browser").equals("chrome")) 
		{
			//System.setProperty("webdriver.chrome.driver", "E:\\Downloads\\ChromeDriver\\chromedriver.exe");
			ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
		  	
		}
		
		else  
		{
			 driver=new InternetExplorerDriver();
		}
		
    }





@Test
public void EditwithLogin()

{
	//opening the web url
	driver.get(prop.getProperty("base_url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	System.out.print("Welcome to Unation");
	//WebElement myDynamicElement = (new WebDriverWait(driver, 20))
	     //.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn.btn-default.default-button.mth.phh")));
	   //driver.findElement(By.cssSelector(".btn.btn-default.default-button.mth.phh")).click();

	//Sign in
	driver.findElement(By.cssSelector(".btn.btn-links.a-hover.ng-isolate-scope")).click();
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.findElement(By.name("email")).sendKeys(prop.getProperty("Delemail"));
    driver.findElement(By.name("password")).sendKeys(prop.getProperty("Delpass"));
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector(".btn.btn-default")).click();
    System.out.print("\n Login Successfully");

    
    //click on my events
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.linkText("MY EVENTS")).click();
    
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector(".event-theme")).click();
    
    //Click on edit events
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector(".btn-edit.edit-event.ng-scope")).click();

    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    WebElement myDynamicElement = (new WebDriverWait(driver, 60))
   	.until(ExpectedConditions.presenceOfElementLocated(By.id("title-box")));
    
    driver.findElement(By.id("title-box")).click();
    WebElement toClear = driver.findElement(By.id("title-box"));
    toClear.sendKeys(Keys.CONTROL + "a");
//    toClear.sendKeys(Keys.DELETE);
//    
    //driver.findElement(By.id("title-box")).clear();
    driver.findElement(By.id("title-box")).sendKeys(prop.getProperty("Title"));
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	  driver.findElement(By.cssSelector(".button-publish-and-cancel button[type='submit']")).click();
//    driver.findElement(By.cssSelector("textarea[name=\"description\"]")).clear();
//    driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys("Test");
//    driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
//   
//    	try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//   
//
//    // ERROR: Caught exception [ERROR: Unsupported command [getAllButtons |  | ]]
//    driver.findElement(By.xpath("//a[contains(text(),'21+')]")).click();
//    
//    	try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    
//
//    driver.findElement(By.xpath("(//a[contains(@href, '')])[50]")).click();
//    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
//    
//    
//    
//    
//    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//    driver.findElement(By.cssSelector(".button-publish-and-cancel button[type='submit']")).click();
    System.out.print("\n Event has been edited");
    
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.name("start_date")).click();
//
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.xpath("(//button[@type='button'])[23]")).click();
//    
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.name("startHour")).clear();
//    driver.findElement(By.name("startHour")).sendKeys("7");
//    
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.className(".btn.btn-default.dropdown-toggle")).click();
//    driver.findElement(By.linkText("AM")).click();
//
//
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
//    driver.findElement(By.linkText("Central")).click();
//    
//    
//    
//    
//    
////    WebElement element = driver.findElement(By.id("title-box"));
////    JavascriptExecutor executor = (JavascriptExecutor)driver;
////    executor.executeScript("arguments[0].click();", element);
////    driver.findElement(By.id("title-box")).clear();
//    
////    driver.findElement(By.cssSelector(".form-control ng-pristine ng-untouched ng-valid-maxlength ng-valid ng-valid-required")).sendKeys("Test");
////    
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.name("start_date")).click();
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.xpath("(//button[@type='button'])[23]")).click();
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.name("startHour")).sendKeys("7");
//    
    
//    
//	   driver.findElement(By.id("sign_in_click")).click();
//	  //driver.get("https://qa-web.unation.com/join/set-account");
//	  //driver.findElement(By.xpath("html/body/div[2]/section/p[1]/a"));
//	  
//	   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	   //first_element = driver.find_elements(:css, 'div.question-summary')[0]
//	   driver.findElement(By.cssSelector(".join-section a")).click();
	   
}
//@AfterTest
//public void tearDown() throws Exception {
//	driver.close();
//	driver = null;
//}
	
}

