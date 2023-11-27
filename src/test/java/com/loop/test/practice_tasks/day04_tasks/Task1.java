package com.loop.test.practice_tasks.day04_tasks;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        //Setting up a driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to website
        driver.get("https://beta.docuport.app/");
        driver.manage().window().maximize();
        //Logging in as a client
        driver.findElement(By.id("input-14")).sendKeys(DocuportConstants.USERNAME_FOR_CLIENT);
        driver.findElement(By.id("input-15")).sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Validating that "Home", "Received docs", "My uploads", "Invitations" are displayed
        for (int i = 1; i <= 4; i++) {
            if (driver.findElement(By.xpath("//div[@role='listbox']//a[" + i + "]")).isDisplayed()) {
                System.out.println("Web element is displayed ---> TEST PASSED!");
            } else {
                System.err.println("Web element isn't displayed ---> TEST FAILED!");
            }
        }
        //Clicking three lines
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='col col-4']//button")).click();
        //Validating that "Home", "Received docs", "My uploads", "Invitations" aren't displayed
        Thread.sleep(1000);
        for (int i = 1; i <= 4; i++) {
            if (!driver.findElement(By.xpath("//div[@role='listbox']//a[" + i + "]")).isDisplayed()) {
                System.out.println("Web element isn't displayed ---> TEST PASSED!");
            } else {
                System.err.println("Web element is displayed ---> TEST FAILED!");
            }
        }
        driver.quit();
    }
}