package com.loop.test.day06_alerts_iframes;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.LoopCampConstants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;      //By using this way, we don't have to call the methods by class name
import org.testng.annotations.Test;

/*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed
*/
public class T1Alerts extends TestBase {
    @Test (priority = 0)
    public void informationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        //driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();       Same thing with the line below
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        assertEquals(driver.findElement(By.cssSelector("#result")).getText(), LoopCampConstants.EXPECTED_JS_ALERT_AFTER_CLICK_MESSAGE, "TEST FAILED");
    }
    @Test (priority = 1)
    public void confirmationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        assertEquals(driver.findElement(By.cssSelector("#result")).getText(), (LoopCampConstants.EXPECTED_JS_CONFIRM_AFTER_CLICK_OK_MESSAGE), "TEST FAILED");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        alert.dismiss();
        assertEquals(driver.findElement(By.cssSelector("#result")).getText(), (LoopCampConstants.EXPECTED_JS_CONFIRM_AFTER_CLICK_CANCEL_MESSAGE), "TEST FAILED");
    }
    @Test (priority = 2)
    public void promptAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("LoopAcademy");
        alert.accept();
        assertEquals(driver.findElement(By.cssSelector("#result")).getText(), "You entered: LoopAcademy", "TEST FAILED");
    }
}