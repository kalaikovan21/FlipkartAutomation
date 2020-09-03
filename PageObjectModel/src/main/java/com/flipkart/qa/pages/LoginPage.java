package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.baseclass.TestBase;

public class LoginPage extends TestBase {
	
	
	//Page Factory /Object repository of login page
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement submitBtn;
	
	@FindBy(linkText="New to Flipkart? Create an account")
	WebElement accountCreateLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean accountCreateLink() {
		boolean accountCreate = accountCreateLink.isDisplayed();
		return accountCreate;
	}
	
	public HomePage loginToApplication(String usrname,String pwd) {
		username.sendKeys(usrname);
		password.sendKeys(pwd);
		submitBtn.click();
		return new HomePage();
	}

}
