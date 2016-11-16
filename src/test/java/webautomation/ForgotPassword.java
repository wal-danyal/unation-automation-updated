package webautomation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ForgotPassword 


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
			System.setProperty("webdriver.gecko.driver", "gecko.driver");
			driver =new FirefoxDriver();
			

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
  public void forgotpw() 
  
  
  {
	
	  driver.manage().window().maximize();
	  driver.get(prop.getProperty("base_url"));
	  driver.findElement(By.partialLinkText("SIGN")).click();
	  driver.findElement(By.partialLinkText("Forgot")).click();
	  driver.findElement(By.name("forget_email")).sendKeys(prop.getProperty("forgetemail"));
	  driver.findElement(By.tagName("button")).click();
	  driver.close();
  }
  
	public void checkmail() 
  {
	    //System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	    //driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("gmail"));
		driver.findElement(By.name("Email")).sendKeys(prop.getProperty("forgetemail"));
		driver.findElement(By.cssSelector("input#next.rc-button.rc-button-submit")).click();
		driver.findElement(By.name("Passwd")).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.id("signIn")).click();
		
		List<WebElement> email = driver.findElements(By.cssSelector("div.xT>div.y6>span>b"));

		for(WebElement emailsub : email){
		    if(emailsub.getText().equals("Too many passwords to keep track of?") == true){

		           emailsub.click();
		           break;
		        }
		    }
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.linkText("RESET MY PASSWORD")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        for (String handle1 : driver.getWindowHandles()) {

        	System.out.println(handle1);

        	driver.switchTo().window(handle1);
        	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        	}

		driver.findElement(By.name("unation_new_password")).click();
		driver.findElement(By.name("unation_new_password")).sendKeys(prop.getProperty("newpass"));
		driver.findElement(By.name("confirm_password")).sendKeys(prop.getProperty("confirmpass"));
		driver.findElement(By.tagName("button")).click();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys(prop.getProperty("forgetemail"));
		      driver.findElement(By.name("password")).sendKeys(prop.getProperty("confirmpass"));
		      try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      driver.findElement(By.tagName("button")).click();
		      driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  
  }	
	
  //@AfterTest
//  public void tearDown() throws Exception {
//  	driver.close();
//  	driver = null;
//  }
	}

	
