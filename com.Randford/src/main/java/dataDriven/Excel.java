package dataDriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
public static String dataFromExcel(String sheet, int row, int column){
	Workbook wb = null;
	
	try {
		FileInputStream	fis = new FileInputStream("D:\\java_bank\\project\\com.Randford\\Excel\\data.xlsx");
		 wb = new XSSFWorkbook(fis);
	
		
	}  catch (Exception e) {
		e.printStackTrace();
	}
	return wb.getSheet(sheet).getRow(row).getCell(column).toString();
	
	
}

}
