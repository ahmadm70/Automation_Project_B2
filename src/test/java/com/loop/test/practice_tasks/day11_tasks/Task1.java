package com.loop.test.practice_tasks.day11_tasks;

import com.loop.pages.SmartBearSoftwareLoginPage;
import com.loop.pages.SmartBearSoftwarePage;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1 {
    SmartBearSoftwareLoginPage smartBearSoftwareLoginPage;
    SmartBearSoftwarePage smartBearSoftwarePage;
    WebDriverWait wait;
    @BeforeMethod
    public void setUpMethod() {
        smartBearSoftwareLoginPage = new SmartBearSoftwareLoginPage();
        smartBearSoftwarePage = new SmartBearSoftwarePage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //Navigating to website
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbear.url"));
        wait.until(ExpectedConditions.titleIs("Web Orders Login"));
    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }
    @Test
    public void smartBearTest() {
        //Entering login credentials and clicking login button
        smartBearSoftwareLoginPage.usernameBar.sendKeys("Tester");
        smartBearSoftwareLoginPage.passwordBar.sendKeys("test");
        smartBearSoftwareLoginPage.loginButton.click();
        //Waiting explicitly for making sure we landed on page
        wait.until(ExpectedConditions.titleIs("Web Orders"));
        //Printing out count of links on landing page
        System.out.println("Number of links: " + smartBearSoftwarePage.linksList.size());
        //Printing out link texts on landing page
        for (WebElement each : smartBearSoftwarePage.linksList) {
            System.out.println(each.getText());
        }
    }
}