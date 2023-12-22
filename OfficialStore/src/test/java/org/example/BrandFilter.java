package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;
public class BrandFilter
{
    public static void filter(WebDriver driver)
    {
        List<WebElement> products=driver.findElements(By.xpath("//div[@isfromsearchpage='true']"));
        System.out.println("The filterd products by brand:");
        for(WebElement i:products)
        {
            System.out.println(i.getText());
            System.out.print("\n");
        }
    }
}
