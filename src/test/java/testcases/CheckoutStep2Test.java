package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.Checkout;
import pages.CheckoutStep2;
import pages.Inventory;
import pages.Login;
import testbase.TestBase;
import utility.Screenshot;

public class CheckoutStep2Test extends TestBase{
	Login login;
	Inventory inventory;
	CartPage cartPage;
	Checkout checkout;
    CheckoutStep2 checkoutStep2;
	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new Login();
		inventory=new Inventory();
		cartPage = new CartPage();
		checkout = new Checkout();
		checkoutStep2 = new CheckoutStep2();
		login.logintoapplication();
		inventory.add3ProductsToCart();
		inventory.clickOnCart();
		cartPage.clickOnCheckout();
		checkout.enterFirstName("karuna");
		checkout.enterLastName("kunde");
		checkout.enterPostalZipCode("34555");
		checkout.clickOnContinue();
		
	}
	
     @Test
     public void checkFinishBtn()
     {
    	 checkoutStep2.clickOnFinish();
    	 String actual = checkoutStep2.getApplicationUrl();
    	 String expected = "https://www.saucedemo.com/checkout-complete.html";
    	 Assert.assertEquals(actual, expected,"Page should be redirected to the Thank You page");
    	 
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
