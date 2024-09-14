package excelDataReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ConsultationDataReader {
	
	public ArrayList<String> getConsultationData(String testcaseName) throws IOException {
        ArrayList<String> a = new ArrayList<String>();

        FileInputStream fis = new FileInputStream("/home/cubet/Desktop/Selenium/BloomsAutomationProject/Blooms/Data Input Files/ConsultationDetails.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("Consults")) {
                Sheet sheet = workbook.getSheetAt(i);
                DataFormatter dataFormatter = new DataFormatter();

                Row firstrow = sheet.getRow(0);
                int coloumn = 0;
                for (Cell cell : firstrow) {
                    if (dataFormatter.formatCellValue(cell).equalsIgnoreCase("Parameter")) {
                        coloumn = cell.getColumnIndex();
                        break;
                    }
                }

                for (Row row : sheet) {
                    Cell parameterCell = row.getCell(coloumn);
                    if (dataFormatter.formatCellValue(parameterCell).equalsIgnoreCase(testcaseName)) {
                        for (Cell cell : row) {
                            if (cell.getCellType() == CellType.STRING) {
                                a.add(cell.getStringCellValue());
                            } else {
                                a.add(dataFormatter.formatCellValue(cell));
                            }
                        }
                        break; // Break once the desired row is found
                    }
                }
            }
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        // Example usage
        ConsultationDataReader reader = new ConsultationDataReader();
        ArrayList<String> userData = reader.getConsultationData("YourTestCaseName");

        // Process the userData array as needed
        for (String value : userData) {
            System.out.println(value);
        }
    }


}
