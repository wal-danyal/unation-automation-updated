package webautomation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
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

public class AddGuest

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

    public void create_event()

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
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("button.nav_list")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("i.icon-follow-or-create-icon")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("title-box")).sendKeys(prop.getProperty("title"));
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.linkText("ADD END DATE")).click();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys(prop.getProperty("Description"));
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
	driver.findElement(By.linkText("21+")).click();
	driver.findElement(By.id("hashtag_field")).sendKeys(prop.getProperty("Hashtag"));
	driver.findElement(By.name("website")).sendKeys(prop.getProperty("website"));
	driver.findElement(By.name("locationName")).sendKeys(prop.getProperty("locationName"));
	driver.findElement(By.xpath("//input[@value='']")).sendKeys(prop.getProperty("location"));
	driver.findElement(By.xpath("//div[3]/div/div/div/div/label")).click();
	driver.findElement(By.xpath("//div[@class='view-list col-sm-2'][contains(.,'Add guest')]")).click();
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	driver.findElement(By.xpath("//div[@class='invites-button-inner-container']/button[contains(.,'Through Email')]")).click();
	
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(prop.getProperty("Guestemail"));
	Actions action = new Actions(driver);
	action.sendKeys(Keys.SPACE).build().perform();
	driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.cssSelector(".button-publish-and-cancel button[type='submit']")).click();

	}
}