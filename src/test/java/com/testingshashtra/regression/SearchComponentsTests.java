package com.testingshashtra.regression;

import java.util.Iterator;

//program for open chrome browser using @Test annotation search for Sneakers and print product titles
//it extends from TestBase class which is located in src/main/java
//open br

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.testingshashtra.TestBase;

public class SearchComponentsTests extends TestBase {
	
	@Test
	public void verifySearchResultsArePopulatingCorrectResultsForMenSneakers() 
	{
		RemoteWebDriver driver = TestBase.openBrowser();
		//RemoteWebDriver driver = new ChromeDriver();
		//driver.get("https://www.myntra.com/");
		driver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]")).sendKeys("Men Sneakers",Keys.RETURN);
	
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class=\"product-productMetaInfo\"]/h4[@class=\"product-product\"]"));
	
		Iterator<WebElement> itr = productList.iterator();
		while(itr.hasNext())
		{
			String productTitle = itr.next().getText();
			System.out.println("Checking : "+productTitle);
			Assert.assertTrue(productTitle.contains("Sneakers"));
		}
	}
	

}
