package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriting {

	FileOutputStream fos;
	XSSFWorkbook workbook;
	public ExcelWriting()
	{
		File file = new File(TestConfig.excelFile);
		try {
			fos = new FileOutputStream(file,true);
			workbook = new XSSFWorkbook(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write(String sheetName, int rowNo, int columnNo, String value)
	{
		try
		{
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		sheet.getRow(rowNo).getCell(columnNo).setCellValue(value);
		workbook.write(fos);
		fos.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExcelWriting excelWriting = new ExcelWriting();
		excelWriting.write("Sheet1", 3, "Status", "Passed");
	}
	public void write(String sheetName, int rowNo, String columnName, String value)
	{
		try
		{
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		for (int i=0;i<sheet.getRow(0).getLastCellNum();i++)
		{
			if (sheet.getRow(0).getCell(i).toString().equalsIgnoreCase(columnName))
			{
				sheet.getRow(rowNo).createCell(i).setCellValue(value);
			}
		}
		
		workbook.write(fos);
		fos.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
