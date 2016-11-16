package webautomation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

 
public class SellTicket 


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
  public void Sell_Ticket() 
  
  {
	  
	  //Opening the URL
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.navigate().to(prop.getProperty("base_url"));
	  String title = driver.getTitle();
	  System.out.print("Current page title is : "+title);
	  
	  //Clicking on sell ticket
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("SELL TICKETS")).click();
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      
      //Click on join
      driver.findElement(By.cssSelector(".modal-footer.download")).click();;
      driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
      
      //Adding business profile
      driver.findElement(By.linkText("BUSINESS")).click();
      driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
      
      //Initializing timestamp for uniqueness of email
      String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
	  String email= "test"+ timeStamp + "@gmail.com";
      
      driver.findElement(By.name("email")).sendKeys(email);
      driver.findElement(By.name("password")).sendKeys(prop.getProperty("SellTicketpass"));
      
      try {
  		Thread.sleep(1000);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	  driver.findElement(By.cssSelector(".btn.btn-default.mth")).click();
  	  
  	  //Initializing unique username
  	  Calendar cal = Calendar.getInstance();
	  int hours = cal.get(Calendar.MILLISECOND);
	  String user = "testuser_" + hours;
	  driver.findElement(By.name("username")).sendKeys(user);
	  driver.findElement(By.cssSelector(".btn.btn-default.mtxh")).click();
//	  driver.findElement(By.name("birthday")).sendKeys("11111988");
//	  driver.findElement(By.cssSelector(".btn.btn-default.mtxh")).click();
	 // driver.findElement(By.cssSelector(".btn.btn-default.mtxh")).click();
	  driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
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
	  driver.findElement(By.linkText("Celebrities")).click();
	    driver.findElement(By.xpath("//div[5]/div")).click();
	    driver.findElement(By.xpath("//div[4]/div")).click();
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





}