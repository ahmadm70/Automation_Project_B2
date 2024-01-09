package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SmartBearSoftwarePage {
    @FindBy(xpath = "//a")
    public List<WebElement> linksList;
    @FindBy(xpath = "//a[contains(text(),'Order')]")
    public WebElement orderButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBar;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement calculateButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement nameBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaRadioButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDateBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;
    @FindBy(xpath = "//strong")
    public WebElement successMessage;
    public SmartBearSoftwarePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}