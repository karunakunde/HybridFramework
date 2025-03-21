package testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		
		switch(browser) {
		
		case "chrome" : WebDriverManager.chromedriver();
						driver =new ChromeDriver();
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
