package com.loop.test.practice_tasks.day08_tasks;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.LoopcampVercelWebTableUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1. go to https://loopcamp.vercel.app/web-tables.html
    2. create a method to test given field for a given name
    3. test type
    4. test amount
    5. test date
    6. test street
    7. test city
    8. test state
    9. test zip
    10. test card
    11. test card number
    12. test exp
 */

public class Task2 extends TestBase {
    @Test
    public void loopcampWebTable() {
        //Navigating to website
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String name = "Alexandra Gray";
        //Validating pizza type
        String actualPizzaType = LoopcampVercelWebTableUtilities.returnAnyField(driver, name, "pizza type");
        String expectedPizzaType = "Thin Crust";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Pizza types aren't matching!");
        //Validating amount
        String actualAmount = LoopcampVercelWebTableUtilities.returnAnyField(driver, name, "amount");
        String expectedAmount = "2";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Amounts aren't matching!");
        //Validating date
        String actualDate = LoopcampVercelWebTableUtilities.returnAnyField(driver, name, "date");
        String expectedDate = "04/15/2021";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Dates aren't matching!");
        //Validating street
        String actualStreet = LoopcampVercelWebTableUtilities.returnAnyField(driver, name, "street");
        String expectedStreet = "7, Miller Street";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Streets aren't matching!");
        //Validating city
        String actualCity = LoopcampVercelWebTableUtilities.returnAnyField(driver, name, "city");
        String expectedCity = "Chicago, IL";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Cities aren't matching!");
        //Validating state
        String actualState = LoopcampVercelWebTableUtilities.returnAnyField(driver, name, "state");
        String expectedState = "US";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "States aren't matching!");
        //Validating zip
        String actualZip = LoopcampVercelWebTableUtilities.returnAnyField(driver, name, "zip");
        String expectedZip = "748";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Zip codes aren't matching!");
        //Validating card
        String actualCard = LoopcampVercelWebTableUtilities.returnAnyField(driver, name, "card");
        String expectedCard = "VISA";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Card types aren't matching!");
        //Validating card numbers
        String actualCardNumber = LoopcampVercelWebTableUtilities.returnAnyField(driver, name, "card number");
        String expectedCardNumber = "321456789012";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Card numbers aren't matching!");
        //Validating exp
        String actualExp = LoopcampVercelWebTableUtilities.returnAnyField(driver, name, "exp");
        String expectedExp = "02/24";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Expiration dates aren't matching!");
    }
}