package com.loop.test.day07_windows;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T0IframePractice extends TestBase {
    @Test (priority = 0)
    public void nestedIframeTest1() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        Assert.assertEquals(driver.switchTo().frame(0).switchTo().frame(0).findElement(By.xpath("//body")).getText(),
                "LEFT", "Results aren't matching!");
    }
    @Test (priority = 1)
    public void nestedIframeTest2() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        Assert.assertEquals(driver.switchTo().frame(0).switchTo().frame(1).findElement(By.xpath("//body")).getText(),
                "MIDDLE", "Results aren't matching!");
    }
    @Test (priority = 2)
    public void nestedIframeTest3() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        Assert.assertEquals(driver.switchTo().frame(0).switchTo().frame(2).findElement(By.xpath("//body")).getText(),
                "RIGHT", "Results aren't matching!");
    }
    @Test (priority = 3)
    public void nestedIframeTest4() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        Assert.assertEquals(driver.switchTo().frame(1).findElement(By.xpath("//body")).getText(),
                "BOTTOM", "Results aren't matching!");
    }
}