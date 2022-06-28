package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_YanlisEmailTesti {
    /*
    1. Bir Class olusturalim YanlisEmailTesti
    2. http://automationpractice.com/index.php sayfasina gidelim
    3. Sign in butonuna basalim
    4. Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */
     WebDriver driver;

    @Before
    public  void startUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }
    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01(){
        driver.findElement(By.xpath("//a[@class='login']")).click();
        WebElement mailBox=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        mailBox.sendKeys("saidbengihotmail.com");
        driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
        WebElement uyariMessage=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyariMessage.isDisplayed());
    }
}
