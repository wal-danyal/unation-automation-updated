package webautomation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Navigation {

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
    public void navigate() 
    
    {
    	
  	  
  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	  driver.manage().window().maximize();
  	  driver.navigate().to(prop.getProperty("base_url"));
  	   String title = driver.getTitle();
  	   System.out.print("Current page title is : "+title);
  	  driver.findElement(By.partialLinkText("SIGN")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        driver.findElement(By.name("email")).sendKeys(prop.getProperty("Navemail"));
        
        driver.findElement(By.name("password")).sendKeys(prop.getProperty("Navpass"));
        try {
  		Thread.sleep(5000);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
        driver.findElement(By.tagName("button")).click();
        try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        driver.findElement(By.partialLinkText("PAST")).click();
        try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        driver.findElement(By.partialLinkText("MY")).click();
        try {
      		Thread.sleep(3000);
      	} catch (InterruptedException e) {
      		// TODO Auto-generated catch block
      		e.printStackTrace();
      	}
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.xpath("/html/body/div[2]/menu/nav[1]/div/div[2]/ul/li[4]/a/i")).click();

        

        
  	  
    }

 
	
	
	
}
