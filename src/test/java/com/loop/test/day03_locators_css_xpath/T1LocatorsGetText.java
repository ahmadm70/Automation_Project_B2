package com.loop.test.day03_locators_css_xpath;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1LocatorsGetText {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("input-14"));
        username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
        WebElement loginButton = driver.findElement(By.className("v-btn__content"));
        loginButton.click();
        WebElement errorMessageForEmptyPassword = driver.findElement(By.className("v-messages__message"));
        String actualErrorMessage = errorMessageForEmptyPassword.getText();
        if (actualErrorMessage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)) {
            System.out.println("They're matching. ---> TEST PASSED!");
        } else {
            System.err.println("They're not matching. ---> TEST FAILED!");
        }
        System.exit(0);
    }
}