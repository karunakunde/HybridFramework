package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Inventory;
import pages.Login;
import testbase.TestBase;
import utility.ReadData;
import utility.Screenshot;

public class LoginTest extends TestBase{
	Login lg;
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		lg = new Login();
		
	}
	@Test
	public void verifyURLOfApplication() throws EncryptedDocumentException, IOException {
		String expUrl = ReadData.readExcel(0, 0);
		String actUrl = lg.verifyURLOfApplication();
		Assert.assertEquals(actUrl, expUrl);
		
	}

	@Test
	public void verifyTitleOfApplication() throws EncryptedDocumentException, IOException {
		String expUrl = ReadData.readExcel(1, 0);
		String actUrl = lg.verifyTitleOfApplication();
		Assert.assertEquals(actUrl, expUrl);
	}
	
	@Test
	public void logintoapplication() throws IOException {
		String expUrl = ReadData.readExcel(2, 0);
		String actUrl = lg.logintoapplication();
		Assert.assertEquals(actUrl, expUrl);
		Reporter.log("Login successful--"+actUrl);
	}

	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
			Screenshot.takeScreenshot(it.getName());
		driver.close();
	}
}
