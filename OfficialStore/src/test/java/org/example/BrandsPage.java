package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class BrandsPage
{
    public static void showBrands(WebDriver driver, String arg0, String arg1) throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        List<String> names=new ArrayList<>();
        names.add(arg0);
        names.add(arg1);

        js.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p[@class='lihat-semua']")).click();
        Thread.sleep(2000);

        for(String i:names)
        {
            WebElement search= driver.findElement(By.xpath("//input[@placeholder='Cari brand']"));
            assertEquals(search.getText(),"");
            search.click();
            search.clear();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@placeholder='Cari brand']")).sendKeys(i);

            Thread.sleep(3000);
            List<WebElement> brands=driver.findElements(By.xpath("//div[@class='facet-text']"));
            innerloop:
                for(WebElement j:brands)
                {
                    Thread.sleep(2000);
                    if(j.getText().equals(i))
                    {
                        j.click();
                        Thread.sleep(2000);
                         break innerloop;
                    }
                }
            Thread.sleep(2000);
        }
         driver.findElement(By.xpath("//button[@class='blu-btn filter-modal__buttons__apply b-secondary']")).click();
        Thread.sleep(2000);

    }
}
