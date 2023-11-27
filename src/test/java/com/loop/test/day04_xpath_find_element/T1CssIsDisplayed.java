package com.loop.test.day04_xpath_find_element;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T1CssIsDisplayed {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://the-internet.herokuapp.com/forgot_password");
        if (driver.findElement(By.cssSelector("div[class='example'] > h2")).isDisplayed()) {
            System.out.println("Forget password heading is displayed");
        } else {
            System.err.println("Forget password heading isn't displayed");
        }
        driver.quit();
    }
}