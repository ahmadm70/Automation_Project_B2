package com.loop.test.practice_tasks.day03_tasks;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        //Setting up a driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to website
        driver.get("https://beta.docuport.app/login");
        //Logging in
        Thread.sleep(1000);
        driver.findElement(By.id("input-14")).sendKeys(DocuportConstants.USERNAME_FOR_SUPERVISOR +
                Keys.TAB + DocuportConstants.PASSWORD_FOR_LOGIN);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);
        //Validating successful login
        if (driver.getCurrentUrl().equals(DocuportConstants.URL_HOMEPAGE_DOCUPORT)) {
            System.out.println("Successful log in ---> TEST PASSED!");
        } else {
            System.err.println("Unsuccessful log in ---> TEST FAILED!");
        }
        //Logging out
        driver.findElement(By.cssSelector("#app")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[class='v-avatar primary']")).click();
        Thread.sleep(1000);
        ArrayList<WebElement> batch1Group2 = new ArrayList<>();
        batch1Group2.addAll(driver.findElements(By.cssSelector("span[class='body-2']")));
        batch1Group2.get(2).click();
        Thread.sleep(1000);
        //Validating successful logout
        if (driver.getCurrentUrl().equals(DocuportConstants.URL_LOGIN_PAGE_DOCUPORT)) {
            System.out.println("Successful log out ---> TEST PASSED!");
        } else {
            System.err.println("Unsuccessful log out ---> TEST FAILED!");
        }
        Thread.sleep(1000);
        driver.quit();
    }
}