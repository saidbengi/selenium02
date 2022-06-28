package Practices;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C03_D18_WebTables extends TestBase {
    @Test
    public void test01() {
        login();
        table();
        printRows();
    }




    //● printColumns( ) metodu oluşturun
    //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
    //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
    //○ 5.column daki elementleri konsolda yazdırın

    public void login() {
        //● Bir class oluşturun : D18_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        //○ Username : manager ○ Password : Manager1!
        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Manager1!"+ Keys.ENTER);
    }

    public void table(){
        //● table( ) metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunListesi=driver.findElements(By.xpath("//th"));
        System.out.println("Sutun sayisi : "+sutunListesi.size());

        //○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        System.out.println("--------------------table-----------------------");
        WebElement tumBasliklar=driver.findElement(By.xpath("//thead//tr"));
        System.out.println(tumBasliklar.getText());


    }

    public void printRows() {
        //● printRows( ) metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println("---------------------printRows----------------------------");
        List<WebElement> satirListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(satirListesi.size());
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:satirListesi
             ) {
            System.out.println(each.getText());
        }
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//tr[4]"));
        for (WebElement each:cellList) {
            System.out.println(each.getText());
        }
    }

    public void printCells(){
        System.out.println("---------------------printCells-------------------------");
        //● printCells( ) metodu oluşturun //td
        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> cells=driver.findElements(By.xpath("//td"));
        System.out.println(cells.size());
        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        for (WebElement each:cells
             ) {
            System.out.println(each.getText());
        }
    }
}
