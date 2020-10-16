package test;


import static org.testng.AssertJUnit.assertTrue;

import common.BaseTest;
import org.junit.Test;
import org.testng.Assert;
import webpages.CustomerHomePage;
import webpages.LoginPage;

public class LoginPageTest extends BaseTest
{

	LoginPage loginPage;

	@Test
	public void loginTestSuccessful()
	{
		driver.get("https://stage-unicore.denniskirk.com/erp/login");


		loginPage = new LoginPage(driver);
		assertTrue(loginPage.isInitialized());

		CustomerHomePage customerHomePage = loginPage.login("user","pass" );

		assertTrue(customerHomePage.isInitialized());
		Assert.assertEquals("Dennis Kirk Enterprise: Customer Service", customerHomePage.confirmationHeader());
	}

}
