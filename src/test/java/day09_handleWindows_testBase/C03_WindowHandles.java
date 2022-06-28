package day09_handleWindows_testBase;

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
import java.util.Set;

public class C03_WindowHandles {
    /*
    ● Tests package’inda yeni bir class olusturun: WindowHandle2
    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    ● Click Here butonuna basın.
    ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
    doğrulayın.
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
       driver.quit();
    }

    @Test
    public void test01() {
        //  ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement pagetext=driver.findElement(By.xpath("//h3"));
        String actualtext=pagetext.getText();
        String expectedtext="Opening a new window";
        Assert.assertEquals(actualtext,expectedtext);
        //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);


        /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir
        oncelikle 2.sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atayalim
         */
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);


        //  ● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        /*
        switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
        biz driver'a yeni sayfaya gec demedikce , driver eski sayfada kalir
        ve yeni sayfa ile ilgili hicbir islem yapamaz
        yeni sayfada driver'i calistirmak isterseniz
        once driver'i yeni sayfaya yollamaliyiz
         */

        /*
        yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
        bunun icin driver.getWindowHandles() methodu'unu kullanarak
        acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz

        ilk sayfanin window handle degerini zaten biliyoruz
        Set'deki window handle degerlerini kontrol edip
        ilk sayfanin handle degerine esit olmayan
        ikinci sayfanin window handle degeridir deriz
         */
        Set<String> windowHandleSeti=driver.getWindowHandles();
        System.out.println(windowHandleSeti);
        String ikinciSayfaHandleDegeri="";
        for (String each :windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }

        }

        /*
        artik ikinci sayfanin window handle degerini biliyoruz
        rahatlikla sayfalar arasi gecis yapabiliriz
        */

        driver.switchTo().window(ikinciSayfaHandleDegeri);

        //  ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle2=driver.getTitle();
        String expectedTitle2="New Window";
        Assert.assertEquals(expectedTitle2,actualTitle2);
        //  ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement page2text=driver.findElement(By.xpath("//h3"));
        String actualtext2=page2text.getText();
        String expectedtext2="New Window";
        Assert.assertEquals(expectedtext2,actualtext2);
        //  ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //  doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        String actualTitle3= driver.getTitle();
        String expectedTitle3="The Internet";
        Assert.assertEquals(expectedTitle3,actualTitle3);
    }
}
