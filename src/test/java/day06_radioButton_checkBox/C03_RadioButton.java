package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    /*
    1. Bir class oluşturun : RadioButtonTest
    2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    - https://www.facebook.com adresine gidin
    - Cookies’i kabul edin
    - “Create an Account” button’una basin
    - “radio buttons” elementlerini locate edin
    - Secili degilse cinsiyet butonundan size uygun olani secin
     */
    WebDriver driver;
    @Before
    public void setUp() {
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
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        WebElement radioWomenButton=driver.findElement(By.xpath("(//label[@class='_58mt'])[1]"));
        WebElement radioManButton=driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));
        WebElement radioUniSexButton=driver.findElement(By.xpath("(//label[@class='_58mt'])[3]"));
        Thread.sleep(3000);
        if (!radioManButton.isSelected()){
            radioManButton.click();
        }
        Thread.sleep(3000);
    }


}
