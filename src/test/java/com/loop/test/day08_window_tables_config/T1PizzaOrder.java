package com.loop.test.day08_window_tables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.LoopcampVercelWebTableUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1PizzaOrder extends TestBase {
    @Test
    public void loopcampWebTableTest() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String actualPizzaType = LoopcampVercelWebTableUtilities.returnAnyField(driver, "Alexandra Gray", "pizza type");
        String expectedPizzaType = "Thin Crust";
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Pizza types aren't matching!");
    }
}