package com.loop.test.practice_tasks.day10_tasks;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Task2 {
    @Test
    public void task2() {
        //Navigating to website
        Driver.getDriver().get(ConfigurationReader.getProperty("loopcamp.url"));
        Actions action = new Actions(Driver.getDriver());
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        //Clicking and holding small circle
        action.clickAndHold(smallCircle).perform();
        //Dropping small circle anywhere except big circle
        action.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@id='page-footer']"))).perform();
        action.click().perform();
        //Validating "Try again!" text
        Assert.assertEquals(bigCircle.getText(), "Try again!", "Results aren't matching!");
    }
}