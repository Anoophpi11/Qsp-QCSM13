package deom.actiTimeGenericUnits;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
/*
 * This methos will return the data from the excel Sheet in the from of String 
 * 
 */
	
	public String getStringData(String filepath,String Sheetname,int rowno,int colno)
	{
	try {
			FileInputStream file = new FileInputStream(filepath);
			Workbook workbook = WorkbookFactory.create(file);
			return workbook.getSheet(Sheetname).getRow(rowno).getCell(colno).getStringCellValue();
		} 
	catch (Exception e) {
			e.printStackTrace();
		}
	  return null;
	}
	
	public double getintegerdata(String filpath, String sheetname, int rownum, int colnum) {
		
	FileInputStream file;
	try {
		file = new FileInputStream(filpath);
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetname).getRow(rownum).getCell(colnum).getNumericCellValue();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return  0.0;
	
		
		
		
	}
	

	
	
	
	
}
