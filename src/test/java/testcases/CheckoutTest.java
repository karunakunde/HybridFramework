package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.Checkout;
import pages.Inventory;
import pages.Login;
import testbase.TestBase;
import utility.ReadData;
import utility.Constants;

public class CheckoutTest extends TestBase{
	
	Login login;
	Inventory inventory;
	CartPage cartPage;
	Checkout checkout;
	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
	    login = new Login();
		inventory = new Inventory();
		checkout = new Checkout();
		cartPage = new CartPage();
		login.logintoapplication();
		inventory.add3ProductsToCart();
		inventory.clickOnCart();
		cartPage.clickOnCheckout();
		
		
		
	}
	
	@Test(enabled = true)
	public void testCheckout() throws InterruptedException
	{
		checkout.enterFirstName("Karuna");
		checkout.enterLastName("Kunde");
		checkout.enterPostalZipCode("369234");
		Thread.sleep(2000);
		checkout.clickOnContinue();
		
		String actual = checkout.getApplicationUrl();
		String expected = "https://www.saucedemo.com/checkout-step-two.html";
		Assert.assertEquals(actual, expected,"Not navigated to checkout step two");
		Reporter.log("Suceesfully navigated to checkout step two");
	}
	
	@Test
	public void checkEmptyFirstName() throws InterruptedException
	{
		checkout.enterFirstName("");
		checkout.enterLastName("Kunde");
		checkout.enterPostalZipCode("369234");
		Thread.sleep(2000);
		checkout.clickOnContinue();
		String actual = checkout.getErrorMessage();
		String expected = "Error: First Name is required";
	    Assert.assertTrue(checkout.isErrorMessageDisplayed(), "Error message should be displayed");
		//Assert.assertTrue(checkout.isErrorMessageDisplayed());
		Assert.assertEquals(actual,expected ,"Error message displayed");	}
	
	@Test
	public void checkEmptyLastName() throws InterruptedException
	{
		checkout.enterFirstName("Karuna");
		checkout.enterLastName("");
		checkout.enterPostalZipCode("369234");
		Thread.sleep(2000);
		checkout.clickOnContinue();
		String actual = checkout.getErrorMessage();
		String expected = "Error: Last Name is required";
	    Assert.assertTrue(checkout.isErrorMessageDisplayed(), "Error message should be displayed");
		//Assert.assertTrue(checkout.isErrorMessageDisplayed());
		Assert.assertEquals(actual,expected,"Error message displayed");
	}
	
	@Test
	public void checkEmptyZipCode() throws InterruptedException
	{
		checkout.enterFirstName("Karuna");
		checkout.enterLastName("Kunde");
		checkout.enterPostalZipCode("");
		Thread.sleep(2000);
		checkout.clickOnContinue();
		String actual = checkout.getErrorMessage();
		String expected = "Error: Postal Code is required";
		 Assert.assertTrue(checkout.isErrorMessageDisplayed(), "Error message should be displayed");
		//Assert.assertTrue(checkout.isErrorMessageDisplayed());
		Assert.assertEquals(actual,expected,"Error message displayed");
	}
	
	@Test(dataProvider = "formData",enabled = false)
	public void dataDrivenCheckoutTest(String name,String lname,String zipcode,String expected,String message,String testType) throws InterruptedException
	{
		checkout.enterFirstName(name);
		checkout.enterLastName(lname);
		checkout.enterPostalZipCode(zipcode);
		Thread.sleep(2000);
		checkout.clickOnContinue();
		
		String actual = checkout.getApplicationUrl();
		Assert.assertEquals(actual, expected,"Test Failed for: "+testType);
		Reporter.log("Test: "+testType+ " "+message);
		
	}
	
	@DataProvider
	public String[][] formData() throws EncryptedDocumentException, IOException
	{
		String[][] data = ReadData.readExcel("checkout");
		
		return data;
		
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	

}
