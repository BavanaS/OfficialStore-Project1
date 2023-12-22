package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckSorting
{
    public static void checkAssertion(WebDriver driver,int arg0)throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);


        WebElement pagesElement = driver.findElement(By.cssSelector("ul.blu-paging__list"));

        List<WebElement> pages = pagesElement.findElements(By.tagName("li"));

        for (int i=pages.size()-arg0;i<pages.size();i++) {

            WebElement selectedPage=pages.get(i);
            Thread.sleep(5000);
            try {

                js.executeScript("arguments[0].scrollIntoView(true);", selectedPage);
            } catch (StaleElementReferenceException e) {

                selectedPage=pages.get(i);
                Thread.sleep(5000);
                js.executeScript("window.scrollBy(0,3000)", "");
            }
            Thread.sleep(7000);
            js.executeScript("window.scrollBy(0,-500)","");
            Thread.sleep(3000);
            if(i==pages.size()-1)
            {
                int size=pages.size()-1;
                selectedPage= driver.findElement(By.xpath("(//a[@class='blu-paging__link'])[size]"));
            }
            selectedPage.click();


            Thread.sleep(3000);
            List<WebElement> products=driver.findElements(By.xpath("//div[@isfromsearchpage='true'] //div[@class='blu-product__price-after']"));
            String[] price=new String[products.size()];
            String[] sortingArray=new String[products.size()];
            for(int j=0;j<products.size();j++)
            {
                price[j]=products.get(j).getText();
                sortingArray[j]=price[j];
                System.out.println(price[j]);
            }
            assertEquals(price,sortingArray);
        }

    }
}
