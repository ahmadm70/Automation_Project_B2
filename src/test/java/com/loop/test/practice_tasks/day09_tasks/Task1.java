package com.loop.test.practice_tasks.day09_tasks;

import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
1. go to url: https://loopcamp.vercel.app/registration_form.html
2. fill the form
3. use faker
 */

public class Task1 {
    @Test
    public void fakerForm() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loopcamp.url"));
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        Driver.getDriver().findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
        String lastName = faker.name().lastName();
        Driver.getDriver().findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
        Driver.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(firstName.charAt(0) + lastName + faker.numerify("##"));
        Driver.getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress(firstName + lastName).toLowerCase());
        Driver.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(faker.internet().password());
        Driver.getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.numerify("703-###-####"));
        Driver.getDriver().findElement(By.xpath("//input[@value='other']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@name='birthday']")).sendKeys("12/29/" + faker.numerify("19##"));
        Select department = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        department.selectByValue("DE");
        Select title = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        title.selectByValue("sdet");
        Driver.getDriver().findElement(By.xpath("//input[@value='java']")).click();
        Driver.getDriver().findElement(By.id("wooden_spoon")).click();
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']")).getText(),
                "Thanks for signing up!", "Results aren't matching!");
        Driver.closeDriver();
    }
}