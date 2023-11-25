package com.loop.test.day03_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://loopcamp.vercel.app/registration_form.html");
        driver.manage().window().maximize();
        WebElement firstNameBox = driver.findElement(By.name("firstname"));
        firstNameBox.sendKeys("Ahmad");
        WebElement lastNameBox = driver.findElement(By.name("lastname"));
        lastNameBox.sendKeys("Mammadli");
        WebElement genderBox = driver.findElement(By.name("gender"));
        genderBox.click();
        //Line above will return us 3 elements and will always click the first one
        System.exit(0);
    }
}