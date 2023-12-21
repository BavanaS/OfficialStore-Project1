package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class StepFile {

    public static  ChromeOptions options = new ChromeOptions();
    public static WebDriver driver = new ChromeDriver(options.addArguments("--disable-notifications"));

    @Given("Be in BliBli home page {string}")
    public void beInBliBliHomePage(String arg0)
    {
        driver.get(arg0);
        HomePage.store(driver);
    }

    @When("Should enter {string} and apply filters")
    public void shouldEnterAndApplyFilters(String arg0) throws InterruptedException
    {
        StorePage.officialStore(driver,arg0);
        ProductPage.productPage(driver);
    }
    public static void waitForEnableCondition(WebDriver driver, WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    @And("Should apply brands {string} and {string}")
    public void shouldApplyBrandsAnd(String arg0, String arg1)
    {
        Brands.brandFilter(driver,arg0,arg1);
    }
}
