package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    @Then("shows the out of stock product list")
    public void showsTheOutOfStockProductList() throws InterruptedException {
        OutOfStock.outOfStockList(driver);
    }

    @When("Should enter brands {string} and {string} and apply filters")
    public void shouldEnterBrandsAndAndApplyFilters(String arg0, String arg1)throws InterruptedException {
        BrandsPage.showBrands(driver,arg0,arg1);
    }

    @Then("show brand selected products")
    public void showBrandSelectedProducts()
    {
        BrandFilter.filter(driver);
    }

    @When("Should apply {string} filter")
    public void shouldApplyFilter(String arg0) throws InterruptedException
    {
        ApplyCheapest.cheapestFilter(driver,arg0);
    }

    @Then("show the assertion result of last {int} pages")
    public void showTheAssertionResultOfLastPages(int arg0) throws InterruptedException
    {
        CheckSorting.checkAssertion(driver,arg0);
    }
}
