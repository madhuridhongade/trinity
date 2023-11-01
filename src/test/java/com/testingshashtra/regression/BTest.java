package com.testingshashtra.regression;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BTest {
	
	@BeforeClass
	public void m3() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public void m8() {
			System.out.println("After class");
	}
	
	@BeforeTest
	public void m4() {
		System.out.print("Before Test");
	}
	
	@BeforeSuite
	public void m5() {
		System.out.println("Before Suite");
	}
	
	@Test
	public void m6() {
		System.out.println("This is test case 6");
	}
	
	@Test
	public void m7()
	{
		System.out.println("This is test case 7");
	}
	
	@AfterTest
	private void m9() {
		System.out.print("After Test");

	}
	
	@Test(groups = "Sanity")
	public void groupTestOfBTest() {
		System.out.println("These are group test case of B class");
	}
	
	@Test(groups = "Sanity")
	public void sanityTestCase1() {
		System.out.println("These are group test case of SanityTestCase1 class");
	}
	
	
	//This is Hard assert
	@Test(groups= "Sanity")
	public void stringSanityHardAssertTestcase() {
		String s1 = "Hi";
		String s2 = "Hello";
		String s3 = "hi";
		String s4 = "hello";
		String s5 = "Hello";
		
		
		Assert.assertEquals(s1, s2);
		Assert.assertEquals(s2, s5);
	}
	
	//This is soft assert. if you put assertAll() method then it throws error otherwise it pass all
	@Test(groups = "Sanity")
	private void stringSoftAss() {
		String s1 = "Hi";
		String s2 = "Hello";
		String s3 = "hi";
		String s4 = "hello";
		String s5 = "Hello";
		
		SoftAssert softly = new SoftAssert();
		softly.assertEquals(s1, s2);
		softly.assertEquals(s2, s5);
		softly.assertAll();
	}
	
	
}
