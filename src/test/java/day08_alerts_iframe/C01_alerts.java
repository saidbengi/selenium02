package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_alerts {

    WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
         /* herhangi bir web sitesine gidince veya
         bir web sitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz

        Eger bir alert inspect yapilabiliyorsa , o alert otomasyon ile kullanilabilir,
        bu tur alert'lere HTMl alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
        tum web elementler gibi locate edip istedigimiz islemleri yapabiliriz
        driver.get("gttps://www.facebook.com"); da cikan alert vb. gibii

        Ancak web uygulamalrinda HTML alert yaninda Java script alert de bulunabilir
        Js alerts'ler locate edilemez
         Selenium'da JS alert'ler icin ozel bir yontem gelistirmistir
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        driver.switchTo().alert().accept();

        // alert'de OK tusuna basin result kisminda "You successfully clicked an alert" yazdigini test edin

        String expectedResult="You successfully clicked an alert";
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedResult,actualResult);
    }
}
