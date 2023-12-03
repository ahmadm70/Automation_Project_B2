package com.loop.test.day05_testng_checkbox_dropdown_radio_button;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2StaleElementException {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
        if (deleteButton.isDisplayed()) {
            System.out.println("Delete button is displayed ---> TEST PASSED!");
        } else {
            System.err.println("Delete button isn't displayed ---> TEST FAILED!");
        }
        Thread.sleep(2000);
        deleteButton.click();
        Thread.sleep(2000);
        try {
            deleteButton.isDisplayed();
        } catch (StaleElementReferenceException e) {
            System.out.println("Exception handled.\nDelete button isn't displayed ---> TEST PASSED!");
        }
        driver.quit();
    }
}