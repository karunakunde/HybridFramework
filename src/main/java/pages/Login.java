package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utility.ReadData;

public class Login extends TestBase {

	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement usernameTxtBox;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTxtBox;

	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement loginBtn;

	public Login() {
		PageFactory.initElements(driver, this);
	}

	public String logintoapplication() throws IOException {

		usernameTxtBox.sendKeys(ReadData.readProperty("UserName"));
		passwordTxtBox.sendKeys(ReadData.readProperty("Password"));
		loginBtn.click();

		return driver.getCurrentUrl();
	}

	public String verifyURLOfApplication() {
		return driver.getCurrentUrl();
	}

	public String verifyTitleOfApplication() {
		return driver.getTitle();
	}
}
