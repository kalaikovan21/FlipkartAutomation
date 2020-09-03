package com.flipkart.qa.testcases;

import org.testng.annotations.Test;

import com.flipkart.qa.baseclass.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title= loginPage.loginPageTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(priority = 2)
	public void createAccountLinkTest() {
		Assert.assertTrue(loginPage.accountCreateLink());
	}

	@Test(priority =3)
	public void loginToApplicationTest() {
		homePage = loginPage.loginToApplication(property.getProperty("username"), property.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
