package com.loop.test.day11_waits_pom;

import com.loop.pages.LoopPracticeDynamicLoadingPage7;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1ExplicitWait {
    LoopPracticeDynamicLoadingPage7 loopPracticeDynamicLoadingPage;
    WebDriverWait wait;
    @BeforeMethod
    public void setUpMethod() {
        loopPracticeDynamicLoadingPage = new LoopPracticeDynamicLoadingPage7();
        Driver.getDriver().get(ConfigurationReader.getProperty("loopcamp.url"));
    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }
    @Test
    public void explicitWaitTest() {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dynamic title", "Results aren't matching!");
        Assert.assertTrue(loopPracticeDynamicLoadingPage.doneMessage.isDisplayed());
        Assert.assertTrue(loopPracticeDynamicLoadingPage.image.isDisplayed());
    }
}