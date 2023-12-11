package com.loop.test.practice_tasks.day06_tasks;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1. go to https://demoqa.com/alerts
2. click - click button to see alert
3. handle alert
4. click - On button click, alert will appear after 5 seconds
5. handle alert
6. click - On button click, confirm box will appear
7. click ok and validate - You selected Ok
8. after that do it again this time cancel and validate - You selected Cancel
9. click - On button click, prompt box will appear
10. enter "Loop Academy" and validate You entered Loop Academy
 */

public class Task1 extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        //Navigating to website
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Clicking "Click Button to see alert" button
        driver.findElement(By.cssSelector("#alertButton")).click();
        Thread.sleep(2000);
        //Handling alert
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        //Clicking "On button click, alert will appear after 5 seconds" button
        driver.findElement(By.cssSelector("#timerAlertButton")).click();
        Thread.sleep(7000);
        //Handling alert
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        //Clicking "On button click, confirm box will appear" button
        driver.findElement(By.cssSelector("#confirmButton")).click();
        Thread.sleep(2000);
        //Handling and validating alert
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("#confirmResult")).getText(), "You selected Ok", "Results aren't matching!");
        //Clicking "Cancel" button this time, handling and validating alert
        driver.findElement(By.cssSelector("#confirmButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("#confirmResult")).getText(), "You selected Cancel", "Results aren't matching!");
        //Clicking "On button click, prompt box will appear" button, validating text we passed
        driver.findElement(By.cssSelector("#promtButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Loop Academy");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("#promptResult")).getText(), "You entered Loop Academy", "Results aren't matching!");
    }
}