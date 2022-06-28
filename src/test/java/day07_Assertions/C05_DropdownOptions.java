package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropdownOptions {
    /*
    Amazon anasayfaya gidip
    dropdown menuden books'u secelim
    sectigimiz option'i yazdiralim

    dropdown'daki opsiyonlarin toplam sayisinin
    23 oldugunu test edin
     */

    WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();
    }


    @Test
     public void test01() {
        driver.get("https://www.amazon.com");
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByValue("search-alias=stripbooks-intl-ship");

        // bir dropDown ile calisiyorken son secilen option'a ulasmak isterseniz
        // select.getFirstSelectedOption() method'unu kullanmalisiniz
        // bu method bize WebElement dondurur,
        // uzerindeki yaziyi yazdirmak icin getText() unutulmamalidir
        System.out.println(select.getFirstSelectedOption().getText());

        // 28 oldugunu test edin

        List<WebElement> optionList=select.getOptions();

        int actualOptionSayisi=optionList.size();
        int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);




    }

}
