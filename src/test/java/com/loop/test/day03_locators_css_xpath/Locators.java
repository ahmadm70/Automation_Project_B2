package com.loop.test.day03_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxWithName = driver.findElement(By.name("q"));
        WebElement searchBoxWithLinkText = driver.findElement(By.linkText("About"));
        //searchBoxWithLinkText.click();        Clicks the given button
        searchBoxWithID.sendKeys("Java Oracle");
        searchBoxWithID.clear();        //Clears the search box in this case
        String textToSearch = "Loop Academy";
        searchBoxWithID.sendKeys(textToSearch + Keys.ENTER);
        //String actualTitle = driver.getTitle();       If we want to check actual vs expected title (URL as well)
        driver.quit();
    }
}