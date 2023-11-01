package com.testingshashtra.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutil {
	/**
	 * This method will load specified excel into a 2D {@code Object} array
	 * @param filepath
	 * @return Object array representation of the specified excel sheet
	 * @throws IOException 
	 */
	public Object[][] loadExcelIn2DArray(String filepath, String sheetName) throws IOException {
		
		
		String dir = System.getProperty("user.dir");// current working directory path
		System.out.print(dir);

		//String filepath = "E:/Carnation23/Maven Dependencies/Readexcel.xlsx";
		//String filepath = dir+"/src/test/resources/resources/Readexcel.xlsx"; 
		 FileInputStream fis = new FileInputStream(filepath);
		 
		 Workbook book;
		 String[] parts = filepath.split(".");
		 Object [][] data=null;
		 
		 if(parts[1].equalsIgnoreCase("xls"))
		 {
			book = new HSSFWorkbook(fis); 
			HSSFSheet sheet =(HSSFSheet)book.getSheet(sheetName);
			String[][] excelread = new String[sheet.getLastRowNum()][1];
			data = new String[sheet.getLastRowNum()][1];
			
			for (int i = 1; i<=sheet.getLastRowNum(); i++) {
				
				HSSFRow row = sheet.getRow(i);
				int lastCell = row.getLastCellNum();
				for(int j = 0; j<lastCell; j++)
				{
					HSSFCell cell = row.getCell(j);
					switch (cell.getCellTypeEnum()) {
					case STRING:
						data[i][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[i][j] = cell.getNumericCellValue();
					default:
						break;
					}
				}
			}
			
		 }else if(parts[1].equalsIgnoreCase("xlsx"))
		 {
			 book = new XSSFWorkbook(fis);
			
			 XSSFSheet sheet =(XSSFSheet)book.getSheet(sheetName);
			data = new String[sheet.getLastRowNum()][1];
		
			//Declared array
			String[][] excelread = new String[sheet.getLastRowNum()][1];
			
			for (int i = 1; i<=sheet.getLastRowNum(); i++) {
				
				XSSFRow row = sheet.getRow(i);
				int lastCell = row.getLastCellNum();
				for(int j = 0; j<lastCell; j++)
				{
					XSSFCell cell = row.getCell(j);
					switch (cell.getCellTypeEnum()) {
					case STRING:
						data[i][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[i][j] = cell.getNumericCellValue();
					default:
						break;
					}
				}
			}
		 
		 }
		return data;

	}

	
}