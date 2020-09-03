package com.flipkart.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.flipkart.qa.util.TestUtil;
import com.flipkart.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties property;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//constructor for the TestBase class
	public  TestBase()  {
		
		//Read the properties from the config file
		 property = new Properties();
		FileInputStream file;
		
		try {
			file = new FileInputStream("D:\\Workspaces\\JavaPractise\\MavenProject\\PageObjectModel\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
			property.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	//Initializing the Web application
	public static void initialization() {
		
		String browserName = property.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "//D:/Selenium/selenium-java-3.141.59/Driver/chromedriver.exe");
			 driver =  new ChromeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "//D:/Selenium/selenium-java-3.141.59/Driver/geckodriver.exe");
			 driver =  new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//launch URL
		driver.get(property.getProperty("URL"));
	}

}
