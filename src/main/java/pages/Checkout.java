package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class Checkout extends TestBase {
	
	@FindBy(id="react-burger-menu-btn")
	WebElement hamburgerBtn;
	
	@FindBy(id="react-burger-cross-btn")
	WebElement crossBurgerBtn;
	
	@FindBy(id="inventory_sidebar_link")
	WebElement allItemsLink;
	
	@FindBy(id="about_sidebar_link")
	WebElement aboutLink;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logoutLink;
	
	@FindBy(id="reset_sidebar_link")
	WebElement resetAppStateLink;
	
	@FindBy(xpath = "//span[@class='title']")
	WebElement formTitle;
	
	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id = "last-name")
	WebElement lastName;
	
	@FindBy(id = "postal-code")
	WebElement zipCode;
	
	@FindBy(id="cancel")
	WebElement cancel;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement cartCount;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartBtn;
	
	@FindBy(xpath = "//*[@id='first-name']/following-sibling::*[local-name()='svg']")
	WebElement firstNameError;
	
	@FindBy(xpath = "//*[@id='last-name']/following-sibling::*[local-name()='svg']")
	WebElement lastNameError;
	
	@FindBy(xpath = "//*[@id='postal-code']/following-sibling::*[local-name()='svg']")
	WebElement postalcodeError;
	
	@FindBy(xpath = "//button[@class='error-button']")
	WebElement errorCloseBtn;
	
	@FindBy(xpath = "//div[@class='error-message-container error']/h3")
	WebElement errorMessageText;
		
	
	
	public Checkout() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String name)
	{
	
		firstName.sendKeys(name);
	}
	
	public void enterLastName(String lastName) {
		
		this.lastName.sendKeys(lastName);
	}
	
	public void enterPostalZipCode(String zipCode) {
		
		this.zipCode.sendKeys(zipCode);
		
	}
	
	public void clickOnContinue()
	{
	   continueBtn.click();	
	   
	}
	
	public boolean isFirstNameErrorvisible() {
		return firstNameError.isDisplayed() && firstNameError.isEnabled();
	}
	
	public boolean isLastNameErrorvisible()
	{
		return lastNameError.isDisplayed() && lastNameError.isEnabled();
	}
	
	public boolean isZipPostalErrorVisible()
	{
		return postalcodeError.isDisplayed() && postalcodeError.isEnabled();
	}
	
	public boolean isErrorMessageDisplayed()
	{
		return errorMessageText.isDisplayed();
	}
	
	public String getErrorMessage()
	{
		if(errorMessageText.isDisplayed())
			return errorMessageText.getText();
		else
			return "";
	}
	
	public String getApplicationUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
		
	}
	

}
