package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void dinamikYazici() {
        // oceki class'daki adrese gidip
        // giris yap methodunu kullanarak sayfaya giris yapin
        girisYap();
        // input olarak verilen satir sayisi ve sutun sayisi'na sahip
        // cell' deki text'i yazdirin
        int satir=3;
        int sutun=3;

        WebElement arananCell=
                driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));


        System.out.println(arananCell.getText());
    }

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
}
