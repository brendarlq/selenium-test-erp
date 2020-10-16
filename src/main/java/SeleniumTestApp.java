
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class SeleniumTestApp
{

	public static void main(String args[]){
		ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://stage-unicore.denniskirk.com/erp/login");
		driver.manage().window().maximize();

		WebElement userName = driver.findElement(By.id("username-input"));
		WebElement password = driver.findElement(By.id("password-input"));
		WebElement login = driver.findElement(By.id("login-submit-button"));

		userName.sendKeys("user");
		password.sendKeys("password");
		login.click();

		String actualUrl = "https://stage-unicore.denniskirk.com/erp/customer-home";
		String expectedUrl = driver.getCurrentUrl();

		Assert.assertEquals(expectedUrl, actualUrl);

	}

}
