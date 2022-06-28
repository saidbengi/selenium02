package day12_Synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    // 1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    @Test
    public void implicitlyWaitesti() {


        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYaziElement=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneYaziElement.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYaziElement=driver.findElement(By.xpath("(//p[@id='message'])"));
        Assert.assertTrue(itsBackYaziElement.isDisplayed());
    }

    @Test
    public void explicitlyWaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement itsGoneYaziElement=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElement));
        Assert.assertTrue(itsGoneYaziElement.isDisplayed());

        yazinin gorunur olmasini beklerken yazinin locate'ini kullanmak sorun olusturur
        cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir
        (HTML kodlarini yazan developer farkli uygulamalar yapabilir)
        Bu durumda bekleme islemi ve locate'i birlikte yapmaliyiz
         */
        WebElement itsGoneYaziElement=wait.until(ExpectedConditions
                                        .visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneYaziElement.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYaziElement=wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//p[@id='message'])")));
        Assert.assertTrue(itsBackYaziElement.isDisplayed());


    }
}
