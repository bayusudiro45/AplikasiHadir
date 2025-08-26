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

public class LupaPasswordPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailLupaPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1qamc72']")
    private WebElement validationMessage;

    public LupaPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
  
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void setEmail(String email){
        emailLupaPassword.sendKeys(email);
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public String getValidationMessage(){
       try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiTypography-root.MuiTypography-body1.css-1qamc72")));
            return validationMessage.getText();
        } catch (NoSuchElementException e) {
            return null;
    }
    }
}
