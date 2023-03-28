package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllData {
    public static void main(String[] args) throws Exception {
		File f = new File(".\\Excel\\username.xlsx");
	
    // Read data from excel
		FileInputStream fl = new FileInputStream(f);
    // get excel sheet
		XSSFWorkbook book = new XSSFWorkbook(fl);
		Sheet sh = book.getSheet("data");
	// To fetch the row
		for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
			Row r = sh.getRow(i);
	// to fetch  the cell
		 for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			 Cell c = r.getCell(j);
		 
  // to fetch cell type
		CellType cellType = c.getCellType();
		if (c.equals(cellType.STRING)) {
			String stringCellValue = c.getStringCellValue();
			System.out.println(stringCellValue);
			
		}
		else if (c.equals(cellType.NUMERIC)) {
			double d1 = c.getNumericCellValue();
			 long l =(long)d1;
			 String valueOf = String.valueOf(l);
			 System.out.println(valueOf);
			
			
		}
			


}

}
		 
		System.out.println("successs");

		book.close();
	
    }
}