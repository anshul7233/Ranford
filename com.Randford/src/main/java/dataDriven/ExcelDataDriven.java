package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import testBase.Base;

public class ExcelDataDriven extends Base {

	public static String folderPath = Base.config("excelFolderPath");
	static Workbook wb;
	static Sheet sh;
	static WritableWorkbook wwb;
	static WritableSheet wsh;

	public static void excelConnection(String fileName, String sheetName) {

		try {
			File f = new File(folderPath + fileName);
			wb = Workbook.getWorkbook(f);
			sh = wb.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int rcount() {

		int r = sh.getRows();
		return r;
	}

	public static int ccount() {
		int c = sh.getColumns();
		return c;
	}

	public static String readData(int col, int row) {

		String cell = sh.getCell(col, row).getContents();
		return cell;
	}

	public static void outputExcelConnection(String ifilename, String ofilename, String sheetname) {

		try {
			FileInputStream fis = new FileInputStream(folderPath + ifilename);
			wb = Workbook.getWorkbook(fis);
			sh = wb.getSheet(sheetname);

			FileOutputStream fos = new FileOutputStream(folderPath + ofilename);
			wwb = Workbook.createWorkbook(fos, wb);
			wsh = wwb.getSheet(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeData(int col, int row, String data) {

		try {
			Label l=new Label(col, row, data);
			wsh.addCell(l);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void saveWorkbook() {

		try {
			wwb.write();
			wwb.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
