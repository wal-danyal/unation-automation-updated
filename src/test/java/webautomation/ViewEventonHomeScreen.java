package webautomation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

 
public class ViewEventonHomeScreen 


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
  public void ViewEvent() 
  
  {
	  
	  //Opening the URL
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.navigate().to(prop.getProperty("base_url"));
	  String title = driver.getTitle();
	  System.out.print("Current page title is : "+title);
	  
	  //Clicking on event 
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  WebElement Event = driver.findElement(By.cssSelector(".event-theme"));
      if(Event.equals(Event))
      {
      Event.click();
      System.out.print("Even is present");
      }
      else
      {
      System.out.println("No Event is present!");
 }
	  
	  
//	  driver.findElement(By.cssSelector(".event-theme")).click();
//      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//      JavascriptExecutor jse = (JavascriptExecutor) driver;
//      jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
      

}
  @AfterTest
  public void tearDown() throws Exception {
  	driver.close();
  	driver = null;
  }
  
}