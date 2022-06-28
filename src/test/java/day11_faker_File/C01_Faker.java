package day11_faker_File;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test01(){
        // facebook gorevini fake isimlerle yapalim
        // 1- facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        // 2- yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        // 3- isim kutusunu locate edip,
        WebElement nameBox=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        // 4- geriye kalan alanlari TAB ile dolasarak
        //    formu doldurun
        actions.sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("21")
                .sendKeys(Keys.TAB)
                .sendKeys("Kas")
                .sendKeys(Keys.TAB)
                .sendKeys("1998")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                //.sendKeys(Keys.ENTER) bunu açma facebook'a kaydolursun
                .perform();
    }
}
