package com.loop.test.practice_tasks.day04_tasks;

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
        driver.get("https://beta.docuport.app/login?redirect=%2F");
        //Logging in as a client
        driver.findElement(By.id("input-14")).sendKeys(DocuportConstants.USERNAME_FOR_ADVISOR);
        driver.findElement(By.id("input-15")).sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //Storing left navigate items into List
        Thread.sleep(1000);
        List<WebElement> listBox = new ArrayList<>();
        //Iterating and printing out "href" values for each web element
        listBox.addAll(driver.findElements(By.xpath("//div[@role='listbox']//a")));
        for (WebElement each : listBox) {
            System.out.println(each.getAttribute("href"));
        }
        //Validating titles for left navigate items
        ArrayList<String> titles = new ArrayList<>(Arrays.asList("Home", "Received docs", "My uploads", "Clients", "Invitations", "Users", "Leads", "Bookkeeping", "1099 Form", "Reconciliations"));
        for (int i = 1; i <= titles.size(); i++) {
            if (driver.findElement(By.xpath("//div[@role='listbox']//a[" + i + "]//div//div//span")).getText().equals(titles.get(i - 1))) {
                System.out.println("Results are matching ---> TEST PASSED!");
            } else {
                System.err.println("Results aren't matching ---> TEST FAILED!");
            }
        }
        driver.quit();
    }
}