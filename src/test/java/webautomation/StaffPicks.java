package webautomation;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class StaffPicks

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
	        	
	        	WebDriver driver = new HtmlUnitDriver(true);
	        }
	
	

    }



@Test

    public void Addstaffpicks()

{

	driver.get(prop.getProperty("base_url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	System.out.print("Welcome to Unation");

	//Sign in
	driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector(".btn.btn-links.a-hover.ng-isolate-scope")).click();
	 
    //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.findElement(By.name("email")).sendKeys(prop.getProperty("createticketemail"));
    driver.findElement(By.name("password")).sendKeys(prop.getProperty("createticketpass"));
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector(".btn.btn-default")).click();
    System.out.print("\n Login Successfully");
    
    //Go to public event
    driver.findElement(By.xpath("//div[@class='event-bottom-title'][contains(.,'Frozen copy')]")).click();
    
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
    driver.findElement(By.xpath("//div[2]/div/a/img")).click();
    driver.findElement(By.linkText("ADD TO STAFF PICKS")).click();
    System.out.print("Event has been added to Staff Picks!");
    
    driver.findElement(By.cssSelector("button.nav_list")).click();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//li[4]/a/i")).click();
    
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    
    try {
  		Thread.sleep(1000);
  	} catch (InterruptedException e1) {
  		// TODO Auto-generated catch block
  		e1.printStackTrace();
  	}
    
    }

@Test
  
     public void Removestaffpicks()
    
{ 
	    //Sign in
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".btn.btn-links.a-hover.ng-isolate-scope")).click();
		 
	    //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.findElement(By.name("email")).sendKeys(prop.getProperty("createticketemail"));
	    driver.findElement(By.name("password")).sendKeys(prop.getProperty("createticketpass"));
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector(".btn.btn-default")).click();
	    System.out.print("\n Login Successfully");
	    
	    //Go to public event
	    driver.findElement(By.xpath("//div[@class='event-bottom-title'][contains(.,'Frozen copy')]")).click();
	    
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    driver.findElement(By.xpath("//div[2]/div/a/img")).click();
	    driver.findElement(By.linkText("REMOVE FROM STAFF PICKS")).click();
	    System.out.print("\nEvent has been removed from Staff Picks!");
	    driver.findElement(By.cssSelector("button.nav_list")).click();
	    driver.findElement(By.xpath("//li[4]/a/i")).click();
	    
	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    
	    try {
	  		Thread.sleep(2000);
	  	} catch (InterruptedException e1) {
	  		// TODO Auto-generated catch block
	  		e1.printStackTrace();
	  	}
	    
	    }
	
	
     }


