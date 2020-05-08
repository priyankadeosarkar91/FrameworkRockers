package ApachePOI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInExcelHandling{
	@Test(dataProvider="SignInData")
	public void signIn(String userId, String password) {
		System.out.println("Username: "+userId+"\t"+"Password: "+password);
	}
		@DataProvider(name="SignInData")
		public Object[][] readExcelFile() throws IOException  {
			Object[][] obj=null;			
			try {
				FileInputStream fis = new FileInputStream ("D:\\Narayan\\Ecplise_program\\ExcelHandling\\Inpute\\SignIn.xlsx");
				XSSFWorkbook book= new XSSFWorkbook(fis);
				XSSFSheet sheet=book.getSheet("Sheet2");
				int rows=sheet.getLastRowNum();
				int cols=sheet.getRow(0).getLastCellNum();
				obj=new Object[rows][cols-1];
				for(int i=1;i<=rows;i++) {
					Row row=sheet.getRow(i);
					int Columns=row.getLastCellNum();
					for(int j=1;j<Columns;j++) {
						Cell cell=row.getCell(j);
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_BLANK:
							obj[i-1][j-1]="";
							break;
						case Cell.CELL_TYPE_STRING:
							obj[i-1][j-1]=cell.getStringCellValue();
							break;
						
						case Cell.CELL_TYPE_BOOLEAN:
							obj[i-1][j-1]=cell.getBooleanCellValue();
							break;
						case Cell.CELL_TYPE_ERROR:
							obj[i-1][j-1]="e+error";
							break;
						case Cell.CELL_TYPE_NUMERIC:
							obj[i-1][j-1]=cell.getStringCellValue();
							break;	
						default:
							System.out.println("error");
							break;
						}
					}
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			return obj;
			
		}
}
