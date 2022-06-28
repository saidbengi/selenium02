package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
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
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        // 2- url'in amazon icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaHandleDegeri = driver.getWindowHandle();
        // 4- title'in Bestbuy icerdigini test edelim
        String actualtitle = driver.getTitle();
        String arananKelime="Best Buy";
        Assert.assertTrue(actualtitle.contains(arananKelime));
        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        // 6- arama sonuclarinin java icerdigini test edelim
        WebElement sonucYazisiELement=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String sonucYazisiStr=sonucYazisiELement.getText();
        String aradigimizKelime="Java";
        Assert.assertTrue(sonucYazisiStr.contains(aradigimizKelime));
        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        // 8- logonun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());

    }
}
