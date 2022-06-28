package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    //● Bir class oluşturun : C02_WebTables
    //● login( ) metodun oluşturun ve oturum açın.

    public void girisYap(){
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //○ Username : manager
        //○ Password : Manager1!
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.xpath("//input[@class='form-control required']")).sendKeys("manager");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @Test
    public void loginTest() {
       girisYap();
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklari = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi : " + sutunBasliklari.size());
        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarlistesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : " + satirlarlistesi.size());
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each : satirlarlistesi
        ) {
            System.out.println(each.getText());
        }
        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//tr[4]/td"));

        for (WebElement each : cellList
        ) {
            System.out.println(each.getText());
        }
        // ○ Email basliginda ki tum elementleri(sutun) konsolda yazdırın.

        // once email basliginin kacinci sutunda oldugunu bulalim

        List<WebElement> basliklar = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo = 0;
        for (int i = 1; i < basliklar.size(); i++) {
            if (basliklar.get(i).getText().equals("Email")) {
                emailSutunNo = i;
            }

        }
        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//td[" + (emailSutunNo + 1) + "]"));

        for (WebElement each:emailSutunListesi) {
            System.out.println(each.getText());
        }
    }
}
