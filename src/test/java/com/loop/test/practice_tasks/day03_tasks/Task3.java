package com.loop.test.practice_tasks.day03_tasks;

import com.loop.test.utilities.GeneralConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        //Setting up a driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to website
        driver.get("https://www.google.com");
        //Clicking Gmail button
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[aria-label='Gmail (opens a new tab)']")).click();
        //Verifying that title contains "Gmail"
        if (driver.getTitle().contains(GeneralConstants.EXPECTED_TITLE_GMAIL)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        //Going previous webpage
        Thread.sleep(1000);
        driver.navigate().back();
        //Verifying title
        if (driver.getTitle().equals(GeneralConstants.EXPECTED_TITLE_GOOGLE)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        Thread.sleep(1000);
        driver.quit();
    }
}