package com.loop.test.day11_waits_pom;

import com.loop.pages.LoopPracticeDragDropPage;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T0DragDropPom {
    LoopPracticeDragDropPage loopPracticeDragDropPage;
    Actions action;
    @BeforeMethod
    public void setUpMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loopcamp.url"));
         loopPracticeDragDropPage = new LoopPracticeDragDropPage();
         action = new Actions(Driver.getDriver());
    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }
    @Test
    public void dragSmallHere(){
        String actual = loopPracticeDragDropPage.bigCircle.getText();
        String expected = "Drag the small circle here.";
        Assert.assertEquals(actual, expected, "Result aren't matching!");
        Driver.closeDriver();
    }
    @Test
    public void drop_here(){
        action.moveToElement(loopPracticeDragDropPage.smallCircle).clickAndHold().moveByOffset(100, 100).pause(1000).perform();
        String actual = loopPracticeDragDropPage.bigCircle.getText();
        String expected = "Drop here.";
        Assert.assertEquals(actual, expected, "Results aren't matching!");
    }
}