package com.loop.test.practice_tasks.day06_tasks;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1. go to https://demoqa.com/nestedframes
2. Validate "Child Iframe" text
3. Validate "Parent Iframe" text
4. Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspector or firebug
    to check out the HTML source. In total, you can switch between the parent frame and the nested child frame."
 */

public class Task2 extends TestBase {
    @Test
    public void test1() {
        //Navigating to website
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Validating "Child Iframe" text
        Assert.assertEquals(driver.switchTo().frame("frame1").switchTo().frame(0).findElement(By.xpath("//p")).getText(),
                "Child Iframe", "Results aren't matching!");
        //Validating "Parent frame" text
        Assert.assertEquals(driver.switchTo().parentFrame().findElement(By.xpath("//body")).getText(),
                 "Parent frame", "Results aren't matching!");
        //Validating main text
        Assert.assertEquals(driver.switchTo().defaultContent().findElement(By.xpath("//div[@id='framesWrapper']//div")).getText(),
                 "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or" +
                         " firebug to check out the HTML source. In total you can switch between the parent frame and" +
                         " the nested child frame.", "Results aren't matching!");
    }
}