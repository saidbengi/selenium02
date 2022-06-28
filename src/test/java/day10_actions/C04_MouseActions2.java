package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MouseActions2 extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        // Yeni bir class olusturalim: MouseActions2
        // 1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        Actions actions= new Actions(driver);
        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();
        Thread.sleep(3000);
        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String dropped=driver.findElement(By.xpath("(//*[text()='Dropped!'])")).getText();
        String actualText=dropped;
        String expectedText="Dropped!";
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(3000);
    }
}
