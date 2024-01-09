package com.loop.test.practice_tasks.day12_tasks;

import com.github.javafaker.Faker;
import com.loop.pages.SmartBearSoftwareLoginPage;
import com.loop.pages.SmartBearSoftwarePage;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
public class Task1 {
    SmartBearSoftwareLoginPage smartBearSoftwareLoginPage;
    SmartBearSoftwarePage smartBearSoftwarePage;
    WebDriverWait wait;
    Select select;
    Faker faker;
    @BeforeMethod
    public void setUp() {
        smartBearSoftwareLoginPage = new SmartBearSoftwareLoginPage();
        smartBearSoftwarePage = new SmartBearSoftwarePage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        faker = new Faker();
        //Navigating to website
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbear.url"));
        wait.until(ExpectedConditions.titleIs("Web Orders Login"));
    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
    @Test
    public void test() {
        //Entering login credentials & logging in
        smartBearSoftwareLoginPage.usernameBar.sendKeys("Tester");
        smartBearSoftwareLoginPage.passwordBar.sendKeys("test");
        smartBearSoftwareLoginPage.loginButton.click();
        wait.until(ExpectedConditions.titleIs("Web Orders"));
        //Clicking Order link
        smartBearSoftwarePage.orderButton.click();
        //Filling out information
        select = new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByVisibleText("FamilyAlbum");
        smartBearSoftwarePage.quantityBar.sendKeys("2");
        smartBearSoftwarePage.calculateButton.click();
        smartBearSoftwarePage.nameBar.sendKeys(faker.name().fullName());
        smartBearSoftwarePage.streetBar.sendKeys(faker.address().streetName());
        smartBearSoftwarePage.cityBar.sendKeys(faker.address().cityName());
        smartBearSoftwarePage.stateBar.sendKeys(faker.address().state());
        smartBearSoftwarePage.zipBar.sendKeys(faker.numerify("#####"));
        smartBearSoftwarePage.visaRadioButton.click();
        smartBearSoftwarePage.cardNumberBar.sendKeys(faker.numerify("################"));
        smartBearSoftwarePage.expireDateBar.sendKeys("01/2025");
        //Clicking to Process button and validating "New order has been successfully added." message
        smartBearSoftwarePage.processButton.click();
        Assert.assertEquals(smartBearSoftwarePage.successMessage.getText(), "New order has been successfully added.",
                 "Results aren't matching!");
    }
}