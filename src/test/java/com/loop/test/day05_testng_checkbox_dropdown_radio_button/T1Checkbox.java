package com.loop.test.day05_testng_checkbox_dropdown_radio_button;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T1Checkbox {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        //Finding it without index: //input/following-sibling::text()[contains(.,'checkbox 1')]/preceding-sibling::input
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        //input/following-sibling::text()[contains(.,' checkbox 2')]/preceding-sibling::input/following-sibling::input
        if (!checkbox1.isSelected()) {
            System.out.println("Checkbox isn't selected ---> TEST PASSED!");
        } else {
            System.err.println("Checkbox is selected ---> TEST FAILED!");
        }
        if (checkbox2.isSelected()) {
            System.out.println("Checkbox is selected ---> TEST PASSED!");
        } else {
            System.err.println("Checkbox isn't selected ---> TEST FAILED!");
        }
        checkbox1.click();
        checkbox2.click();
        if (checkbox1.isSelected()) {
            System.out.println("Checkbox is selected ---> TEST PASSED!");
        } else {
            System.err.println("Checkbox isn't selected ---> TEST FAILED!");
        }
        if (!checkbox2.isSelected()) {
            System.out.println("Checkbox isn't selected ---> TEST PASSED!");
        } else {
            System.err.println("Checkbox is selected ---> TEST FAILED!");
        }
        driver.quit();
    }
}