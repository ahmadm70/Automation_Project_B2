package com.loop.test.day06_alerts_iframes;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.LoopCampConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class T2Iframe extends TestBase {
    @Test
    public void iframeTest() {
        driver.get("https://loopcamp.vercel.app/iframe.html");
        driver.switchTo().frame(driver.findElement(By.cssSelector("#mce_0_ifr")));
        //driver.switchTo().frame("#mce_0_ifr");        This is same thing with the line above (using only id here)
        //driver.switchTo().frame(0);       This is same thing with the lines above (using index here)
        WebElement textBox = driver.findElement(By.cssSelector("#tinymce"));
        textBox.clear();
        textBox.sendKeys("LoopAcademy");
        driver.switchTo().defaultContent();     //Moves us to the original html
        driver.switchTo().parentFrame();        //Moves us to the parent html
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), LoopCampConstants.EXPECTED_IFRAME_HEADING_TEXT, "TEST FAILED!");
    }
    @Test
    public void amazonIframe() {
        driver.get("https://www.amazon.com");
        List<WebElement> iframes = new ArrayList<>();
        iframes = driver.findElements(By.xpath("//iframe"));
        System.out.println(iframes.size());
    }
}