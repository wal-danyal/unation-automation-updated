package webautomation;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class LoginwithFB 

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

		if (prop.getProperty("browser").equals("chrome")) 
		
		{

			ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();

		}

		else if (prop.getProperty("browser").equals("firfox")) 
		{
			//System.setProperty("webdriver.chrome.driver", "E:\\Downloads\\ChromeDriver\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", prop.getProperty("gecko.driver"));
			driver =new FirefoxDriver();
		  	
		}
		
		else  
		{
			 driver=new InternetExplorerDriver();
		}
		
    }

	
	
	
 @Test
 public void loginFB() 
 
 
 {
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get(prop.getProperty("base_url"));
		  driver.findElement(By.partialLinkText("SIGN")).click();
	      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  driver.findElement(By.cssSelector("a.fb")).click();
		  
		  Set handles = driver.getWindowHandles();
		  
	        System.out.println(handles);

	        // Pass a window handle to the other window

	        for (String handle1 : driver.getWindowHandles()) {

	        	System.out.println(handle1);

	        	driver.switchTo().window(handle1);
	        	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	        	}
		    driver.findElement(By.id("email")).sendKeys(prop.getProperty("fbemail"));
		    driver.findElement(By.id("pass")).sendKeys(prop.getProperty("fbpassword"));
		    driver.findElement(By.id("loginbutton")).click();
		    
		  
  }
 
// @AfterTest
// public void tearDown() throws Exception {
// 	driver.close();
// 	driver = null;
// }
}
