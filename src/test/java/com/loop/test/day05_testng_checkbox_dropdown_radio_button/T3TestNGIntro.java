package com.loop.test.day05_testng_checkbox_dropdown_radio_button;

import org.testng.Assert;
import org.testng.annotations.*;

public class T3TestNGIntro {
    @BeforeMethod       //Runs before every test
    public void setUpMethod() {
        System.out.println("BeforeMethod is running");
    }
    @AfterMethod        //Runs after every test
    public void tearDownMethod() {
        System.out.println("AfterMethod is running");
    }
    @BeforeClass        //Runs before every class
    public void setUpClass() {
        System.out.println("BeforeClass is running");
    }
    @AfterClass     //Runs after every class
    public void tearDownClass() {
        System.out.println("AfterClass is running");
    }
    @Test (priority = 1)        //We can arrange running priorities manually
    public void test1() {
        System.out.println("Test1 is running");
        String actual = "Loop";
        String expected = "Loop";
        Assert.assertEquals(actual, expected, "Fail");      //Message will be displayed if assertion will fail
    }
    @Test (priority = 2)
    public void atest2() {      //TestNG runs with alphabetical order by default
        System.out.println("Test2 is running");
    }
}