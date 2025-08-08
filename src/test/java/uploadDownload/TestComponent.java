package uploadDownload;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class TestComponent {


    public int getRowNumber() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\VaVe\\Downloads\\download.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        boolean found=false;
        int k=0;
        while (rows.hasNext()) {
            Row row = rows.next();

            Iterator<Cell> cells = row.iterator();

            while (cells.hasNext()){
                Cell ce=cells.next();
                if(ce.getCellType()== CellType.STRING &&ce.getStringCellValue().equalsIgnoreCase("Apple")){
                   found=true;
                    break;


                }

            }
      if(found) {
          break;
      }
    k++;

            //return k;

        }
        return k;
    }

        public int getColumn() throws IOException {
            FileInputStream fis=new FileInputStream("C:\\Users\\VaVe\\Downloads\\download.xlsx");
            XSSFWorkbook workbook=new XSSFWorkbook(fis);
            XSSFSheet sheet=workbook.getSheetAt(0);
            Iterator<Row> rows= sheet.iterator();
            Row firstRow=rows.next();
            Iterator<Cell> firstRowCells= firstRow.iterator();
            int k=0;
            while (firstRowCells.hasNext()){
                Cell cell=firstRowCells.next();
                if(cell.getStringCellValue().contains("rice")){
                    break;

                }
                k++;
            }

            return k;

        }

        public void updateCell(int row, int col){


        }

        }




