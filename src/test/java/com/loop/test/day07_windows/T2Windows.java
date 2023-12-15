package com.loop.test.day07_windows;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class T2Windows extends TestBase {
    @Test
    public void window_practice() {
        driver.get("https://the-internet.herokuapp.com/windows");
        Assert.assertEquals(driver.getTitle(), "The Internet", "Results aren't matching!");
        WebElement clickHereButton = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]")).click();
        clickHereButton.click();
        clickHereButton.click();
        clickHereButton.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            System.out.println(each);
            driver.switchTo().window(each);
        }
        List<String> listHandles = new ArrayList<>(windowHandles);
        for (int i = 0; i < listHandles.size(); i++) {
            System.out.println(driver.switchTo().window(listHandles.get(i)).getTitle());
        }
        Assert.assertEquals(driver.getTitle(), "New Window", "Results aren't matching!");
        WebElement newWindowText = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
    }
}