package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class GettingValueFromExcel
{
	static FileInputStream fis=null;
	static XSSFWorkbook workbook=null;
	static XSSFSheet sheet=null;
	static DataFormatter format =new DataFormatter();
	public static void readExcel() throws Exception {
	 fis=new FileInputStream(new File("C:\\Users\\logan\\eclipse-workspace\\FBDobFromDropDown\\Resources\\data.xlsx"));
	 //created a work book
	 workbook=new XSSFWorkbook(fis);
	 //getting the sheet
	 sheet=workbook.getSheetAt(0);
	}
	//getting url value form the excel file 
	public static String getUrl()
	{
		 String url=format.formatCellValue(sheet.getRow(0).getCell(1));
		 return url;
	}
	//getting firstname value form the excel file 
	public static String getFirstName()
	{
		 String firstname=format.formatCellValue(sheet.getRow(1).getCell(1));
		 return firstname;
	}
	//getting lastname value form the excel file 
	public static String getLastName()
	{
		 String lastName=format.formatCellValue(sheet.getRow(2).getCell(1));
		 return lastName;
	}
	//getting mobile number value form the excel file 
	public static String getMobileNum()
	{
		 String mobile=format.formatCellValue(sheet.getRow(3).getCell(1));
		 return mobile;
	} 
	//getting password value form the excel file 
	public static String getPassword()
	{
		 String password=format.formatCellValue(sheet.getRow(4).getCell(1));
		 return password;
	}
	//getting day value form the excel file 
	public static String getday()
	{
		 String day=format.formatCellValue(sheet.getRow(5).getCell(1));
		 return day;
	}
	//getting month value form the excel file 
	public static String getMonth()
	{
		 String month=format.formatCellValue(sheet.getRow(6).getCell(1));
		 return month;
	}
	//getting year value form the excel file 
	public static String getYear()
	{
		 String year=format.formatCellValue(sheet.getRow(7).getCell(1));
		 return year;
	}
 
}
