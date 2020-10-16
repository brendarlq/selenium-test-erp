package webpages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerHomePage extends BasePage
{
	//element locations of the web element on this page
	@FindBy(tagName="h1")
	private WebElement header;

	//construct of this PageObject
	public CustomerHomePage(WebDriver driver){
		super(driver);
	}

	//the page is initialized
	public boolean isInitialized() {
		return header.isDisplayed();
	}

	public String confirmationHeader(){
		return header.getText();
	}
}
