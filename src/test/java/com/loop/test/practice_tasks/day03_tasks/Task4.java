package com.loop.test.practice_tasks.day03_tasks;

import com.loop.test.utilities.GeneralConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        //Setting up a driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to website
        driver.get("https://www.etsy.com");
        //Searching for "wooden spoon"
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#global-enhancements-search-query")).sendKeys("wooden spoon" + Keys.ENTER);
        //Verifying title
        if (driver.getTitle().equals(GeneralConstants.EXPECTED_TITLE_SEARCHING_FOR_WOODEN_SPOON_ETSY)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        Thread.sleep(1000);
        driver.quit();
    }
}