package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // 1- amazon anasayfaya gidin

        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        // 2- nutella icin arama yaptirin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);

        /*
        CDwindow-1BF7E697D5590E94DBED3FEC48E0A22B
        bu kod acilan sayfanin unique hash kodudur
        Selenium sayfalar arasi geciste bu window handle degerinin kullanir

        eger sayfalar arasinda driver'mizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecmek istiyorsak
         driver.switchTo().window("CDwindow-1BF7E697D5590E94DBED3FEC48E0A22B");
         bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz
         */

        // 3-ilk urunun resmini tiklayarak farkli bir tab olarak acin

        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandigimizda driver otomatik olarak olusturulan
        new tab gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamız gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();


        // 4- yeni tab'da acilan urunun title'ni yazdirin

        String baslik = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println(baslik);
        System.out.println("2.sayfa URL : " + driver.getCurrentUrl());

        // ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println("1.sayfa URL : " + driver.getCurrentUrl());

    }
}
