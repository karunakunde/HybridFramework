package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class InventoryItem extends TestBase {
	
	
	@FindBy(xpath = "//button[@id='back-to-products']")
	private WebElement backToProductBtn;
	
	@FindBy(xpath = "//div[@data-test='inventory-item-name']")
	private WebElement itemName;
	
	@FindBy(xpath = "//button[@id='add-to-cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	private WebElement cartCountText;
	
	@FindBy(xpath = "//img[@class='inventory_details_img']")
	private WebElement itemImage;
	
	@FindBy(xpath = "//button[@id='remove']")
	private WebElement removeBtn;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	private WebElement hamburgerBtn;
	
	@FindBy(xpath="//button[@id='react-burger-cross-btn']")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")
	private WebElement allProductMenuBtn;
	
	@FindBy(xpath = "//a[@id='about_sidebar_link']")
	private WebElement aboutMenuBtn;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	private WebElement logoutMenuBtn;
	
	@FindBy(xpath = "//a[@id='reset_sidebar_link']")
	private WebElement resetAppStateMenuBtn;
	
	@FindBy(xpath = "//div[@class='bm-menu-wrap']")
	private WebElement sideMenuBar;
	
	public InventoryItem() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public String getApplicationUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getApplicattiontitle() {
	  return driver.getTitle();
		
	}
	public boolean itemNameVisible()
	{
		return itemName.isDisplayed();
	}
	
	public boolean isItemImagedisplayed()
	{
		return itemImage.isDisplayed();
	}
	
	public boolean isImageLoaded() throws IOException {
		
		if(isItemImagedisplayed()==false)
			return false;
		
		String imageURl = itemImage.getAttribute("src");
		URL url = new URL(imageURl);
		HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.connect();;
		
		int statusCode = httpURLConnection.getResponseCode();
		if(statusCode== 200)
			return true;
		else return false;
		
		
	}
	
	public void addToCart()
	{
		addToCartBtn.click();
	}
	
	public void clickRemoveBtn()
	{
		removeBtn.click();
	}
	
	public String getCartCount()
	{
		try {
		return cartCountText.getText();
		}catch(Exception e)
		{
			return "0";
		}
		
	}
	
	public void clickOnCart()
	{
		addToCartBtn.click();
	}
	
	public void clickBackToProducts() {
		
		backToProductBtn.click();
	}

	public void clickHamburgerBtn() {
		// TODO Auto-generated method stub
		hamburgerBtn.click();
	}
	
	public void clickCloseBtn()
	{
			closeBtn.click();
	}
	
	public boolean isSideMenuVisible()
	{
		return sideMenuBar.isDisplayed() && sideMenuBar.isEnabled();
	}
	
	public void clickAllItemLink()
	{
		allProductMenuBtn.click();
	}
	
	public void clickAboutLink()
	{
		aboutMenuBtn.click();
	}
	
	public void clickLogouLink()
	{
		logoutMenuBtn.click();
		
	}
	
	public void clickResetAppState()
	{
		resetAppStateMenuBtn.click();
	}
	
	public void navigateBack()
	{
		driver.navigate().back();
	}
	
	public void navigateForward()
	{
		driver.navigate().forward();
	}
	
	
	

}
