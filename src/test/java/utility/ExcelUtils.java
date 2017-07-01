package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	public static void setExcelFile(String path, String sheetName) throws Exception
	{
		try 
		{
			FileInputStream fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static String getCellData(int RowNum, int ColNum) throws Exception
	{
		try
		{
		row=sheet.getRow(RowNum);
		cell=row.getCell(ColNum);
		String data=cell.getStringCellValue();
		return data;
		}
		catch(Exception e)
		{
			return "";
		}
	}
	public static void setCellData(String value, int RowNum,int ColNum) throws Exception
	{
		try
		{
			row=sheet.getRow(RowNum);
			cell=row.getCell(ColNum, row.RETURN_BLANK_AS_NULL);
			if(cell==null)
			{
				cell=row.createCell(ColNum);
				cell.setCellValue(value);
			}
			else
			{
				cell.setCellValue(value);
			}
			FileOutputStream fos=new FileOutputStream(Constants.file_path+Constants.file_name);
			workbook.write(fos);
			fos.flush();
			fos.close();	
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
   
}
