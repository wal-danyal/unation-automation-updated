package webautomation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class MoreEvents 

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

    	
    	
		//FileInputStream filepath = new FileInputStream("E:\\Unation Automation\\UnationWebAutomation\\src\\test\\resources\\metadata.properties");
		//prop.load(filepath);
		
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
    public void more_events() 
    
    {
    	
  	
  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	  driver.manage().window().maximize();
  	  driver.navigate().to(prop.getProperty("base_url"));
  	   String title = driver.getTitle();
  	   System.out.print("Current page title is : "+title);
  	   driver.findElement(By.tagName("button")).click();
  	   driver.findElement(By.partialLinkText("Tampa")).click();
  	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	   
  	 JavascriptExecutor jse = (JavascriptExecutor) driver;
     jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
     //Click on get tickets
     try {
 		Thread.sleep(3000);
 	} catch (InterruptedException e1) {
 		// TODO Auto-generated catch block
 		
 		e1.printStackTrace();
 	}
     
     driver.findElement(By.cssSelector("button.btn.btn-default.default-button.mth.phh")).click();
//  	   WebElement element = driver.findElement(By.cssSelector("button.btn.btn-default.default-button.mth.phh"));
//  	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//  	   element.click();
//  	   try {
//  		Thread.sleep(500);
//  	} catch (InterruptedException e) {
//  		// TODO Auto-generated catch block
//  		e.printStackTrace();
//  	} 
  	   
  	  // JavascriptExecutor jse = (JavascriptExecutor)driver;
  	  // jse.executeScript("scroll(0, 400);");	   
  	  // driver.findElement(By.cssSelector("button.btn.btn-default.default-button.mth.phh")).click();
    }
  }


