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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CopyEvent 

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
public void Copyevent()

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
    
    //Click on copy events
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector(".btn-copy.edit-event.ng-scope")).click();
    
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    WebElement myDynamicElement = (new WebDriverWait(driver, 60))
   	.until(ExpectedConditions.presenceOfElementLocated(By.id("title-box")));

    driver.findElement(By.id("title-box")).click();
    WebElement toClear = driver.findElement(By.id("title-box"));
    toClear.sendKeys(Keys.CONTROL + "a");
//    toClear.sendKeys(Keys.DELETE);
//    
    //driver.findElement(By.id("title-box")).clear();
    
    driver.findElement(By.id("title-box")).sendKeys(prop.getProperty("title"));
	try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  
	driver.findElement(By.cssSelector(".button-publish-and-cancel button[type='submit']")).click();
	  
}


}