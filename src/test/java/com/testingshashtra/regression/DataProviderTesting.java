package com.testingshashtra.regression;

//prog for DataProvider 
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import org.testng.annotations.Test;

import com.testingshashtra.dataProviders.DataSet;

import java.awt.image.BufferedImage;

public class DataProviderTesting {
	
	@Test(dataProvider = "Pincode data", dataProviderClass = DataSet.class)
	public void m2(String pincode) {
		
		System.out.println("Pincode: "+pincode);
	}
	
	@Test(dataProvider = "Excel read data", dataProviderClass = DataSet.class )
	public void m3(String excel) {
		
		System.out.println("excel :"+excel);
	}
	
	
	//We can get the path of current directory using user.dir
	@Test
	public void m4() {
		String dir = System.getProperty("user.dir");// current working directory path
		System.out.print(dir);

	}
	
	

}
