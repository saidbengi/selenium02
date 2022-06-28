package day12_Synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_EnableTest extends TestBase {
    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()
    @Test
    public void test01() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement enabledBox = driver.findElement(By.xpath("(//input[@type='text']) "));
        Assert.assertFalse(enabledBox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enabledBox));
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledTextElement=driver.findElement(By.xpath("(//p[@id='message'])"));
        Assert.assertTrue(itsEnabledTextElement.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(enabledBox.isEnabled());
    }
}
