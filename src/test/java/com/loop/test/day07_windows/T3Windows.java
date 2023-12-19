package com.loop.test.day07_windows;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.BrowserUtilities;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.*;

/*
    1. Create new test and make set ups
    2. Go to : https://www.amazon.com
    3. Copy paste the lines from below into your class
    4. Create a logic to switch to the tab where Etsy.com is open
    5. Assert: Title contains “Etsy”
    Lines to be pasted:
    ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
    These lines will simply open new tabs using something called JavascriptExecutor
    and get those pages. We will learn JavascriptExecutor later as well.
*/

public class T3Windows extends TestBase {
    @Test
    public void windowsHandleTest() {
        driver.get("https://www.amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String each : windowHandles) {
//            driver.switchTo().window(each);
//            System.out.println(driver.getCurrentUrl());
//            if (driver.getCurrentUrl().contains("google")) {
//                break;
//            }
//        }
        //BrowserUtilities.switchWindowAndValidate(driver, "amazon.com", "Amazon");
        BrowserUtilities.switchToWindow(driver, "Facebook");
    }
}