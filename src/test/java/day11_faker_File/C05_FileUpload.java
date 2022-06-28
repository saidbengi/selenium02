package day11_faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim
        //4. Yuklemek istediginiz dosyayi secelim.
        /*
        Bu islemi selenium ile yapma imkanimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() imdadimiza yetisir
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
        secme islemi otomatik olarak yaoilmis olacaktir
         */
        // 1.adim choose file butonunu locate edelim
        WebElement fileChooseButton=driver.findElement(By.id("file-upload"));
        //2.adim yuklenecek dosyanin dosya yolunu olusturalim
        // biz masaüstündeki text.txt dosyasini yukleyelim
        String differentPath=System.getProperty("user.home");
        String commonPath="\\Desktop\\text.txt";
        String uploadFile=differentPath+commonPath;

        // 3.adim sendKeys ile dosya yolunu , secme butonuna yollayalim
        fileChooseButton.sendKeys(uploadFile);
        Thread.sleep(4000);
        //5. Upload butonuna basalim.
        driver.findElement(By.className("button")).click();
        Thread.sleep(2000);
        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement textBox=driver.findElement(By.xpath("//h3"));
        String actualBoxText=textBox.getText();
        String expectedBoxText="File Uploaded!";
        Assert.assertEquals(expectedBoxText,actualBoxText);
    }
}
