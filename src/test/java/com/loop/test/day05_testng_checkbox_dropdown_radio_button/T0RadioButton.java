package com.loop.test.day05_testng_checkbox_dropdown_radio_button;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T0RadioButton {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));      //It won't wait 10 seconds if page is loaded
        WebElement red = driver.findElement(By.xpath("//input[@id='red']"));
        WebElement green = driver.findElement(By.xpath("//input[@id='green']"));
        System.out.println(red.isSelected() + " ---> before clicking");
        red.click();
        System.out.println(red.isSelected() + " ---> after clicking");
        System.out.println();
        System.out.println(red.isEnabled() + " checking if enabled");
        System.out.println(green.isEnabled() + " checking if enabled");
        driver.quit();
    }
}