package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {


	public String[][] read() throws IOException
	{
		File file = new File(TestConfig.excelFile);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int countOfRows = sheet.getLastRowNum()+1; //always start with 0
		System.out.println("countOfRows are : "+countOfRows);
		int countOfCols = sheet.getRow(0).getLastCellNum(); //always start with 1
		System.out.println("countOfCols are : "+countOfCols);
		String [][] value = new String [countOfRows-1][countOfCols];
		int k=0;
		for (int i=1;i<countOfRows;i++)
		{
			int columnCount = sheet.getRow(i).getLastCellNum();
			for (int j=0;j<columnCount;j++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(j);
				DataFormatter df = new DataFormatter();
				 value[k][j] = df.formatCellValue(cell);
			}
			k++;
		}
		fis.close();
		return value;
	}
}
