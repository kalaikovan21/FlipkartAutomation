package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.baseclass.TestBase;
import com.flipkart.qa.util.TestUtil;
 

public class HomePage extends TestBase {
	
	TestUtil testUtil;
	LoginPage loginPage;
	
	OfferZonePage offerZonePage;
	
	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement flipkartLogo;
	
	@FindBy(xpath="//a[text()='Men Shirts']")
	WebElement menShirtsLink;
	
	@FindBy(xpath="//a[@class='_1QZ6fC']//span[text()='Offer Zone']")
	WebElement offerZone;
	
	public HomePage() {
		loginPage = new LoginPage();
		offerZonePage = new OfferZonePage();
		PageFactory.initElements(driver, this);
	}
	
	public boolean flipkartLogo() {
		return flipkartLogo.isDisplayed();
	}
	
	public boolean menShirtsLinkVisibility() {
		testUtil.scrollDown(driver);
//		testUtil.explicitlyWait(driver, menShirtsLink, 10);
		return menShirtsLink.isDisplayed();
	}
	
	public OfferZonePage offerZoneAvailability() {
		offerZone.click();
		return new OfferZonePage();
	}

}
