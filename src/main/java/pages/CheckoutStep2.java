package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class CheckoutStep2 extends TestBase{
	
	@FindBy(xpath = "//button[@id='finish']")
	WebElement finishBtn;
	
	@FindBy(xpath = "cancel")
	WebElement cancelBtn;
	
	public CheckoutStep2() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public String getApplicationUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void clickOnFinish()
	{
		finishBtn.click();
	}
	
	public void clickOnCancel()
	{
		cancelBtn.click();
	}

}
