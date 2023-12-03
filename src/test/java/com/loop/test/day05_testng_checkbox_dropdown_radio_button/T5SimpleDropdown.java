package com.loop.test.day05_testng_checkbox_dropdown_radio_button;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5SimpleDropdown {
    WebDriver driver;
    String actual, expected;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        expected = "Please select an option";
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        actual = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected, "Results aren't matching");
    }
    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}