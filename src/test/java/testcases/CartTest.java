package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.Inventory;
import pages.Login;
import testbase.TestBase;
import utility.Screenshot;

public class CartTest extends TestBase {
	
	Login login;
	Inventory inventory;
	CartPage cartPage;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		initialization();
		login = new Login();
		login.logintoapplication();
		inventory = new Inventory();
		inventory.addAll6ProductsToCart();
		inventory.clickOnCart();
	    cartPage = new CartPage();
				
	}
	@Test(enabled = true)
	public void verifyApplicationUrl()
	{
		String actual = inventory.getApplicationUrl();
		String expected = "https://www.saucedemo.com/cart.html";
		Assert.assertEquals(actual, expected);
	}
	@Test(enabled = true)
	public void verifyApplicationTitle()
	{
		String actual = inventory.getApplicationTitle();
		String extected = "Swag Labs";
		Assert.assertEquals(actual, extected);
	}
	
	
	@Test(enabled = true)
	public void verifyCheckout() throws InterruptedException
	{
		cartPage.clickOnCheckout();
		String actual = cartPage.getApplicationUrl();
		String expected = "https://www.saucedemo.com/checkout-step-one.html";
		Thread.sleep(4000);
		Assert.assertEquals(actual, expected);
		
	}
	@Test(enabled = true)
	public void verifyContinueShoppingBtn() throws InterruptedException
	{
		cartPage.continueShoppingBtn();
		String actual = "https://www.saucedemo.com/inventory.html";
		String expected = cartPage.getApplicationUrl();
		Thread.sleep(3000);
		Assert.assertEquals(actual, expected,"Continue shpooing button not working as expected");
		Reporter.log("Continue shpooing button working as expected");
	}
	
	@Test(enabled = true)
	public void verifyAllItemsMenu() throws InterruptedException {
		cartPage.clickOnHamburgerBtn();
		Thread.sleep(3000);
        cartPage.clickOnAllItems();
		String actual = "https://www.saucedemo.com/inventory.html";
		String expected = cartPage.getApplicationUrl();
		Assert.assertEquals(actual, expected,"All Items Menu not working");
		Reporter.log("All Items Menu working as expected");
	}
	
	@Test(enabled = true)
	public void verifyAboutMenu() throws InterruptedException {
		cartPage.clickOnHamburgerBtn();
		Thread.sleep(3000);
		cartPage.clickOnAbout();
		String actual = "https://saucelabs.com/";
		String expected = cartPage.getApplicationUrl();
		Assert.assertEquals(actual, expected,"About Menu not working as expected");
		Reporter.log("About menu working as expected");
	}
	@Test(enabled = true)
	public void verifyLogoutMenu() throws InterruptedException {
		cartPage.clickOnHamburgerBtn();
		Thread.sleep(3000);
		cartPage.clickOnLogout();
		String actual = "https://www.saucedemo.com/";
		String expected = cartPage.getApplicationUrl();
		Assert.assertEquals(actual, expected,"Logout Menu not working as expected");
		Reporter.log("Logout menu working as expected");
	}
	
	@Test(enabled = true)
	public void verifyResetAppMenu() throws InterruptedException {
		cartPage.clickOnHamburgerBtn();
		Thread.sleep(3000);
		cartPage.clickOnResetState();
		String actual = "https://www.saucedemo.com/cart.html";
		String expected = cartPage.getApplicationUrl();
		Assert.assertEquals(actual, expected,"Reset Menu not working as expected");
		Reporter.log("Reset menu working as expected");
	}
	@Test(enabled = true)
	public void verifyCartAfterRemovingProduct() throws InterruptedException {
		
		cartPage.removeTwoProducts();
		String actualcount = cartPage.getCartCount();
		String expected = "4";	
		Thread.sleep(4000);
		Assert.assertEquals(actualcount, expected,"Cart count not updated");
		Reporter.log("Product removed from cart successfully");
	}
	
	@Test(enabled = true)
	public void verifyProductNameClickNavigation() {
		
		cartPage.clickOnsauceLabBikeLight();
		String actual = cartPage.getApplicationUrl();
		String expected = "https://www.saucedemo.com/inventory-item.html?id=0";
		Assert.assertEquals(actual, expected,"Page not navigated to product detail page");
		Reporter.log("");
	}
	
	@Test(enabled = true)
    public void testAccessCartWithoutLogin() throws InterruptedException {
        // Skipping @BeforeMethod by using a local WebDriver instance
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\darek\\.cache\\selenium\\chromedriver\\win64\\134.0.6998.165\\chromedriver.exe");
        WebDriver localDriver = new ChromeDriver();
        localDriver.get("https://www.saucedemo.com/cart.html");

        String expectedUrl = "https://www.saucedemo.com/";
        Thread.sleep(3000);
        String actualUrl = localDriver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "User was not redirected to login page!");

        localDriver.quit(); // Close local instance
    }
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		try {
		if(ITestResult.FAILURE==it.getStatus())
			Screenshot.takeScreenshot(it.getName());
		driver.close();
		}
		catch(Exception e)
		{}
	}

}
