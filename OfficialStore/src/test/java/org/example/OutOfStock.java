package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OutOfStock
{
    public static void outOfStockList(WebDriver driver) throws InterruptedException
    {
        List<WebElement> elements=driver.findElements(By.xpath("//div[@class='blu-product b-product-disabled product__card']"));

        int length=0;
        for(WebElement i:elements)
        {
            String str=i.getText();
            if(!str.equals(""))
            {
                length++;
            }
        }
        String[] outOfStock=new String[length];
        length=0;
        System.out.println("List of Out of Stock Products:");
        for(WebElement i:elements)
        {
            String str=i.getText();
            if(!str.equals(""))
            {
                outOfStock[length]=str;
                System.out.println(outOfStock[length]);
                length++;
                System.out.println("\n");
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);
        List<WebElement> pages=driver.findElements(By.xpath("//a[@class='blu-paging__link']"));
        pages=driver.findElements(By.xpath("//a[@class='blu-paging__link']"));
        WebElement firstPage=pages.get(0);
        firstPage.click();
    }
}
