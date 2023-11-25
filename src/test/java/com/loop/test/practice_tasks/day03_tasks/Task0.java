package com.loop.test.practice_tasks.day03_tasks;

import com.loop.test.utilities.LoopCampConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task0 {
    public static void main(String[] args) throws InterruptedException {
        //Setting up a driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to website
        driver.get("https://loopcamp.vercel.app/forgot-password.html");
        //Locating "Forgot Password" text using CSS
        WebElement forgotPassword = driver.findElement(By.cssSelector("#content > div > h2"));
        if (forgotPassword.getText().equals(LoopCampConstants.EXPECTED_FORGOT_PASSWORD_TEXT)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        //Locating "Email" text using CSS
        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        if (email.getText().equals(LoopCampConstants.EXPECTED_EMAIL_TEXT)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        //Locating input bar for email using CSS
        WebElement emailInputBar = driver.findElement(By.cssSelector("#email"));
        Thread.sleep(1000);
        emailInputBar.click();
        Thread.sleep(1000);
        emailInputBar.sendKeys("Testing input bar");
        Thread.sleep(1000);
        //Locating "Retrieve password" button text using CSS
        WebElement retrievePassword = driver.findElement(By.cssSelector("i[class]"));
        if (retrievePassword.getText().equals(LoopCampConstants.EXPECTED_RETRIEVE_PASSWORD_TEXT)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        //Locating "Powered by LOOPCAMP" text using CSS
        WebElement poweredByLOOPCAMP = driver.findElement(By.cssSelector("div[style]"));
        if (poweredByLOOPCAMP.getText().equals(LoopCampConstants.EXPECTED_POWERED_BY_LOOPCAMP_TEXT)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        driver.quit();
    }
}