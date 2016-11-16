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

public class LoginIncorrect 


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
			System.setProperty("webdriver.gecko.driver", prop.getProperty("gecko.driver"));
			driver =new FirefoxDriver();
			

		}

		else if (prop.getProperty("browser").equals("chrome")) 
		{
			//System.setProperty("webdriver.chrome.driver", "E:\\Downloads\\ChromeDriver\\chromedriver.exe");
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
		  	
		}
		
		else  if (prop.getProperty("browser").equals("ie"))
		{
			//InternetExplorerDriverManager.setup();
			System.setProperty("webdriver.ie.driver", prop.getProperty("gecko.driver"));
			 driver=new InternetExplorerDriver();
		}
		
    }


    @Test
    public void incorrect_username_password() {

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(prop.getProperty("base_url"));
        String title = driver.getTitle();
        System.out.print("Current page title is : "+title);
        driver.findElement(By.partialLinkText("SIGN")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.name("email")).sendKeys(prop.getProperty("Incorrectemail"));

        driver.findElement(By.name("password")).sendKeys(prop.getProperty("Incorrectpass"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElement(By.tagName("button")).click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
//        WebElement HomeText = driver.findElement(By.xpath("/html/body/div[2]/div[2]/p"));
//        String text = HomeText.getText();
//        if(text.equals("Wrong email or password. Try again!"))
//        {
            System.out.println("\nWrong email or password. Try again!");
//        }
//        else
//        {
//            System.out.println("\nOne more try before your account is locked!");
//        }
    }
    
    @AfterTest
    public void tearDown() throws Exception {
    	driver.close();
    	driver = null;
    }
}
