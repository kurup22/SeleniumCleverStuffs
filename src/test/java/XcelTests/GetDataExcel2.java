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

public class GetDataExcel2 {
    public static void main(String[] args) throws IOException {

        GetDataExcel2 getOp=new GetDataExcel2();
        System.out.println(getOp.getData2("fuckogg"));

    }

    public ArrayList<String> getData2(String testCase) throws IOException {

        FileInputStream fis= new FileInputStream("C:\\Users\\VaVe\\Documents\\getData.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        ArrayList<String> data= new ArrayList<>();
        int SheetCount= workbook.getNumberOfSheets();

        for (int i=0;i<SheetCount;i++){
            XSSFSheet sheet= workbook.getSheetAt(i);
            if (sheet.getSheetName().equalsIgnoreCase("Sheet1")){
                Iterator<Row> rows=sheet.iterator();
                Row firstRow=rows.next();
                Iterator<Cell> firstRowCells=firstRow.iterator();
                int k=0;
                while (firstRowCells.hasNext()){
                    
                    Cell firstCell= firstRowCells.next();
                    if (firstCell.getStringCellValue().equalsIgnoreCase("TestCase")){

                        break;

                    }
                    k++;
                }
 System.out.println(k);
                while(rows.hasNext()){
                    Row row2=rows.next();
                    if(row2.getCell(k).getStringCellValue().equalsIgnoreCase(testCase)){
                     Iterator<Cell> dataCell=row2.iterator();
                     while(dataCell.hasNext()){
                         Cell ce=dataCell.next();
                         if (ce.getCellType()== CellType.STRING){

                             data.add(ce.getStringCellValue());

                         }
                 else if (ce.getCellType()== CellType.NUMERIC)
                     data.add(String.valueOf(ce.getNumericCellValue()));
                     }

                    }

                }
            }


        }
return data;
    }
}
