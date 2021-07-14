package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	public static Object[][] getTableArray(String FilePath,String SheetName) throws Exception{
	String[][] tabArray=null;	
	try{
		FileInputStream ExcelFile=new FileInputStream(FilePath);
		ExcelWBook=new XSSFWorkbook(ExcelFile);
		ExcelWSheet=ExcelWBook.getSheet(SheetName);
		int startRow=1;
		int startCol=1;
		int ci,cj;
		int totalRows=ExcelWSheet.getLastRowNum();
		int totalCols=3;
		tabArray=new String[totalRows][totalCols];
		ci=0;
		for(int i=startRow;i<=totalRows;i++, ci++){
			cj=0;
			for(int j=startCol;i<=totalCols;j++, cj++){
				tabArray[ci][cj]=getCellData(i,j);
				System.out.println(tabArray[ci][cj]);
			}
		}
	}
	catch(IOException e){
		System.out.println("could not read the Excel sheet");
		e.printStackTrace();
	}
	return(tabArray);
	}
	public static String getCellData(int RowNum,int ColNum)throws Exception{
		try{
			int data=0;
			Cell=ExcelWSheet.getRow(RowNum).getCell(ColNum);
		    CellType d= Cell.getCellType();
		   
			 System.out.println("data"+Cell.getCellType());
			if (data==3){
				return "";
			}else {
				String CellData=Cell.getStringCellValue();
				return CellData;
			}
			
		}
			catch (Exception e){
				System.out.println(e.getMessage());
				throw (e);
			}
		
		}
	
}

