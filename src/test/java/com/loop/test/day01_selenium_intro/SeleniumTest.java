package com.loop.test.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        //Setting up the web driver
        WebDriverManager.chromedriver().setup();
        //Create an instance of web driver
        WebDriver driver = new ChromeDriver();
        //Thread.sleep(5000);       Doesn't navigate to webpage for the given amount of milliseconds
        //Navigates to the webpage
        driver.get("https://www.loopcamp.io");
        driver.navigate().to("https://www.youtube.com");        //Does same thing with the line above
        driver.manage().window().maximize();        //After loading webpage it will maximize the window
        driver.manage().window().fullscreen();      //After loading webpage it will turn fullscreen mode on
        driver.navigate().back();       //Navigates to the previous webpage
        driver.navigate().forward();        //Navigates to the next webpage
        driver.navigate().refresh();        //Refreshes the current webpage
        driver.close();     //Closes the Chrome, but code will still run
        driver.quit();      //Quits driver, code stops running
    }
}