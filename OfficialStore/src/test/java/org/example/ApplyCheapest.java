package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ApplyCheapest
{
    public static void cheapestFilter(WebDriver driver,String arg0) throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p[@class='lihat-semua']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@class='blu-btn filter-modal__buttons__reset b-ghost b-secondary b-medium']")).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,400)","");
        Thread.sleep(8000);
        driver.findElement(By.xpath("//div[@class='blu-dropdown__trigger']")).click();

        List<WebElement> dropDown=driver.findElements(By.xpath("//button[@class='blu-list__item']"));
        for(WebElement i: dropDown)
        {
            if(arg0.equals(i.getText()))
            {
                Thread.sleep(5000);
                i.click();
                break;
            }
        }

        Thread.sleep(3000);
    }

}
