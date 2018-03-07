package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	///
	XSSFSheet sheet;
	XSSFRow row;

	public ExcelDataProvider(String ExcelPath) {

		// File src =new File("./ApplicationTestData/SCLogin.xlsx");

		File src = new File(ExcelPath);

		try {

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

		}

		catch (Exception e) {
			System.out.println("Exception is :" + e.getMessage());
		}

	}

	public String getData(int sheetIndex, int row, int coloumn) {

		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(coloumn).getStringCellValue();

		return data;

	}

	public String getData(String sheetName, int row, int coloumn) {

		String data = wb.getSheet(sheetName).getRow(row).getCell(coloumn).getStringCellValue().toString();

		return data;

	}

	public int getRowCount(int Index) {
		int row = wb.getSheetAt(Index).getPhysicalNumberOfRows();
		row = row++;

		return row;

	}

}
/*
 * public String getCellData(String sheetName, String colName,int rownum){ int
 * col_num=0; int index=wb.getSheetIndex(sheetName); sheet=wb.getSheetAt(index);
 * XSSFRow row1=sheet.getRow(0); for(int i=1;i<row1.getLastCellNum(); i++){
 * if(row1.getCell(i).getStringCellValue().equals(colName)) { col_num=i; }
 * 
 * } row1=sheet.getRow(rownum-1);
 * 
 * XSSFCell cell=row1.getCell(col_num);
 * 
 * if(cell.getCellType()==cell.CELL_TYPE_STRING){ return
 * cell.getStringCellValue(); } else if
 * (cell.getCellType()==cell.CELL_TYPE_NUMERIC){ return
 * String.valueOf(cell.getNumericCellValue()); } else if
 * (cell.getCellType()==cell.CELL_TYPE_NUMERIC){ return
 * String.valueOf(cell.getNumericCellValue()); } return null; }
 * 
 * 
 * }
 */
