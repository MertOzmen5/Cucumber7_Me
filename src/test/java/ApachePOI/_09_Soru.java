package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
        *  Excel Çarpım tablosunu
        *  YENİ bir excel dosyasına
        *  1 den 10 kadar çarpımlar için yapınız.
        */


public class _09_Soru {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("Sayfa1");

        int yeniSatirIndex=0;
        for (int i = 1; i <=10 ; i++) {

            for (int j = 1; j <=10 ; j++) {
                Row newRow=sheet.createRow(yeniSatirIndex++);
                Cell hucre1= newRow.createCell(0); hucre1.setCellValue(i);
                Cell hucre2= newRow.createCell(1); hucre2.setCellValue("x");
                Cell hucre3= newRow.createCell(2); hucre3.setCellValue(j);
                Cell hucre4= newRow.createCell(3); hucre4.setCellValue("=");
                Cell hucre5= newRow.createCell(4); hucre5.setCellValue(i*j);

            }
            Row boslukSatir= sheet.createRow(yeniSatirIndex++);
        }

        String path="src/test/java/ApachePOI/resource/YeniCarpim.xlsx";
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();






    }
}
