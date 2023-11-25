package com.loop.test.practice_tasks.day03_tasks;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        //Setting up a driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to website
        driver.get("https://beta.docuport.app/login");
        //Validating placeholder for username
        if (driver.findElement(By.cssSelector("label[for='input-14']")).getText().equals(DocuportConstants.USERNAME_PLACEHOLDER_DOCUPORT_LOGIN)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        //Validating placeholder for password
        if (driver.findElement(By.cssSelector("label[for='input-15']")).getText().equals(DocuportConstants.PASSWORD_PLACEHOLDER_DOCUPORT_LOGIN)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        //Clicking login button without inputting login/password
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //Validating error message for username
        ArrayList<WebElement> errorMessages = new ArrayList<>();
        errorMessages.addAll(driver.findElements(By.cssSelector("div[class='v-messages__message']")));
        if (errorMessages.get(0).getText().equals(DocuportConstants.ERROR_MESSAGE_USERNAME_DOCUPORT_LOGIN)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        //Validating error message for password
        if (errorMessages.get(1).getText().equals(DocuportConstants.ERROR_MESSAGE_PASSWORD_DOCUPORT_LOGIN)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        Thread.sleep(1000);
        driver.quit();
    }
}