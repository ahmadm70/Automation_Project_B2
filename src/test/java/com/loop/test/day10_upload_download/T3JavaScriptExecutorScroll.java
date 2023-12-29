package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class T3JavaScriptExecutorScroll {
    @Test
    public void jsExecutorScroll() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy.url"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement emailBox = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
        Actions action = new Actions(Driver.getDriver());
        //1st way
        //action.moveToElement(emailBox).perform();
        //2nd way
        //action.scrollToElement(emailBox).perform();
        //3rd way
        //action.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        //4th way - moving horizontally or vertically //TODO - INTERVIEW ANSWER
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeAsyncScript("window.scroll(0, 5000)");
        //5th way
        js.executeScript("arguments[0].scrollIntoView(true)", emailBox);
        //--------------------------------------------------------------------------------------------------------------
        js.executeScript("arguments[0].click", emailBox);       //Clicking element using JSExecutor
        Thread.sleep(2000);
        js.executeScript("window.scroll(0, 0)");
    }
}