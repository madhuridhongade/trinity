package com.testingshashtra.regression;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ATest {
	
	@BeforeMethod
	public void m1() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void m12() {
		System.out.println("After Method");

	}
	
	@Test
	public void m2()
	{
		System.out.println("Test case of m2");
	}
	
	@Test
	public void m11()
	{
		System.out.println("Test case of m11");
	}
	
	@Test(groups = "Sanity")
	public void groupTestOfATest() {
		System.out.println("These are group test case of A Class ");
	}
	
	//@parameter test case
	@Parameters({"rollNo","name"})
	@Test(groups = "Sanity")
	public void parameterTestCase(int rollNo, String name) 
	{
		System.out.println(rollNo+"\t"+name);
	}

}
