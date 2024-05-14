package _JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _02_Soru {

    @Test
    public void Test2() throws SQLException {

        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        // 1- Bağlantı bilgilerini girdik DB servera bağlandık.
        Connection baglanti= DriverManager.getConnection(url,username,password);

        // 2- Sorgu ekranını açtık
        Statement sorguEkrani=baglanti.createStatement();

        // 3- Sorgu ekranına sorguyu yazdım ve çalıştırdım.
        ResultSet sonucTablosu =sorguEkrani.executeQuery("select * from city");



        while (sonucTablosu.next()){

            System.out.println(sonucTablosu.getString("city"));
        }
        baglanti.close();

    }
}
