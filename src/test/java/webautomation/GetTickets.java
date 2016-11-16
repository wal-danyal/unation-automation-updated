package webautomation;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class GetTickets 

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
public void gettickets()

{
	//opening the web url
	driver.get(prop.getProperty("base_url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
	System.out.print("Welcome to Unation");   
	
	//Sign in 
	driver.findElement(By.cssSelector(".btn.btn-links.a-hover.ng-isolate-scope")).click();
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.findElement(By.name("email")).sendKeys(prop.getProperty("getticketsemail"));
    driver.findElement(By.name("password")).sendKeys(prop.getProperty("getticketspassword"));
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector(".btn.btn-default")).click();
    System.out.print("\n Login Successfully");
    
    
    //click on my events
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.linkText("MY EVENTS")).click();
    
    try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    driver.findElement(By.xpath("//div[@class='event-theme'][contains(.,'Test Ticket')]")).click();
    

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    //Click on get tickets
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		
		e1.printStackTrace();
	}
  
    driver.findElement(By.cssSelector(".get-tickets.ng-binding.ng-scope")).click();
    
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    driver.findElement(By.xpath("//button[2]")).click(); //Adding ticket 
    
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    driver.findElement(By.id("select-tickets")).click(); //Navigate to registration
    	   
    //Inserting contact details
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    driver.findElement(By.name("registration[first_name]")).sendKeys(prop.getProperty("getticketfirstname"));
    driver.findElement(By.name("registration[last_name]")).sendKeys(prop.getProperty("getticketslastname"));
    driver.findElement(By.name("registration[email]")).sendKeys(prop.getProperty("getticketsregemail"));
    
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    driver.findElement(By.id("#submit-button")).click();
    
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    //Entering card details
    driver.findElement(By.name("name")).sendKeys(prop.getProperty("getticketscardname"));
    driver.findElement(By.name("zip")).sendKeys(prop.getProperty("getticketscardzip"));
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.findElement(By.id("card_number")).sendKeys(prop.getProperty("getticketscardno"));
    driver.findElement(By.id("verification_value")).sendKeys(prop.getProperty("getticketscvc"));
    
    JavascriptExecutor jse1 = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    driver.findElement(By.xpath("//div//input[@value='Pay Now']")).click();
    System.out.print("THANK YOU!  Your registration is now complete");
    
    
}


@Test
public void purchasemoretickets()

{
	   try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       driver.findElement(By.linkText("PURCHASE MORE TICKETS")).click();	
	
	
	
}


//@AfterTest
//public void tearDown() throws Exception {
//	
//	driver.close();
//	driver = null;
//}
	
}

