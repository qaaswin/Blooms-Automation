package excelDataReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CredentialDataReader {
    
    public ArrayList<String> getData(String testcaseName) throws IOException {
        
        ArrayList<String> a = new ArrayList<String>();

        // fileInputStream argument
        String filePath = System.getProperty("user.dir") + "/src/main/java/blooms/Resources/LoginCredentials.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        
        //1. Create object for XSSDWorkbook Class - To hold excel
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //2. Get access to sheet with sheet name
        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            //checking sheet name as credentials
            if (workbook.getSheetName(i).equalsIgnoreCase("Credentials")) {
                
                XSSFSheet sheet = workbook.getSheetAt(i);
                
                //3. Get access to all rows of sheet
                java.util.Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
                Row firstrow = rows.next();
                java.util.Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells
                int k = 0;
                int coloumn = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();
                    
                    //Checking column name as parameter
                    if (value.getStringCellValue().equalsIgnoreCase("Parameter")) {
                        coloumn = k;
                    }
                    k++;
                }

                //4.Get access to specific row
                while (rows.hasNext()) {
                    Row r = rows.next();

                    //Specific row name passing from code
                    if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {
                        
                        //5. Access data from each cell into arrays
                        java.util.Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                a.add(c.getStringCellValue());
                            } else {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        // Test the method
        CredentialDataReader reader = new CredentialDataReader();
        ArrayList<String> data = reader.getData("Testcase1");
        for (String value : data) {
            System.out.println(value);
        }
    }
}
