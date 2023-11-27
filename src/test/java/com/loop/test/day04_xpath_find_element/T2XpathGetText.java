package com.loop.test.day04_xpath_find_element;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class T2XpathGetText {
    public static void main(String[] args) throws InterruptedException {
        //Setting up a driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigate to website
        driver.get("https://beta.docuport.app/login?redirect=%2F");
        //Clicking on Forgot password
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='text-right']//a")).click();
        //Validating that URL contains "reset-password"
        if (driver.getCurrentUrl().contains("reset-password")) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        //Validating "Enter the email address associated with your account" text
        if (driver.findElement(By.xpath("//div[@class='v-messages__message']")).getText().equals(DocuportConstants.EXPECTED_RESET_PASSWORD_HINT_TEXT_DOCUPORT)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        //Entering email address
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[starts-with(@id, 'input-')]")).sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD_DOCUPORT);
        //Validating that cancel button is displayed
        if (driver.findElement(By.xpath("//div[@class='d-flex align-center justify-end']/a")).isDisplayed()) {
            System.out.println("\"Cancel\" button is displayed ---> TEST PASSED!");
        } else {
            System.err.println("\"Cancel\" button isn't displayed ---> TEST FAILED!");
        }
        //Validating that send button is displayed
        if (driver.findElement(By.xpath("//div[@class='d-flex align-center justify-end']/button")).isDisplayed()) {
            System.out.println("\"Send\" button is displayed ---> TEST PASSED!");
        } else {
            System.err.println("\"Send\" button isn't displayed ---> TEST FAILED!");
        }
        //Clicking send button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='d-flex align-center justify-end']/button")).click();
        //Validating pop-up message
        Thread.sleep(2000);
        if (driver.findElement(By.xpath("//span[@class='body-1']")).isDisplayed()) {
            System.out.println("Message is displayed after clicking send ---> TEST PASSED!");
        } else {
            System.err.println("Message isn't displayed after clicking send ---> TEST FAILED!");
        }
        try {
            System.out.println("Element is here");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element isn't there anymore");
            e.printStackTrace();
        }
        driver.quit();
    }
}