package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _06_GetMetaData extends JDBCParent{

    @Test
    public void Test1() throws SQLException {
        DBConnectionOpen();

        ResultSet rs= sorguEkrani.executeQuery("select city_id,city,country_id from city");

        rs.next(); // 1.satırı aldım
        System.out.println("id=" +rs.getString(1)); // city id verir.Her tipi getString ile alabilirsin
        System.out.println("id=" +rs.getString("city_id")); // city id verir

        int intID=rs.getInt("city_id"); // Kolonun tipine uygun get ile de alabilirsin.
        // Yani burada int belirledik tipi o yüzden getInt ile çağırırız ama içine yine String yazabiliyoruz.
        System.out.println("intID = " +intID);


        DBConnectionClose();
    }

    @Test
    public void Test2() throws SQLException {
        DBConnectionOpen();

        ResultSet rs= sorguEkrani.executeQuery("select * from city");

        ResultSetMetaData rsmd=rs.getMetaData(); // Sorgu sonucunda DATA dışındaki veriler,kolon sayısı ve kolon isimleri gibi
        // MetaFizik : fiziğin dışındakiler dışında
        // MetaData : Data dışı veriler

        int kolonSayisi=rsmd.getColumnCount(); // kolon sayısı
        System.out.println("kolonSayisi = " + kolonSayisi);

        for (int i = 1; i <=kolonSayisi ; i++) {
            System.out.println(rsmd.getColumnName(i)+ " " +rsmd.getColumnTypeName(i)); // kolon isimleri ve tipi

        }

        rs.next(); // Şu anda ilk satırdayım,kolonları yazdırayım
        System.out.println("1. Kolon = "+rs.getString(1)); // 1 1.Kolon
        System.out.println("2. Kolon = "+rs.getString(2)); // A Coruna (La Coruna) 2.Kolon
        System.out.println("3. Kolon = "+rs.getString(3)); // 87 3.Kolon

        System.out.println("*****************");

        for (int i = 1; i <kolonSayisi ; i++) {
            System.out.println(i+".Kolon = "+rs.getString(i));
        }

        rs.next(); // 2.Satıra geçildi

        DBConnectionClose();
    }



}
