package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.InputMismatchException;

public class DocuportUtilities {
    /**
     * Logs in to the docuport application
     * @param driver, which initialized in TestBase class
     * @param role, comes from DocuportConstants
     * @author Ahmad
     */
    public static void login(WebDriver driver, String role) throws InterruptedException {
        driver.get("https://beta.docuport.app/");
        WebElement username = driver.findElement(By.xpath("//label[contains(text(),'Username or email')]//following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//label[contains(text(),'Password')]//following-sibling::input"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        switch(role.toLowerCase()) {
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_FOR_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_FOR_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_FOR_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_FOR_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
            default: throw new InputMismatchException("There isn't such a role: " + role);
        }
        loginButton.click();
        Thread.sleep(2000);
        if (role.equalsIgnoreCase("client")) {
            WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit']"));
            continueButton.click();
        }
    }

    /**
     * Logs out from the docuport application
     * @param driver
     * @author Ahmad
     */
    public static void logout(WebDriver driver) {
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        WebElement logOutButton = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOutButton.click();
    }
}