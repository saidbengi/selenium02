package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase {

    @Test
    public void test01(){
        //  1- Yeni bir class olusturalim: MouseActions1
        //  2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions=new Actions(driver);
        //  3- Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan=driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();
        //  4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //  test edelim.
        String actualAlert=driver.switchTo().alert().getText();
        String expectedAlert="You selected a context menu";
        Assert.assertEquals(expectedAlert,actualAlert);
        //  5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //  6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //  7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> pageHandleDegerleri=driver.getWindowHandles();
        String ikinciSayfaHandleDegeri="";
        for (String each:pageHandleDegerleri
             ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        String actualh1Tagi=driver.findElement(By.xpath("//h1")).getText();
        String expectedh1Tagi="Elemental Selenium";
        Assert.assertEquals(expectedh1Tagi,actualh1Tagi);
    }
}
