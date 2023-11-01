package com.testingshashtra.regression;

import java.sql.Driver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CrossBrowsingBaseClass {

	protected RemoteWebDriver driver;
	
	@Parameters("browser-name")
	//@BeforeMethod
	public RemoteWebDriver setUp(String browserName)
	{
		if (browserName.equalsIgnoreCase("Chrome"))
		 driver = new ChromeDriver();
		
	
		else if(browserName.equalsIgnoreCase("Firefox"))
		
			driver = new FirefoxDriver();
		
		
		else 
			System.err.println("Invalid browser name: "+browserName);
		driver.get("https://www.myntra.com");
		return driver;
		
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		}
}