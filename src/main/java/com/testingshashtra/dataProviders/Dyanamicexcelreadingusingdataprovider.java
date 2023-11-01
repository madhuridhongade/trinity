package com.testingshashtra.dataProviders;

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
import org.testng.annotations.DataProvider;

public class Dyanamicexcelreadingusingdataprovider {
	
	
	@DataProvider(name = "Dynamic excel read data")
	public String[][] excelReadData() throws IOException {
		 
		String dir = System.getProperty("user.dir");// current working directory path
		System.out.print(dir);

		//String filepath = "E:/Carnation23/Maven Dependencies/Readexcel.xlsx";
		String filepath = dir+"/src/test/resources/resources/Readexcel.xlsx"; 
		 FileInputStream fis = new FileInputStream(filepath);
		 
		 Workbook book;
		 String[] parts = filepath.split(".");
		 String [][] pincodes=null;
		 
		 if(parts[1].equalsIgnoreCase("xls"))
		 {
			book = new HSSFWorkbook(fis); 
			HSSFSheet sheet =(HSSFSheet)book.getSheet("Pincodes");
			String[][] excelread = new String[sheet.getLastRowNum()][1];
			pincodes = new String[sheet.getLastRowNum()][1];
			
			for (int i = 1; i<=sheet.getLastRowNum(); i++) {
				
				HSSFRow row = sheet.getRow(i);
				HSSFCell cell = row.getCell(1);
				String pincode = cell.getStringCellValue();
				
				excelread[i-1][0]= pincode;
			}
			
		 }else if(parts[1].equalsIgnoreCase("xlsx"))
		 {
			 book = new XSSFWorkbook(fis);
			 book = new XSSFWorkbook(fis);
			 XSSFSheet sheet =(XSSFSheet)book.getSheet("Pincodes");
			pincodes = new String[sheet.getLastRowNum()][1];
		
			//Declared array
			String[][] excelread = new String[sheet.getLastRowNum()][1];
		
				
		for (int i = 1; i<=sheet.getLastRowNum(); i++) {
			
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(1);
			String pincode = cell.getStringCellValue();
			
			excelread[i-1][0]= pincode;
			
			//System.out.println(pincode);
		}

}
		 return pincodes;
	}
}
	
