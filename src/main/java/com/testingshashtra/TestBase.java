package com.testingshashtra;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBase {
	
	public static RemoteWebDriver driver;
	
	//@Test
	//@Parameters(" browser-name")
	@BeforeMethod
	public static RemoteWebDriver openBrowser()
	{
		
		//driver.get("https://www.myntra.com");
		driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		return driver;	
	}
		
	@AfterMethod
	public void tearDown() {
	
	driver.quit();
	}
	
	

}
