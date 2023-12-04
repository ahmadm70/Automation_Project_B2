package com.loop.test.day05_testng_checkbox_dropdown_radio_button;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class T7MultiDropdown {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
    @Test
    public void test1() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
        Assert.assertTrue(dropdown.isMultiple(), "Test failed!");
        //First way of choosing all options
//        dropdown.selectByIndex(0);
//        dropdown.selectByValue("saab");
//        dropdown.selectByVisibleText("Opel");
//        dropdown.selectByIndex(3);
        //Second way with using List
        List<WebElement> options = new ArrayList<>();
        options = dropdown.getOptions();
        for (int i = 0; i < options.size(); i++) {
            dropdown.selectByIndex(i);
        }
        //Third way with using lambda expression
        options = dropdown.getOptions();
        options.forEach(option -> {
            System.out.println(option.getText());
        });
        dropdown.deselectAll();
    }
}