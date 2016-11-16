package webautomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class DeleteEvent 

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
public void DeleteEvent()

{
	//opening the web url
	driver.get(prop.getProperty("base_url"));
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	System.out.print("Welcome to Unation");
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
    driver.findElement(By.linkText("UPCOMING")).click();

    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div[1]/div/div[3]/div/div/div[1]")).click();
    driver.findElement(By.cssSelector(".event-theme")).click();

    //Click on edit events
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector(".btn-edit.edit-event.ng-scope")).click();

    //Delete an event

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//div[13]/div[2]/a")).click();
    driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    WebElement element= driver.findElement(By.cssSelector(".button.btn.btn-default"));

    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", element);
    
    
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    WebElement element1= driver.findElement(By.cssSelector("//div/button[contains(.,'YES')]"));

    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", element1);
    

    
    //Alert confirmationAlert = driver.switchTo().alert();
    //String alertText = confirmationAlert.getText();
    //System.out.println("Alert text is " + alertText);
    //confirmationAlert.accept();
//    driver.findElement(By.cssSelector("p.modal-paragraph.ng-binding")).click();
//    driver.findElement(By.tagName("button")).click();
//    driver.findElement(By.cssSelector(".col-xs-6.mobile-btns")).click();

}

//@AfterTest
//public void tearDown() throws Exception 
//
//{
//	driver.close();
//	driver = null;
//}

}



























//	//WebElement myDynamicElement = (new WebDriverWait(driver, 20))
//	     //.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn.btn-default.default-button.mth.phh")));
//	   //driver.findElement(By.cssSelector(".btn.btn-default.default-button.mth.phh")).click();
//
//	//Sign in

//    driver.findElement(By.cssSelector(".btn.btn-links.a-hover.ng-isolate-scope")).click();
//    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//    driver.findElement(By.name("email")).sendKeys("mariam@westagilelabs.com");
//    driver.findElement(By.name("password")).sendKeys("Asdf12@");
//    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    driver.findElement(By.cssSelector(".btn.btn-default")).click();
//    System.out.print("\n Login Successfully");
//
//
//    //click on my events
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.linkText("MY EVENTS")).click();
//
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
////    driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div[1]/div/div[3]/div/div/div[1]")).click();
//    driver.findElement(By.cssSelector(".event-theme")).click();
//
//    //Click on edit events
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.cssSelector(".btn-edit.edit-event.ng-scope")).click();
//
//    //Delete an event
//
//    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//
//    JavascriptExecutor jse = (JavascriptExecutor) driver;
//    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
////    driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
//    driver.findElement(By.xpath("//div[13]/div[2]/a")).click();
//    driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
//    WebElement element= driver.findElement(By.cssSelector(".button.btn.btn-default"));
//
//    JavascriptExecutor executor = (JavascriptExecutor) driver;
//    executor.executeScript("arguments[0].click();", element);
//    //Alert confirmationAlert = driver.switchTo().alert();
//    //String alertText = confirmationAlert.getText();
//    //System.out.println("Alert text is " + alertText);
//    //confirmationAlert.accept();
////    driver.findElement(By.cssSelector(".flag-event-modal.confirm-modal unation-modal.ng-scope"));
//
//    WebElement element1= driver.findElement(By.cssSelector(".modal-dialog .modal-footer button:nth-child(2)"));
//
//    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
//    executor1.executeScript("arguments[0].click();", element1);
//
//
////
////    driver.findElement(By.cssSelector(".col-xs-6.mobile-btns")).click();
//
////	driver.findElement(By.cssSelector(".btn.btn-links.a-hover.ng-isolate-scope")).click();
////    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
////    driver.findElement(By.name("email")).sendKeys("shzaidi@westagilelabs.com");
////    driver.findElement(By.name("password")).sendKeys("Unation123");
////    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
////    driver.findElement(By.cssSelector(".btn.btn-default")).click();
////    System.out.print("\n Login Successfully");
////
////
////    //click on my events
////    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
////    driver.findElement(By.linkText("MY EVENTS")).click();
////
////    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
////    driver.findElement(By.cssSelector(".event-theme")).click();
////
////    //Click on edit events
////    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
////    driver.findElement(By.cssSelector(".btn-edit.edit-event.ng-scope")).click();
////
////    //Delete an event
////
////    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////
////    JavascriptExecutor jse = (JavascriptExecutor)driver;
////    jse.executeScript("window.scrollBy(0,250)", "");
////    driver.findElement(By.xpath("//div[13]/div[2]/a")).click();
////    driver.findElement(By.cssSelector(".btn.btn-default")).click();
////    driver.findElement(By.cssSelector(".col-xs-6.mobile-btns")).click();
////


