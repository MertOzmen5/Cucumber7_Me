package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {

    public static void main(String[] args) throws IOException {

        // hafızada workbook oluştur.
        // bundan hafızada sheet oluştur.

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");

        // kalan kısım aynı
        Row newRow = sheet.createRow(0);
        Cell newCell = newRow.createCell(0);
        newCell.setCellValue("Merhaba yeni Excel");

        // kaydetme kısmı dosya adı burada veriliyor
        String path = "src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}
