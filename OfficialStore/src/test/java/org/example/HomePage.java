package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage
{
    public static void store(WebDriver driver)
    {
        try {

            Alert alert = driver.switchTo().alert();

            String alertMessage = alert.getText();
            System.out.println("Alert message: " + alertMessage);

            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present");
        }

        WebElement rightArrow=driver.findElement(By.xpath("//div[@class='favourite__arrow-right']"));
        waitForEnableCondition(driver,rightArrow);
        rightArrow.click();
        WebElement store=driver.findElement(By.xpath("//div[@title='Official Store']"));
        store.click();
    }
    public static void waitForEnableCondition(WebDriver driver, WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }
}
