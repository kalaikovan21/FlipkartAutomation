package com.flipkart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.baseclass.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.OfferZonePage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	OfferZonePage offerZonePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		offerZonePage = new OfferZonePage();
		homePage = loginPage.loginToApplication(property.getProperty("username"), property.getProperty("password"));
	}

	@Test(priority = 1)
	public void flipkartLogoTest() {
		Assert.assertTrue(homePage.flipkartLogo());
	}

	@Test(priority = 2)
	public void menShirtsLinkVisibilityTest() {
		Assert.assertTrue(homePage.menShirtsLinkVisibility());
	}

	@Test(priority = 3)
	public void offerZoneAvailabilityTest() {
		offerZonePage = homePage.offerZoneAvailability();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
