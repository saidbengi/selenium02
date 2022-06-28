package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;
    @Before
    public void setUp(){
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
        // Eger Test method'umuzda hicbir test yoksa , test calistiktan sonra
        // hicbir problemle karsilasilmadigi icin raporlamak icin "tests passed" yaziisi cikar
        driver.get("https://www.amazon.com");

        /*
        Eger testleri if ile yaparsak
        test failed olsa bile kodlar problemsiz calistigi icin
        kod calismasi bittiginde
        ekranin sol alt kisminda test passed yazicaktir
         */

        // url'in https://www.facebook.com oldugunu test edin

       /* if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("Url testi PASSED");
        }else{
            System.out.println("Url testi FAİLED");
        }

        */

        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals("Url beklenenden farkli",expectedUrl,actualUrl);

        /*
        Assert ile yaptigimiz testlerde assertion failed olursa
        Java kodlarin calismasini durdurur ve Assert class'i
        bizi hata konusunda bilgilendirir

        org.junit.ComparisonFailure: Url beklenenden farkli
        Expected :https://www.facebook.com
        Actual   :https://www.amazon.com/
        <Click to see difference>

        Boylece hatanin ne oldugunu arastirmamiza gerek kalmadan
        JUnit bize raporlamis olacak
         */


    }
}
