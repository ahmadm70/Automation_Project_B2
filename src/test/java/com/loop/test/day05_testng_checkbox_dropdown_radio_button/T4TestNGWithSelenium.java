package com.loop.test.day05_testng_checkbox_dropdown_radio_button;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T4TestNGWithSelenium {
    WebDriver driver;
    String expected;
    String actual;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @Test (priority = 1)
    public void test1() {
        driver.get("https://www.google.com");
        System.out.println(((RemoteWebDriver) driver).getSessionId());
        expected = "Google";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Titles aren't matching!");
    }
    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
    @Test (priority = 2)
    public void test2() {
        driver.get("https://beta.docuport.app/login");
        System.out.println(((RemoteWebDriver) driver).getSessionId());
        expected = "Docuport";
        actual = driver.getTitle();
        Assert.assertTrue(actual.equals(expected), "Titles aren't matching");
    }
}