package testbase;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadData;

public class TestBase {
	public static WebDriver driver;
	
	public void initialization() throws IOException
	{
		String browser = ReadData.readProperty("Browser");
		String url = ReadData.readProperty("URL");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--disable-infobars");
		options.addArguments("--incognito");

		options.setExperimentalOption("prefs", new HashMap<String, Object>() {{
		    put("credentials_enable_service", false);
		    put("profile.password_manager_enabled", false);
		}});


		
		switch(browser) {
		
		                
		case "chrome" : System.setProperty("webdriver.chrome.driver", "C:\\Users\\darek\\.cache\\selenium\\chromedriver\\win64\\138.0.7204.183\\chromedriver.exe");
						driver =new ChromeDriver(options);
						break;
		case "edge" :   WebDriverManager.edgedriver();
						driver =new EdgeDriver();
						break;
		
		case "firefox" :WebDriverManager.firefoxdriver();
						driver =new FirefoxDriver();
						break;
						
		case "safari" : WebDriverManager.safaridriver();
						driver =new SafariDriver();
						break;
		default :		return;				
		
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}

}
