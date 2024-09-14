package excelDataReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserDataReader {

    public ArrayList<String> getData(String testcaseName) throws IOException {

        ArrayList<String> a = new ArrayList<String>();

        // Dynamic file path
        String filePath = System.getProperty("user.dir") + "/src/main/java/blooms/Resources/UsersData.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        // 1. Create object for XSSFWorkbook Class - To hold excel
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // 2. Get access to sheet with sheet name
        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            // checking sheet name as users
            if (workbook.getSheetName(i).equalsIgnoreCase("Users")) {

                XSSFSheet sheet = workbook.getSheetAt(i);

                // 3. Get access to all rows of sheet
                java.util.Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
                Row firstrow = rows.next();
                java.util.Iterator<Cell> ce = firstrow.cellIterator(); // row is collection of cells
                int k = 0;
                int column = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();

                    // Checking column name as parameter
                    if (value.getStringCellValue().equalsIgnoreCase("Parameter")) {
                        column = k;
                    }
                    k++;
                }

                // 4. Get access to specific row
                while (rows.hasNext()) {
                    Row r = rows.next();

                    // Specific row name passing from code
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {

                        // 5. Access data from each cell into arrays
                        java.util.Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                a.add(c.getStringCellValue());
                            } else if (c.getCellType() == CellType.NUMERIC) {
                                if (DateUtil.isCellDateFormatted(c)) {
                                    Date date = c.getDateCellValue();
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                                    a.add(dateFormat.format(date));
                                } else {
                                    a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                                }
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        UserDataReader reader = new UserDataReader();
        ArrayList<String> data = reader.getData("TestCase1"); // Use the appropriate test case name
        for (String value : data) {
            System.out.println(value);
        }
    }
}
