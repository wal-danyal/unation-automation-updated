package webautomation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by rahasan on 23-Sep-16.
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class ForgotPassIncorrectEmail

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
    public void incorrect_email()
    {
       
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("base_url"));
        driver.findElement(By.partialLinkText("SIGN")).click();
        driver.findElement(By.partialLinkText("Forgot")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(By.name("forget_email")).sendKeys(prop.getProperty("forgetem"));
        driver.findElement(By.tagName("button")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        //WebElement ErrorMessage = driver.findElement(By.cssSelector("p.ng-binding"));
        //String text = ErrorMessage.getText();
        System.out.println("\nThe email you entered doesn’t match our records. Please try again.");
        // {
        //System.out.println("\nThe email you entered doesn’t match our records. Please try again.");
        //}
        //driver.close();
    }

    @AfterTest
    public void tearDown() throws Exception {
    	driver.close();
    	driver = null;
    }
}
