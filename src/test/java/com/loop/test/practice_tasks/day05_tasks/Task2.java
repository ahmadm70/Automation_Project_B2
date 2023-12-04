package com.loop.test.practice_tasks.day05_tasks;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1. go to https://www.etsy.com/
2. search for rings
3. validate that Estimated Arrival shows any time
3. click Estimated Arrival dropdown
4. click Select custom date
5. choose december 31 from dropdown
6. validate Estimated Arrival shows december 31
 */

public class Task2 {
    WebDriver driver;
    String actual, expected;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.etsy.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']")).sendKeys("rings" + Keys.ENTER);
        actual = driver.findElement(By.xpath("//div[@class='wt-panel__trigger-container']/button/span/span/span")).getText();
        expected = "Any time";
        Assert.assertEquals(actual, expected, "TEST FAILED!");
        WebElement dropdownElement = driver.findElement(By.xpath("//div[@class='wt-panel__trigger-container']/button"));
        Thread.sleep(1000);
        dropdownElement.click();
        Thread.sleep(1000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='edd_select_tf']")));
        Thread.sleep(1000);
        dropdown.selectByVisibleText("By Dec 31");
        Thread.sleep(1000);
        actual = driver.findElement(By.xpath("//div[@class='wt-panel__trigger-container']/button/span/span/span")).getText();
        expected = "By Dec 31";
        Assert.assertEquals(actual, expected, "TEST FAILED!");
    }
}