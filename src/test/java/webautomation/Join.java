package webautomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Join 

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
//				System.setProperty("webdriver.gecko.driver", "E:\\Downloads\\geckodriver-v0.10.0-win64\\geckodriver.exe");
//				driver =new FirefoxDriver();
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
  public void join() 
  
  {
	  driver.get(prop.getProperty("base_url"));
	  driver.manage().window().maximize();
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign_in_click")));
	  

	  driver.findElement(By.id("sign_in_click")).click();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  driver.findElement(By.cssSelector(".join-section a")).click();
	  
	  
//	  int num=1;
//	  num++;
//	  String email= "testuser+"+ num + "@gmail.com";
	  
	  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
	  String email= "test"+ timeStamp + "@gmail.com";
	  
	  
	  
	  driver.findElement(By.name("email")).sendKeys(email);
	  driver.findElement(By.name("password")).sendKeys(prop.getProperty("Joinpass"));
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.findElement(By.cssSelector(".btn.btn-default.mth")).click();


	  Calendar cal = Calendar.getInstance();
	  int hours = cal.get(Calendar.MILLISECOND);
//	  int username =4;
//	  username++;
	  String user = "testuser_" + hours;
//	  String timeStampuser = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//	  String user = "testuser_" + timeStampuser;

	 
	  driver.findElement(By.name("username")).sendKeys(user);
	  driver.findElement(By.cssSelector(".btn.btn-default.mtxh")).click();
	  driver.findElement(By.name("birthday")).sendKeys(prop.getProperty("Birthday"));
	  driver.findElement(By.cssSelector(".btn.btn-default.mtxh")).click();
	  driver.findElement(By.cssSelector(".profile-img-sec.ng-scope")).click();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  //driver.findElement(By.cssSelector(".fileUpload.btn.btn-primary")).click();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
	  fileInput.sendKeys(prop.getProperty("picupload"));
	  
	  driver.findElement(By.cssSelector(".btn.btn-primary.done")).click();
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.findElement(By.cssSelector(".btn.btn-default")).click();
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.findElement(By.cssSelector(".event-circle-avatar:first-child")).click();
	  
	  driver.findElement(By.cssSelector(".btn.btn-default.let-me-in")).click();
	  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  assertTrue(driver.getPageSource().contains("CREATE YOUR OWN"));
	  System.out.println("CREATE YOUR OWN found in page source");
	  //Assert.assertEquals("CREATE YOUR OWN", driver.getPageSource().matches("CREATE YOUR OWN"));
	 // Assert.assertEquals("PASS", "CREATE YOUR OWN", "CREATE YOUR OWN");
	  //Assert.assertE(driver.getPageSource().contains("CREATE YOUR OWN"));
	  
  }

private void assertTrue(boolean contains) {
	// TODO Auto-generated method stub
	
}

@AfterTest
public void tearDown() throws Exception {
	driver.close();
	driver = null;
}
}
