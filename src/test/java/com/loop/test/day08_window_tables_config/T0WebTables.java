package com.loop.test.day08_window_tables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtilities;
import com.loop.test.utilities.DocuportWebTableUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T0WebTables extends TestBase {
    @Test
    public void webTableTest() throws InterruptedException {
        DocuportUtilities.login(driver, DocuportConstants.ADVISOR);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='/users']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTableUtilities.returnAnyField(driver, "alex.de.souza@gmail.com", "full name");
        Assert.assertEquals(actualFullName, expectedFullName, "Full names aren't matching!");
        String expectedUsername = "alexdesouze";
        String actualUsername = DocuportWebTableUtilities.returnAnyField(driver, "alex.de.souza@gmail.com", "username");
        Assert.assertEquals(actualFullName, expectedFullName, "Usernames aren't matching!");
        String expectedPhoneNumber = "+994512060042";
        String actualPhoneNumber = DocuportWebTableUtilities.returnAnyField(driver, "alex.de.souza@gmail.com", "phone number (extension)");
        Assert.assertEquals(actualFullName, expectedFullName, "Phone numbers aren't matching!");
        String expectedRole = "Client";
        String actualRole = DocuportWebTableUtilities.returnAnyField(driver, "alex.de.souza@gmail.com", "role");
        Assert.assertEquals(actualFullName, expectedFullName, "Roles aren't matching!");
        String expectedAdvisor = "Batch1 Group1";
        String actualAdvisor = DocuportWebTableUtilities.returnAnyField(driver, "alex.de.souza@gmail.com", "advisor");
        Assert.assertEquals(actualFullName, expectedFullName, "Advisors aren't matching!");
    }
}