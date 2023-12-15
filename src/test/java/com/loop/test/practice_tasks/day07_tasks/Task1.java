package com.loop.test.practice_tasks.day07_tasks;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1. go to https://loopcamp.vercel.app/nested-frames.html
    2. validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"
 */

public class Task1 extends TestBase {
    @Test
    public void nestedIframeTest1() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.switchTo().frame(0).switchTo().frame(0).findElement(By.xpath("//body")).getText(),
                "LEFT", "Results aren't matching!");
    }
    @Test
    public void nestedIframeTest2() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.switchTo().frame(0).switchTo().frame(1).findElement(By.xpath("//body")).getText(),
                "MIDDLE", "Results aren't matching!");
    }
    @Test
    public void nestedIframeTest3() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.switchTo().frame(0).switchTo().frame(2).findElement(By.xpath("//body")).getText(),
                "RIGHT", "Results aren't matching!");
    }
    @Test
    public void nestedIframeTest4() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.switchTo().frame(1).findElement(By.xpath("//body")).getText(),
                "BOTTOM", "Results aren't matching!");
    }
}