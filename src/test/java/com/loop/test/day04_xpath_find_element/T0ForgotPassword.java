package com.loop.test.day04_xpath_find_element;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T0ForgotPassword {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/login?redirect=%2F");
        driver.findElement(By.cssSelector("a[href='/reset-password']")).click();
        if (driver.findElement(By.cssSelector("div[class='login-layout__form'] > h1")).getText().equals(DocuportConstants.EXPECTED_RESET_PASSWORD_TEXT_DOCUPORT)) {
            System.out.println("Results are matching ---> TEST PASSED!");
        } else {
            System.err.println("Results aren't matching ---> TEST FAILED!");
        }
        driver.quit();
    }
}