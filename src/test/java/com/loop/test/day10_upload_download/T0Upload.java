package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class T0Upload {
    @Test
    public void uploadFile() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("guru.url"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement chooseFile = Driver.getDriver().findElement(By.id("uploadfile_0"));
        String path = "C:\\Users\\ahmad\\OneDrive\\Desktop\\note.txt";
        chooseFile.sendKeys(path);
        WebElement checkbox = Driver.getDriver().findElement(By.id("terms"));
        checkbox.click();
        WebElement submitButton = Driver.getDriver().findElement(By.id("submitbutton"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//h3[@id='res']"));
        String expected = "1 file\nhas been successfully uploaded.";
        assertEquals(successMessage.getText(), expected, "Results aren't matching!");
        Driver.closeDriver();
    }
}