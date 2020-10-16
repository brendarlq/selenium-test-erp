package common;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	protected static WebDriver driver;

	@Before
	public void setUp()
	{
		ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
		driver = new ChromeDriver();

		/*
		//For firefox
		FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
		driver = new FirefoxDriver();*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void cleanUp(){
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void tearDown(){
		driver.close();
	}
}
