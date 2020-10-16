package webpages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	//element locations of the web element on this page
	@FindBy(id="username-input")
	private WebElement userNameInput;
	@FindBy(id="password-input")
	private WebElement passwordInput;
	@FindBy(id="login-submit-button")
	private WebElement loginButton;

	//construct of this PageObject
	public LoginPage(WebDriver driver){
		super(driver);
	}

	//the page is initialized
	public boolean isInitialized() {
		return userNameInput.isDisplayed();
	}

	//this method allows you to lgo into your account provideing that
	//you have correct userame and password
	public  CustomerHomePage login(String username, String password){
		this.setUserName(username);
		this.setPassword(password);
		return this.clickLogin();
	}

	/**
	 * Set userName
	 *
	 * @param userName
	 */
	public void setUserName(String userName)
	{
		this.userNameInput.sendKeys(userName);
	}

	/**
	 * Set password
	 *
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.passwordInput.sendKeys(password);
	}

	public CustomerHomePage clickLogin(){
		loginButton.click();
		return new CustomerHomePage(driver);
	}
}
