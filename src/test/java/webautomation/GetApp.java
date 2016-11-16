package webautomation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class GetApp

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
    public void get_app() 
    
    {
  	   
  	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	   driver.manage().window().maximize();
  	   driver.navigate().to(prop.getProperty("staging_url"));
  	   String title = driver.getTitle();
  	   System.out.print("Current page title is : "+title);
  	   driver.findElement(By.cssSelector("button.btn.btn-default.mth.ng-isolate-scope")).click();
  	   driver.findElement(By.cssSelector("input.form-control.phone_number.ng-isolate-scope")).sendKeys(prop.getProperty("number"));  
  	   driver.findElement(By.tagName("button")).click();
    }
  }
