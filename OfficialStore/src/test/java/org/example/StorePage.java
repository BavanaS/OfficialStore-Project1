package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StorePage
{
    public static void officialStore(WebDriver driver,String arg0) throws InterruptedException
    {
        WebElement searchBar= driver.findElement(By.xpath("//input[@class='b-ellipsis']"));
        waitForEnableCondition(driver,searchBar);
        searchBar.click();
        driver.findElement(By.xpath("//input[@class='b-ellipsis']")).sendKeys(arg0);
        WebElement search=driver.findElement(By.xpath("//div[@class='searchbox__search-icon']"));
        waitForEnableCondition(driver,search);
        search.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement popup2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn button b-secondary']")));
        if(popup2.isDisplayed())
        {
            popup2.click();
        }
        WebElement popup3= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-secondary b-small']")));
        if(popup3.isDisplayed())
        {
            popup3.click();
        }
    }
    public static void waitForEnableCondition(WebDriver driver, WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }
}
