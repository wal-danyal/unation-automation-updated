package webautomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;


public class EditRegistration {

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

    public void editregistration()

{


      //Opening the URL
  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	  driver.manage().window().maximize();
  	  driver.navigate().to(prop.getProperty("staging_url"));
  	  String title = driver.getTitle();
  	  System.out.print("Current page title is : "+title);

  	  //Sign in
  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	  driver.findElement(By.cssSelector(".btn.btn-links.a-hover.ng-isolate-scope")).click();
  	 
      //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      driver.findElement(By.name("email")).sendKeys(prop.getProperty("createticketemail"));
      driver.findElement(By.name("password")).sendKeys(prop.getProperty("createticketpass"));
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      driver.findElement(By.cssSelector(".btn.btn-default")).click();
      System.out.print("\n Login Successfully");
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  	  driver.findElement(By.cssSelector("button.nav_list")).click();
  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	  driver.findElement(By.cssSelector("i.icon-follow-or-create-icon")).click();
  	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  	  driver.findElement(By.id("title-box")).sendKeys(prop.getProperty("TicketTitle"));
  	  driver.findElement(By.cssSelector(".btn-default.add-end-date.btn")).click();
      driver.findElement(By.xpath("//div[2]/div/div/div/div/div/label")).click();
      
      
      //Redirecting to ticketing page
      driver.findElement(By.linkText("ADD TICKET & REGISTRATION INFO")).click();
      try {
		Thread.sleep(5000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      
      //Inserting the information to generate the ticket 
      driver.findElement(By.id("ticket_type")).click();
      driver.findElement(By.id("ticket_type")).clear();
      driver.findElement(By.id("ticket_type")).sendKeys(prop.getProperty("Tickettype"));
      driver.findElement(By.name("event[price_levels][][description]")).click();
      driver.findElement(By.name("event[price_levels][][description]")).clear();
      driver.findElement(By.name("event[price_levels][][description]")).sendKeys(prop.getProperty("Ticketdecr"));
      driver.findElement(By.id("price_field")).click();
      driver.findElement(By.id("price_field")).clear();
      driver.findElement(By.id("price_field")).sendKeys(prop.getProperty("Tickerprice"));
      
     
      driver.findElement(By.name("event[price_levels][][min_number_per_registration]")).click();
      driver.findElement(By.name("event[price_levels][][min_number_per_registration]")).click();
      driver.findElement(By.name("event[price_levels][][min_number_per_registration]")).clear();
      driver.findElement(By.name("event[price_levels][][min_number_per_registration]")).sendKeys(prop.getProperty("Ticketminnum"));
      driver.findElement(By.name("event[price_levels][][max_number_per_registration]")).click();
      driver.findElement(By.name("event[price_levels][][max_number_per_registration]")).clear();
      driver.findElement(By.name("event[price_levels][][max_number_per_registration]")).sendKeys(prop.getProperty("Ticketmaxnum"));
      driver.findElement(By.name("event[price_levels][][max_quantity]")).click();
      driver.findElement(By.name("event[price_levels][][max_quantity]")).clear();
      driver.findElement(By.name("event[price_levels][][max_quantity]")).sendKeys(prop.getProperty("Ticketmaxquantity"));
//      driver.findElement(By.name("event[price_levels][][description]")).click();
//      driver.findElement(By.name("event[price_levels][][description]")).clear();
//      driver.findElement(By.name("event[price_levels][][description]")).sendKeys("general ticket");
      

      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

      JavascriptExecutor jse = (JavascriptExecutor) driver;
      jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
      
      driver.findElement(By.id("contact_fname")).click();
      driver.findElement(By.id("contact_fname")).clear();
      driver.findElement(By.id("contact_fname")).sendKeys(prop.getProperty("contactfname"));
      driver.findElement(By.name("event[contacts][][last_name]")).clear();
      driver.findElement(By.name("event[contacts][][last_name]")).sendKeys(prop.getProperty("contactlname"));
      driver.findElement(By.name("event[contacts][][email]")).clear();
      driver.findElement(By.name("event[contacts][][email]")).sendKeys(prop.getProperty("contactemail"));
      try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      driver.findElement(By.id("submit-button")).click();
      
      try {
  		Thread.sleep(1000);
  	} catch (InterruptedException e1) {
  		// TODO Auto-generated catch block
  		e1.printStackTrace();
  	}
      driver.findElement(By.xpath("//input[@value='Save']")).click();
  	  
      try {
    		Thread.sleep(13000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

      //EditRegistration
      driver.findElement(By.xpath("(//a[contains(@href, '')])[35]")).click();
      try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      driver.findElement(By.cssSelector(".icon-checkmark-gray")).click();
      driver.findElement(By.xpath("//div[5]/div/div/span")).click();
      driver.findElement(By.xpath("//div[5]/div/div[2]/div/div")).click();
      driver.findElement(By.cssSelector("#address > span.icon-checkmark-gray")).click();
      driver.findElement(By.xpath("//div[@id='address']/div[2]/div/div")).click();
      driver.findElement(By.xpath("//input[@value='Save']")).click();
      
      
  	  
  	  
      try {
  		Thread.sleep(13000);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	driver.findElement(By.cssSelector(".button-publish-and-cancel button[type='submit']")).click();
    System.out.print("Ticket has been created!");
  	
  	}
    @AfterTest
    public void tearDown() throws Exception {
    	driver.close();
    	driver = null;
    }

}
