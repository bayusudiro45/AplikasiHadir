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

public class RegisterPage {
    private WebDriver driver;

    @FindBy(id = "nik")
    private WebElement NIK;

    @FindBy(id = "fullname")
    private WebElement fullname;

    @FindBy(id = "email")
    private WebElement emailRegister;

    @FindBy(id = "password")
    private WebElement passwordRegister;

    @FindBy(id = "selfie")
    private WebElement uploadSelfie;

    @FindBy(id = "submit")
    private WebElement daftarButton;

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-1qamc72")
    private WebElement registMessage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
  
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void setNIK(String value) {
    NIK.sendKeys(value);
    }

    public void setFullname(String value) {
        fullname.sendKeys(value);
    }

    public void setEmailRegister(String value) {
        emailRegister.sendKeys(value);
    }

    public void setPasswordRegister(String value) {
        passwordRegister.sendKeys(value);
    }

    public void setUploadSelfie(String value) {
        uploadSelfie.sendKeys(value);
    }

    public void clickDaftarButton() {
        daftarButton.click();
    }

    public String getregistMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiTypography-root.MuiTypography-body1.css-1qamc72")));
            return registMessage.getText();
        } catch (NoSuchElementException e) {
            return null;
    }
  }

    public String getValidationMessage(String value) {
    if (value.equals("nik")) {
        return NIK.getAttribute("validationMessage");
    } else if (value.equals("nama")) {
        return fullname.getAttribute("validationMessage");
    } else if (value.equals("email")) {
        return emailRegister.getAttribute("validationMessage");     
    } else if (value.equals("password")) {
        return passwordRegister.getAttribute("validationMessage");    
    } else if (value.equals("file")) {
        return uploadSelfie.getAttribute("validationMessage");
    }
    return "";
}
}
