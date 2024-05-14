package ApachePOI;
/*
   Main den bir metod çağırmak suretiyle, henüz oluşturulmamış
   path i verilen excel için, program her çalıştıkça içine "test passed"
   yazısını ekleyen metodu yazınız.
   Yani dosya yoksa oluştur ilk satıra yaz, sonra dosya oluşacağı için
   dosya varsa en son satırın altına yaz.
 */

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;


public class _11_Soru {

    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/TestSonuclari.xlsx";
        String testSonuc = "Test passed";

        writeToExcel(path, testSonuc); //excel create
        writeToExcel(path, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, testSonuc); //dosya artık var ekleyecek


    }

    public static void writeToExcel(String path, String testSonuc) {

        File dosya = new File(path);

        if (!dosya.exists()) { // dosya yoksa
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Senaryolar");

            Row newRow = sheet.createRow(0);
            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(testSonuc);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Dosya yok ise bölümü çalıştı");
        } else {// dosya var ise

            FileInputStream inputStream = null;
            Workbook workbook = null;
            Sheet sheet = null;

            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            int satirMiktar = sheet.getPhysicalNumberOfRows();
            Row newRow = sheet.createRow(satirMiktar);
            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(testSonuc);

            try {

                inputStream.close();

                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Dosya VAR ise bölümü çalıştı");
        }
    }
}
