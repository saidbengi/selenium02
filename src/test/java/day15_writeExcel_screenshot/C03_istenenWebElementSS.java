package day15_writeExcel_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_istenenWebElementSS extends TestBase {

    @Test
    public void webElementSS() throws IOException {
        // amazon'a gidip Nutella aratalim
        // ve sonuc sayisinin oldugu web elementin fotografini cekelim

        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElemeti=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucYaziElementSS= new File("target/screenShot/sonucYazisiSS.jpeg");
        File temp= sonucYaziElemeti.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYaziElementSS);
    }
}
