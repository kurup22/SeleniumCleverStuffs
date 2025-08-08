package XcelTests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class AgainExcel {
    public static void main(String[] args) throws IOException {

        AgainExcel ag = new AgainExcel();
        ag.excelMethod("checkout");

    }

    public void excelMethod(String a) throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\VaVe\\Documents\\getData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        ArrayList<String> data = new ArrayList<>();

        int sheetCount = workbook.getNumberOfSheets();

        for (int i = 0; i < sheetCount; i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            if (sheet.getSheetName().equalsIgnoreCase("sheet1")) {
                Iterator<Row> firstrows = sheet.rowIterator();
                Row firstrow = firstrows.next();
                Iterator<Cell> cells = firstrow.iterator();
                int k = 0;
                while (cells.hasNext()) {
                    Cell cell1 = cells.next();

                    if (cell1.getStringCellValue().equalsIgnoreCase("testcase")) {
                        break;


                    }
                    k++;
                }

            while(firstrows.hasNext()){
                Row r=firstrows.next();
                if(r.getCell(k).getStringCellValue().equalsIgnoreCase(a)){
                 Iterator<Cell> ce=r.iterator();
                 while(ce.hasNext()){
                     Cell mc=ce.next();
                     if(mc.getCellType()== CellType.STRING){

                         System.out.println(mc.getStringCellValue());
                     }
                     else if (mc.getCellType()==CellType.NUMERIC){
                         String mmc=String.valueOf(mc.getNumericCellValue());
                     }
                 }
                }



              }

            }


        }


    }
}
