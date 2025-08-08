package XcelTests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GetDataFromExcel {
    public static void main(String[] args) {
        GetDataFromExcel getDataFromExcel = new GetDataFromExcel();
        try {
           System.out.println(getDataFromExcel.GetData("welcome"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> GetData(String TestCase) throws IOException {

        ArrayList<String> data = new ArrayList<>();

        FileInputStream fis = new FileInputStream("C:\\Users\\VaVe\\Documents\\getData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheetCount = workbook.getNumberOfSheets();


        for (int i = 0; i < sheetCount; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rowIterator = sheet.iterator();
                Row firstRow = rowIterator.next();
                Iterator<Cell> cellIterator = firstRow.iterator();
                int k = 0;

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getStringCellValue().equalsIgnoreCase("TestCase")) {

                        break;

                    }
                    k++;
                }
                System.out.println("Column number of TestCase: " + k);

                while (rowIterator.hasNext()) {
                    int rows = 0;
                    Row row = rowIterator.next();
                    if (row.getCell(k).getStringCellValue().equalsIgnoreCase(TestCase)) {

                        Iterator<Cell> cellIterator1 = row.cellIterator();
                        while (cellIterator1.hasNext()) {
                            Cell cell1 = cellIterator1.next();

                            if (cell1.getCellType() == CellType.STRING) {
                                // Assuming you want to collect string values
                                data.add(cell1.getStringCellValue());
                            } else if (cell1.getCellType() == CellType.NUMERIC) {

                                data.add(String.valueOf(cell1.getNumericCellValue()));
                                // If you want to handle numeric values, you can convert them to strin
                            }


                        }
                        break;
                    }


                }
            }
        }
        return data;
    }
}