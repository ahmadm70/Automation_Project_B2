package com.loop.test.day09_config_driver;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtilities;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3GoogleSearch {
    @Test (priority = 0)
    public void googleSearch(){
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        System.out.println(((RemoteWebDriver) Driver.getDriver()).getSessionId());
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("Loop Academy" + Keys.ENTER);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Loop Academy - Google Search", "Results aren't matching");
    }
    @Test (priority = 1)
    public void docuportSearch() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        System.out.println(((RemoteWebDriver) Driver.getDriver()).getSessionId());
        DocuportUtilities.login(Driver.getDriver(), DocuportConstants.ADVISOR);
        WebElement myUploads = Driver.getDriver().findElement(By.xpath("//span[contains(text(), 'My uploads')]"));
        myUploads.click();
    }
}