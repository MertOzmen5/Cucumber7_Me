package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class _08_GetAllRowColumn extends JDBCParent {

    // bir metoda sorguyu("select * from language") gönderiniz,
    // metod size sorgunun datasını bir ArrayList olarak döndürsün

    @Test
    public void Test1() {

        String sorgu = "select * from language";
        List<List<String>> donenTablo = getListData(sorgu); // getListData fonk.gideni var döneni de var
        //System.out.println(donenTablo);

        for (List<String> satir : donenTablo) {
            for (String kolon : satir)
                System.out.print(kolon + "\t");

            System.out.println();

        }
    }

    public List<List<String>> getListData(String sorgu) {

        List<List<String>> tablo = new ArrayList<>();

        try {
            DBConnectionOpen();
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd = rs.getMetaData(); // kolon sayısı

            ArrayList<String> kolonSatiri = new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                kolonSatiri.add(rsmd.getColumnName(i));
            tablo.add(kolonSatiri);


            while (rs.next()) {

                ArrayList<String> satir = new ArrayList<>();
                // bu satırdaki elemanları satır listine ekle.
                //  rs.getString(1); //1 aşağıda bunu yapıyoruz.

                for (int i = 1; i <= rsmd.getColumnCount(); i++)
                    satir.add(rs.getString(i));

                // satır bitince tabloya ekle
                tablo.add(satir);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose(); // hata olsa da olmasa da çalış
        }

        return tablo;
    }
}


