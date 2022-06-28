package day15_writeExcel_screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutors extends TestBase {

    @Test
    public void JSExecutorTest() throws InterruptedException {
        // amazon'a gidelim
        driver.get("https://www.amazon.com");
        // asagidaki sign in butonu gorununceye kadar js ile scrool yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signBox=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true)",signBox);
        // sign in butonuna js ile cilick yapalim

        jse.executeScript("arguments[0].click();",signBox);

        Thread.sleep(3000);
    }
}
