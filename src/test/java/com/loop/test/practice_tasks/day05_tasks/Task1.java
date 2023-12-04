package com.loop.test.practice_tasks.day05_tasks;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1. go to http://the-internet.herokuapp.com/dropdown
2. validate "Please select an option" is selected by default
3. Choose option 1 and validate that it is selected
4. Choose option 2 and validate that it is selected
5. Validate dropdown name is "Dropdown List"
 */

public class Task1 {
    WebDriver driver;
    String actual, expected;
    @BeforeClass
    public void setUpClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }
    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        Thread.sleep(1000);
    }
    @Test
    public void test1() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        actual = dropdown.getFirstSelectedOption().getText();
        expected = "Please select an option";
        Assert.assertEquals(actual, expected, "TEST FAILED!");
    }
    @Test
    public void test2() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByIndex(1);
        actual = dropdown.getFirstSelectedOption().getText();
        expected = "Option 1";
        Assert.assertEquals(actual, expected, "TEST FAILED!");
    }
    @Test
    public void test3() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByIndex(2);
        actual = dropdown.getFirstSelectedOption().getText();
        expected = "Option 2";
        Assert.assertEquals(actual, expected, "TEST FAILED!");
    }
    @Test
    public void test4() {
        actual = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
        expected = "Dropdown List";
        Assert.assertEquals(actual, expected, "TEST FAILED!");
    }
}