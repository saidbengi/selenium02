package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    ○ Text Box’a “Merhaba Dunya!” yazin.
    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    dogrulayin ve konsolda yazdirin.
     */

    WebDriver driver;

    @Before
    public void setUp(){
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
    public void IFrameTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement baslikElementi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        /*○ Text Box’a “Merhaba Dunya!” yazin.
        textbox'i dogru olarak locate etmemize ragmen driver bulamadi
         bunun uzerine HTML kodlarini inceleyince
        textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
        bu durumda once iframe'i locate edip
       switchTo() ile o IFrame'e gecmeliyiz
       */
        WebElement iFrameElement=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElement);

        WebElement textKutusu=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();
        Thread.sleep(2000);
        textKutusu.sendKeys("Merhaba Dunya!");
        Thread.sleep(5000);

        // Link yazi elementini dogru locate etmemize ragmen yazdirmadi
        // cunku yukaridaki iFrame'e gecis yapmistik
        // once oradan cikmamiz lazim

        driver.switchTo().defaultContent();

        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //    dogrulayin ve konsolda yazdirin.
        WebElement linkYaziElement=driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(linkYaziElement.isDisplayed());

    }
}
