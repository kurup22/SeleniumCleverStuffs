package uploadDownload;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

        public void updateCell() throws IOException {
            FileInputStream fis=new FileInputStream("C:\\Users\\VaVe\\Downloads\\download.xlsx");
            XSSFWorkbook workbook=new XSSFWorkbook(fis);
            XSSFSheet sheet=workbook.getSheetAt(0);
             int row=getRowNumber();
             int col=getColumn();
             Row mrow=sheet.getRow(row);
             Cell cell=mrow.getCell(col);
             cell.setCellValue("599");
            FileOutputStream fos=new FileOutputStream("C:\\Users\\VaVe\\Downloads\\download.xlsx");
            workbook.write(fos);
            workbook.close();
            fis.close();
            fos.close();





        }

        }




