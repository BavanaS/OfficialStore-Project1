package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ProductPage
{
    public static void productPage(WebDriver driver) throws InterruptedException
    {
        WebElement product=driver.findElement(By.xpath("//button[@class='tabs-item']"));
        product.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(5000);
        WebElement popup4=driver.findElement(By.xpath("(//button[@class='blu-btn b-secondary b-small'])[2]"));
        popup4.click();

        List<WebElement> pages=driver.findElements(By.xpath("//a[@class='blu-paging__link']"));
        int length= pages.size();

        WebElement lastPage=pages.get(length-1);
        js.executeScript("arguments[0].scrollIntoView(true);", lastPage);
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,-600)","");
        Thread.sleep(7000);
        lastPage.click();
        Thread.sleep(3000);
    }
}
