package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    /*
    ● Bir class olusturun: Alerts
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
    ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    “You successfully clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
    ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    ● Bir metod olusturun: sendKeysAlert
    ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    static WebDriver driver;

    @BeforeClass
    public static void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }


    @Test
    public void acceptAlert() {
        //  ● Bir metod olusturun: acceptAlert
        // ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String expectedResult = "You successfully clicked an alert";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void dismissAlert(){
        // ● Bir metod olusturun: dismissAlert
        //    ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //    “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String expectedResult = "successfuly";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertFalse(actualResult.contains(expectedResult));
    }

    @Test
    public void sendKeysAlert(){
        // ● Bir metod olusturun: sendKeysAlert
        //    ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Said Bengi");
        driver.switchTo().alert().accept();
        String expectedResult = "Said Bengi";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}

