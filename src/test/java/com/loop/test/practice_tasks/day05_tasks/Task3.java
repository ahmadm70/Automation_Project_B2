package com.loop.test.practice_tasks.day05_tasks;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1. login as an advisor
2. go to received document
3. click search
4. click status dropdown
5. choose in progress
 */

public class Task3 {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/login?redirect=%2F");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='input-14']")).sendKeys(DocuportConstants.USERNAME_FOR_ADVISOR);
        driver.findElement(By.xpath("//input[@id='input-15']")).sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN + Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']/a[@href='/received-docs']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='mr-3 mb-1 mb-sm-0 v-btn v-btn--has-bg theme--light v-size--large']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='v-select__slot']/label[contains(.,'Status')]/following-sibling::div[@class='v-select__selections']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@tabindex='-1']/div/following-sibling::div")).click();
        Thread.sleep(1000);
    }
}