package _JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void Test1() throws SQLException {

        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        // 1- Bağlantı bilgilerini girdik DB servera bağlandık.
        Connection baglanti= DriverManager.getConnection(url,username,password);

        // 2- Sorgu ekranını açtık
        Statement sorguEkrani=baglanti.createStatement();

        // 3- Sorgu ekranına sorguyu yazdım ve çalıştırdım.
        ResultSet sonucTablosu =sorguEkrani.executeQuery("select * from customer");

        // 4- Altta sonuçlar gözüktü
        sonucTablosu.next();
        String ad=sonucTablosu.getString("first_name");
        String soyAd=sonucTablosu.getString("last_name");
        System.out.println("1.Satır ad ve soyad " + ad+ " " +soyAd);

        sonucTablosu.next();
        ad=sonucTablosu.getString("first_name");
        soyAd=sonucTablosu.getString("last_name");
        System.out.println("2.Satır ad ve soyad " + ad+ " " +soyAd);

        baglanti.close();

    }
}
