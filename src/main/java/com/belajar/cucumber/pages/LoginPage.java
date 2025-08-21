package com.belajar.cucumber.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement masukButton;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1qamc72']")
    public WebElement errorMessage;

    @FindBy(xpath = "//button[normalize-space()='disini']")
    public WebElement registerButton;

    @FindBy(id = "nik")
    private WebElement NIK;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void setEmail(String value) {
        email.sendKeys(value);
    }

    public void setPassword(String value) {
        password.sendKeys(value);
    }

    public void clickMasukButton() {
        masukButton.click();
    }

    public void setNIK(String value) {
        NIK.sendKeys(value);
    }

    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1qamc72']")
            ));
            return errorMessage.getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void performLogin() {
        setEmail("hadirsqa1@gmail.com");
        setPassword("SQA@Hadir12345");
        clickMasukButton();
    }

    public void performLogin(String username, String password) {
        setEmail(username);
        setPassword(password);
        clickMasukButton();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}