package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class T2ActionsDragDrop {
    @Test
    public void dragDrop() {
        Driver.getDriver().get(ConfigurationReader.getProperty("guru.url"));
        Actions action = new Actions(Driver.getDriver());
        WebElement bankButton = Driver.getDriver().findElement(By.cssSelector("#credit2 > a"));
        WebElement debitAccount = Driver.getDriver().findElement(By.id("bank"));
        action.dragAndDrop(bankButton, debitAccount).perform();
        WebElement fiveThousand = Driver.getDriver().findElement(By.id("fourth"));
        WebElement debitAmount = Driver.getDriver().findElement(By.id("amt7"));
        action.dragAndDrop(fiveThousand, debitAmount).perform();
        WebElement salesButton = Driver.getDriver().findElement(By.cssSelector("#credit1 > a"));
        WebElement creditAccount = Driver.getDriver().findElement(By.id("loan"));
        action.dragAndDrop(salesButton, creditAccount).perform();
        WebElement creditAmount = Driver.getDriver().findElement(By.id("amt8"));
        action.dragAndDrop(fiveThousand, creditAmount).perform();
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Perfect')]"));
        String expected = "Perfect!";
        Assert.assertEquals(successMessage.getText(), expected, "Results aren't matching!");
        Driver.closeDriver();
    }
}