package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;


public class GWD {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); //her bir thread e özel driver
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // o thread e özel browser name

    //  threadDriver.get() -> bulunduğu hat taki driverı ver
    //  threadDriver.set(driver) -> bulunduğu hata driver set et

    // Her bir sürecin kendine özel STATİC driverı olmalı : Local Static diyeceğiz
    // süreç = Thread
    // Thread.Sleep => ilgili süreci durduryor belli süre
    // her bir Thread in kendine özel STATİC i olmalı, yani LOCAL Static


    public static WebDriver getDriver() {

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadBrowserName.get() == null) // XML den çalışmayan durumlar için bu düzenleme yapılıyor
            threadBrowserName.set("chrome"); // default chrome olarak set et

        if (threadDriver.get() == null) { // hatta driver var mı, yok ise 1 kez oluştur

            switch (threadBrowserName.get()) {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());//bulunduğum hatta driver yok bir tane oluştur hatta set et
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                default:

                    if (isRunningOnJenkins()) {
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
                        threadDriver.set(new ChromeDriver(options));
                    } else
                        threadDriver.set(new ChromeDriver());
            }
            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }

        return threadDriver.get();
    }

    public static boolean isRunningOnJenkins() {
        String jenkinsHome = System.getenv("JENKINS_HOME");
        return jenkinsHome != null && !jenkinsHome.isEmpty();
    }


    public static void quitDriver() {

        //test sonucu ekranı bir miktar beklesin diye
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //driver kapat
        if (threadDriver.get() != null) { //driver var ise
            threadDriver.get().quit();
            WebDriver driver = threadDriver.get(); // hattaki driverı aldım
            driver = null; // null haline getirdim
            threadDriver.set(driver); // bu hattaki driver boşaldıktan sonra set ederek dolduruyoruz.
        }

    }


}
