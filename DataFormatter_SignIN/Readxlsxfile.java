package com.keywords.utilties;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class Readxlsxfile {
		@Test(dataProvider = "SignInData")
		public void verifyLogin(String Username, String Password) {
			System.out.println("/t,Username" + Username+ "Password=" + Password);
		}
		@DataProvider(name="SignInData")
		public Object[][] readExcelfile() throws IOException {
			Object[][]obj=null;
			try {
				FileInputStream fis =new FileInputStream("src/main/resources/DataProvider.xlsx");
				XSSFWorkbook book =new XSSFWorkbook(fis);
				XSSFSheet sheet=(XSSFSheet)book.getSheet("Sheet1");
			
				int rows =sheet.getLastRowNum();
				int cols=sheet.getRow(0).getLastCellNum();
				
				obj=new Object[rows][cols-1];
			
				DataFormatter format=new DataFormatter();
			
				for(int i=1;i<=rows;i++) {
					XSSFRow row=sheet.getRow(i);
					int columns=row.getLastCellNum();
					for(int j=1;j<columns;j++) {
						XSSFCell cell=row.getCell(j);		
						obj[i-1][j-1]=format.formatCellValue(cell);
						
					}
				}
				
			fis.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return obj;
		}
	}


