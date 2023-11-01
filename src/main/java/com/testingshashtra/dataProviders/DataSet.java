package com.testingshashtra.dataProviders;

//program 1 for print the pincode using data provider. @DataProvider(name = "Pincode data") file is in src/test/java
// under package com.testingshashtra.regression. under class DataProviderTesting.

//program 2 for read hard coded excel file. @DataProvider(name = "Excel read data") is placed in file is in src/test/java 
//under package com.testingshashtra.regression. under class DataProviderTesting

import org.testng.annotations.DataProvider;

import com.testingshashtra.utilities.Excelutil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataSet<ExcelUtil> {
	

	//@DataProvider(name = "Pincode data")
	public Object[][] pinCodeData() {
		String[][] pincodes = {{"411014"},
							   {"411011"},
							   {"411012"},
							   {"411010"},
							   {"411067"}};
		
		return pincodes;
		
	}
	
	//Read excel and load data into 2D object array
	//Apache: POI
	
	@DataProvider(name = "Excel read data")
	 public String[][] excelReadData() throws IOException {
		 
		 FileInputStream fis = new FileInputStream("E:/Carnation23/Maven Dependencies/Readexcel.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Pincodes");
		
		//Declared array
		String[][] excelread = new String[sheet.getLastRowNum()][1];
		
		//filled the array value
		
		for (int i = 1; i<=sheet.getLastRowNum(); i++) {
			
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(1);
			String pincode = cell.getStringCellValue();
			
			excelread[i-1][0]= pincode;
			
			//System.out.println(pincode);
		}
		
		return excelread;
		 
	 }
	
	
	@DataProvider(name = "Pincode data") 
	public String[][] pinCodeData1()
	{
		ExcelUtil excel = new Excelutil();
		String[][] pincodes = (String[][])excel.loadExcelIn2DArray("/src/test/resources/Pincodes.xlsx");
		return pincodes;
		
		
	}
	
	
}
