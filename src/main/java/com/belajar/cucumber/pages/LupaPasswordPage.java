package com.belajar.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
       return validationMessage.getText();
    }
}
