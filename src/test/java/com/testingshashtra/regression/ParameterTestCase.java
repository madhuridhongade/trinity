package com.testingshashtra.regression;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTestCase {
	
	@Test
	public void testCaseFirst() {
		
		System.out.println("First Test Case");
	}
	
	@Test(invocationCount = 0, description = "This test case runs 0 times means it will not run")
	public void secondTestCase() {
		
		System.out.println("Second Test Case");
	}
	
	@Test(invocationCount = 3, description = "This test case runs 3 times")
	public void m1() {
		
		System.out.println("m1 Test Case");
	}
	
	
	@Test(timeOut = 3000,description = "This test case run in 3000 ms but sleep time is 4000 ms so it will throw exception means this test case failes")
	public void thirdTestCase() {
		
		System.out.println("Third Test Case");
		
		try {
			Thread.sleep(4000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Test(expectedExceptions = {ArrayIndexOutOfBoundsException.class,RuntimeException.class})
	public void m2() throws InterruptedException {
		System.out.println("m2 Test Case");
		Thread.sleep(3000);
	} 
	
	//depedency method m4() is depend on m3()..Execute m4 first then m3 
	
	@Test(dependsOnMethods = "m4")
	public void m3() {
		System.out.println("m3 Test Case");
	}
	
	@Test
	public void m4() {
		System.out.println("m4 Test Case");
		throw new ArrayIndexOutOfBoundsException();
	}
	
	@Parameters({"rollNo","name"})
	@Test(groups = "Sanity")
	public void TestCaseparameter(int rollNo, String name) 
	{
		System.out.println(rollNo+"\t"+name);
	}
	

}
