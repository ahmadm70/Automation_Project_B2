package com.loop.test.practice_tasks.day08_tasks;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtilities;
import com.loop.test.utilities.DocuportWebTableUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
 */

public class Task1 extends TestBase {
    @Test
    public void docuportWebTable() throws InterruptedException {
        //Logging in as an advisor
        DocuportUtilities.login(driver, DocuportConstants.ADVISOR);
        driver.manage().window().maximize();
        //Clicking "Users" link
        driver.findElement(By.xpath("//a[@href='/users']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Validating full name
        String actualFullName = DocuportWebTableUtilities.returnAnyField(driver, "alex.de.souza@gmail.com", "full name");
        String expectedFullName = "Alex De Souza";
        Assert.assertEquals(actualFullName, expectedFullName, "Full names aren't matching!");
        //Validating username
        String actualUsername = DocuportWebTableUtilities.returnAnyField(driver, "alex.de.souza@gmail.com", "username");
        String expectedUsername = "alexdesouze";
        Assert.assertEquals(actualFullName, expectedFullName, "Usernames aren't matching!");
        //Validating phone number
        String actualPhoneNumber = DocuportWebTableUtilities.returnAnyField(driver, "alex.de.souza@gmail.com", "phone number (extension)");
        String expectedPhoneNumber = "+994512060042";
        Assert.assertEquals(actualFullName, expectedFullName, "Phone numbers aren't matching!");
        //Validating role
        String actualRole = DocuportWebTableUtilities.returnAnyField(driver, "alex.de.souza@gmail.com", "role");
        String expectedRole = "Client";
        Assert.assertEquals(actualFullName, expectedFullName, "Roles aren't matching!");
        //Validating advisor
        String actualAdvisor = DocuportWebTableUtilities.returnAnyField(driver, "alex.de.souza@gmail.com", "advisor");
        String expectedAdvisor = "Batch1 Group1";
        Assert.assertEquals(actualFullName, expectedFullName, "Advisors aren't matching!");
    }
}