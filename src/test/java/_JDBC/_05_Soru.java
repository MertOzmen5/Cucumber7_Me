package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_Soru extends JDBCParent {

    // City tablosundaki tüm satırlardaki şehir isimlerini absolute ile yazdırınız

    @Test
    public void Test1() throws SQLException {

        DBConnectionOpen();
        ResultSet rs = sorguEkrani.executeQuery("select city from city");

        rs.last();
        int satir = rs.getRow(); // son satır numarası

        for (int i = 1; i <= satir; i++) {

            rs.absolute(i);
            System.out.println(i + ".Satır : " + rs.getString(1));
        }
        DBConnectionClose();
    }
    // City tablosundaki tüm satırlardaki şehir isimlerini relative ile yazdırınız
    @Test
    public void Test2() throws SQLException {
        DBConnectionOpen();
        ResultSet rs= sorguEkrani.executeQuery("select city from city");

        rs.last();
        int satir= rs.getRow();

        rs.first();
        System.out.println("1.Satır : " +rs.getString(1));
        for (int i = 1; i <satir ; i++) {

            rs.relative(1);
            System.out.println(i+1 + ".Satır : " + rs.getString(1));

        }
        DBConnectionClose();
    }
}
