package com.loop.test.day11_waits_pom;

import com.loop.pages.LoopPracticeDynamicLoadingPage1;
import com.loop.test.utilities.BrowserUtilities;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
    1. go to https://loopcamp.vercel.app/dynamic_loading/1.html
    2. click start
    3. wait loading bar disappears
    4. validate username is displayed
    5. enter username tomsmith
    6. enter password incorrectpassword
    7. click submit button
    8. validate "Your password is invalid!" is displayed
     */

public class T2DynamicLoading1 {
    LoopPracticeDynamicLoadingPage1 loopPracticeDynamicLoadingPage1;
    Actions action;
    @BeforeMethod
    public void setUpMethod() {
        loopPracticeDynamicLoadingPage1 = new LoopPracticeDynamicLoadingPage1();
        action = new Actions(Driver.getDriver());
    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }
    @Test
    public void dynamicLoading1() {
        BrowserUtilities.loopLinkClick("Dynamic Loading");
        BrowserUtilities.waitForClickable(loopPracticeDynamicLoadingPage1.dynamicLoading1, 5).click();
        BrowserUtilities.waitForClickable(loopPracticeDynamicLoadingPage1.startButton, 5).click();
        BrowserUtilities.waitForInvisibility(loopPracticeDynamicLoadingPage1.loadingBar, 10);
        Assert.assertTrue(loopPracticeDynamicLoadingPage1.username.isDisplayed());
        Assert.assertTrue(loopPracticeDynamicLoadingPage1.password.isDisplayed());
        loopPracticeDynamicLoadingPage1.username.sendKeys("tomsmith");
        loopPracticeDynamicLoadingPage1.password.sendKeys("tomsmith");
        loopPracticeDynamicLoadingPage1.submitButton.click();
        Assert.assertTrue(loopPracticeDynamicLoadingPage1.errorMessage.isDisplayed());
    }
}