package org.genric;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadData {
	public static String readValue(String key) throws Exception {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("./Data/app.properties");
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

	public static String getCellValue(String path, String sheet_name, int r, int c) throws Exception {
		String val = "";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet_name);
		Cell cl = sh.getRow(r).getCell(c);
		val = cl.toString();
		return val;
	}

	@DataProvider
	public String[][] readAllCellValue(String path, String sheet_name) throws Exception {
		String[][] st;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet_name);
		st = new String[sh.getLastRowNum() - 1][sh.getRow(0).getLastCellNum()];
		for (int i = 1; i < sh.getLastRowNum(); i++) {
			for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) {
				Cell cl = sh.getRow(i).getCell(j);
				st[i - 1][j] = cl.toString();
			}

		}
		return st;
	}

}
