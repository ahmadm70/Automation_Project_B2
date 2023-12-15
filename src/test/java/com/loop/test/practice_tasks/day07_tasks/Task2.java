package com.loop.test.practice_tasks.day07_tasks;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

/*
    1. go to https://loopcamp.vercel.app/
    2. click "Multiple Windows" link
    3. Validate "Powered by Loopcamp" is displayed
    4. Validate title is "Windows"
    5. Click - click here
    6. Switch to new window and validate title
 */

public class Task2 extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        //Navigating to website
        driver.get("https://loopcamp.vercel.app");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Clicking "Multiple Windows" link
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        //Validating that "Powered by LOOPCAMP" is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Powered by')]")).isDisplayed(),
                "\"Powered by LOOPCAMP isn't\" displayed!" );
        //Validating that title is "Windows"
        Assert.assertEquals(driver.getTitle(), "Windows", "Titles aren't matching!");
        //Clicking "Click Here" link
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        //Switching to new window
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
        }
        //Validating new window title
        Assert.assertEquals(driver.getTitle(), "New Window", "Titles aren't matching!");
    }
}