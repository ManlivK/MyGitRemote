package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	
	@BeforeMethod
	public void setUp() throws IOException{
		
		if(driver==null){
			
			fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);
			fr1=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			loc.load(fr1);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("testurl"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
		}
		
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.close();
		
	}

}
