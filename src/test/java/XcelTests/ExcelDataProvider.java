package XcelTests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {




    @Test(dataProvider ="getExcelData" )
    public void printDataFromExcel(String a,String b,String c){

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);



    }

    @DataProvider
    public Object[][] getExcelData() throws IOException {
        DataFormatter formatter=new DataFormatter();
        FileInputStream fis=new FileInputStream("C:\\Users\\VaVe\\Documents\\testngdata.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet= workbook.getSheetAt(0);

       int rowCount= sheet.getPhysicalNumberOfRows();
       Row row1=sheet.getRow(0);

       int colCount= row1.getLastCellNum();
        Object data[][]= new Object [rowCount-1][colCount];
       for (int i=0;i<rowCount-1;i++){
          Row row=sheet.getRow(i+1);

           for (int j=0;j<colCount-1;j++){


               Cell ce=row.getCell(j);
               data[i][j]=formatter.formatCellValue(ce);




           }
       }

   return data;
    }
}
