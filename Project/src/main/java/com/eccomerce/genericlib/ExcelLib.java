package com.eccomerce.genericlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Payel
 *
 */
public class ExcelLib {

	private static Workbook workbook;
	private static Sheet sheet;
	private static String path;
	private static Properties prop;

	/**
	 * Open and load a sheet from workbook
	 * @param filePath
	 * @param sheetName
	 * @return Sheet specified
	 * @throws Throwable
	 */
	public static String getData(String filePath, String sheetName,int rowNum, int colNum) throws Throwable {
		path = filePath;
		workbook = WorkbookFactory.create(new FileInputStream(filePath));
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		if(row==null)
		row = sheet.createRow(rowNum);
		String data = row.getCell(colNum, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
		return data;
		 
	}

	/**
	 * Get data from the cell
	 * @param rowNum
	 * @param colNum
	 * @return String with cell data
	 * @throws Throwable
	 */
//	public static String getData(int rowNum, int colNum) throws Throwable {
//		Row row = sheet.getRow(rowNum);
//		if(row==null)
//			row = sheet.createRow(rowNum);
//		String data = row.getCell(colNum, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
//		return data;
//	}

	/**
	 * Set a value in a cell
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */
	public static void setData(int rowNum, int colNum, String data) throws Throwable {
		Row row = sheet.getRow(rowNum);
		if(row==null)
			row = sheet.createRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		workbook.write(new FileOutputStream(path));
	}

//	/**
//	 * Get the number of rows in the sheet
//	 * @param filePath
//	 * @param sheetName
//	 * @return 
//	 * @throws Throwable
//	 */
//	public static int getRowCount(String filePath, String sheetName) throws Throwable {
//		getData(filePath, sheetName, 0, 0);
//		return sheet.getLastRowNum(); 
//	}
	
	/**
	 * Close the workbook
	 * @throws Throwable
	 */
	public static void closeBook() throws Throwable {
		workbook.close();
	}

	/**
	 * Open and load properties file
	 * @param filePath
	 * @return Properties file loaded
	 * @throws Throwable
	 */
	public static String getProperty(String filePath , String key) throws Throwable {
		prop = new Properties();
		prop.load(new FileInputStream(filePath));
		return prop.getProperty(key);
	}

}
