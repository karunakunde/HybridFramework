package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Inventory;
import pages.InventoryItem;
import pages.Login;
import testbase.TestBase;
import utility.Screenshot;

public class InventoryItemTest extends TestBase {
	
	Login login;
	Inventory inventory;
	InventoryItem item;
	
	@BeforeMethod
	void setup() throws IOException
	{
		initialization();
		login = new Login();
		inventory = new Inventory();
		item = new InventoryItem();
		login.logintoapplication();
		inventory.openProductDetail();
		
		
		
	}
	
	@Test 
	void verifyAddToCart()
	{
		item.addToCart();
		String actual = item.getCartCount();
		String expected = "1";
		Assert.assertEquals(actual, expected,"Item not added to cart");
		Reporter.log("Item added to cart");
	}
	
	@Test
    void verifyProductImage() throws IOException
    {
		boolean isdisplayed =  item.isItemImagedisplayed();
		Assert.assertTrue(isdisplayed, "Image is not displayed");
		boolean isLoaded = item.isImageLoaded();
		Assert.assertTrue(isLoaded,"Image is broken");
		Reporter.log("Image is visible");
    }
	
	@Test
	void verifyRemoveFromCart()
	{
		item.addToCart();
		item.clickRemoveBtn();
		String actual = item.getCartCount();
		String expected = "0";
		Assert.assertEquals(actual, expected,"Product not removed from cart");
		Reporter.log("Product removed from cart");
	}
	@Test
	public void verifyBackToProductBtn()
	{
		item.clickBackToProducts();
		String actual = item.getApplicationUrl();
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actual, expected,"Page not navigated to products page");
		Reporter.log("PASS: Page navigated to products page");
	}
	
	@Test
	public void verifyHamburgerBtn()
	{
		item.clickHamburgerBtn();
		boolean actual = item.isSideMenuVisible();
		boolean expected = true;
		Assert.assertEquals(actual, expected,"Sidebar menu is not visible");
		Reporter.log("Sidebar menu is visible ");
	}
	
	@Test
	public void verifyAllItemsMenuBtn() throws InterruptedException
	{
		item.clickHamburgerBtn();
        Thread.sleep(3000);
		item.clickAllItemLink();
		String actual = item.getApplicationUrl();
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actual, expected,"Not navigated to all products page");
		Reporter.log("Navigated to all products page");
	}
	
	@Test
	public void verifyAboutMenuBtn() throws InterruptedException
	{
		item.clickHamburgerBtn();
        Thread.sleep(3000);

		item.clickAboutLink();
		String actual = item.getApplicationUrl();
		String expected = "https://saucelabs.com/";
		Assert.assertEquals(actual, expected,"Not navigated to about page");
		Reporter.log("Navigated to about page");
	}
	
	@Test
	public void verifyLogoutMenuBtn() throws InterruptedException
	{
		item.clickHamburgerBtn();
        Thread.sleep(3000);

		item.clickLogouLink();
		String actual = item.getApplicationUrl();
		String expected = "https://www.saucedemo.com/";
		Assert.assertEquals(actual, expected,"not logged out");
		Reporter.log("Logout menu btn working as expected");
	}
	
	@Test
	public void verifyResetAppStateMenu() throws InterruptedException
	{
		item.clickHamburgerBtn();
        Thread.sleep(3000);

		String previousUrl = item.getApplicationUrl();
		item.clickResetAppState();
		String currentUrl = item.getApplicationUrl();

		String actual = previousUrl;
		String expected = currentUrl;
		Assert.assertEquals(actual, expected,"Reset App State menu button not working");
		Reporter.log("Reset App State menu button working as expected");
	}
	
	@Test
	public void verifyBrowserBackAndForword()
	{
		item.navigateBack();
		String actual = item.getApplicationUrl();
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actual, expected,"Backward navigation failed");
		item.navigateForward();
		String actualUrl = item.getApplicationUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		Assert.assertEquals(actualUrl, expectedUrl,"Forward navigation failed");
		Reporter.log("Backward and Forward navigation working as expected");
		
	}
	
	@AfterMethod
	void closeBrowser(ITestResult iTestResult) throws IOException
	{
		if(iTestResult.FAILURE == iTestResult.getStatus())
		{
			Screenshot.takeScreenshot(iTestResult.getName());
		}
		driver.close();
	}
	
	

}
