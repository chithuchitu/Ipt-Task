package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.cli.Main;

public class ReadData {
	
	public static void main(String[] args) throws IOException {
		File f = new File(".\\Excel\\username.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sh = book.getSheet("data");
		for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
			Row r = sh.getRow(i);
			for (int j = 0; j <r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				CellType CellType = c.getCellType();
				if (c.equals(CellType.STRING)) {
					String str = c.getStringCellValue();
					System.out.println(str);

				}
				 
				else if (c.equals(CellType.NUMERIC)) {
					double d1 = c.getNumericCellValue();
					long l= (long)d1;
					String str1 = String.valueOf(l);
					System.out.println(str1);


				}
			}


		}

//book.close();
	}

}
