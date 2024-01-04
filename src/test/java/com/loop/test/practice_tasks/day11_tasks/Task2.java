package com.loop.test.practice_tasks.day11_tasks;

import com.loop.pages.LoopPracticeDragDropPage;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task2 {
    LoopPracticeDragDropPage loopPracticeDragDropPage;
    Actions action;
    @BeforeClass
    public void setUp() {
        loopPracticeDragDropPage = new LoopPracticeDragDropPage();
        action = new Actions(Driver.getDriver());
        //Navigating to website
        Driver.getDriver().get(ConfigurationReader.getProperty("loopcamp.url"));
    }
    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
    @Test
    public void test1() {
        //Clicking and holding small circle
        action.clickAndHold(loopPracticeDragDropPage.smallCircle).perform();
        //Moving it into the big circle
        action.moveToElement(loopPracticeDragDropPage.bigCircle).perform();
        //Validating "Now drop..." text
        Assert.assertEquals(loopPracticeDragDropPage.bigCircle.getText(), "Now drop...", "Results aren't matching!");
    }
    @Test
    public void test2() {
        //Clicking and holding small circle
        action.clickAndHold(loopPracticeDragDropPage.smallCircle).perform();
        //Moving it anywhere except big circle
        action.moveByOffset(500, 500).perform();
        //Dropping it
        action.click().perform();
        //Validating "Try again!" text
        Assert.assertEquals(loopPracticeDragDropPage.bigCircle.getText(), "Try again!", "Results aren't matching!");
    }
}