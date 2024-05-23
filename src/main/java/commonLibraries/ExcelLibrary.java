package commonLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import resources.Base;

public class ExcelLibrary extends Base{
	
	private String username;
	private String password;
	private List<String> unames = new ArrayList<>();
	private List<String> pwords = new ArrayList<>();
	
	public void LoadExcelData() throws EncryptedDocumentException, IOException {
		String path = basePath + "\\src\\main\\java\\testData\\TestData1.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		//Sheet sheet = book.getSheet("Sheet1");
		Sheet sheet = book.getSheetAt(0);
		Row row = sheet.getRow(1);
		username = row.getCell(0).toString();
		password = row.getCell(1).toString();

	}
	
	public void LoadAllExcelData() throws EncryptedDocumentException, IOException {
		String path = basePath + "\\src\\main\\java\\testData\\TestData1.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		//Sheet sheet = book.getSheet("Sheet1");
		Sheet sheet = book.getSheetAt(0);
		int rowCnt = sheet.getLastRowNum();
		Row row = sheet.getRow(0);
		int colCnt= row.getLastCellNum();
		System.out.println("RowCount: " + rowCnt + " : : ColumnCount: " + colCnt);
		for(int i=1;i<=rowCnt;i++) {
			row = sheet.getRow(i);
			for(int j = 0; j<colCnt; j++) {
				Cell cell  = row.getCell(j);
				if(j==0) {
					unames.add(cell.toString());
				}
				else {
					pwords.add(cell.toString());
				}
				
				
			}
			System.out.println();
		}
		

	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

	public List<String> getUnames() {
		return unames;
	}

	public List<String> getPwords() {
		return pwords;
	}
	
	
}
