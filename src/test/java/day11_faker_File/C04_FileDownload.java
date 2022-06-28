package day11_faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. dummyUpload.txt dosyasını indirelim
        WebElement indirilicekDosya=driver.findElement(By.xpath("//a[@href='download/dummyUpload.txt']"));
        indirilicekDosya.click();
        Thread.sleep(4000);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosya downloads'a indirilecektir ,
        String differentPath= System.getProperty("user.home");
        String commonPath="\\Downloads\\dummyUpload.txt";

        String findFilePath=differentPath+commonPath;
        Assert.assertTrue(Files.exists(Paths.get(findFilePath)));
    }
}
