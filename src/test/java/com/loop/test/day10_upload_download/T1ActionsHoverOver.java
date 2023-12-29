package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T1ActionsHoverOver {
    @Test
    public void hoverOver() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        WebElement googleSearch = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        WebElement feelingLucky = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']"));
        Actions action = new Actions(Driver.getDriver());
        Thread.sleep(2000);
        action.moveToElement(googleSearch).perform();
        Thread.sleep(2000);
        action.moveToElement(feelingLucky).perform();
        action.sendKeys(Keys.UP).perform();
        Driver.closeDriver();
    }
}