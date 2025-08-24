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
  private WebElement emailLogin;

  @FindBy(id = "password")
  private WebElement passwordLogin;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement masukButton;

  @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1qamc72']")
  public WebElement errorMessage;

  @FindBy(xpath = "//button[normalize-space()='Lupa password ?']")
  public WebElement lupaPasswordButton;

  @FindBy(xpath = "//button[normalize-space()='disini']")
    private WebElement registerPageButton;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(this.driver, this);
  }

  public void setEmailLogin(String value) {
    emailLogin.sendKeys(value);
  }

  public void setPasswordLogin(String value) {
    passwordLogin.sendKeys(value);
  }

  public void clickMasukButton() {
    masukButton.click();
  }

    public String getErrorMessage() {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1qamc72']")));
      return errorMessage.getText();
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  public void performLogin() {
    setEmailLogin("hadirsqa1@gmail.com");
    setPasswordLogin("SQA@Hadir12345");
    clickMasukButton();
  }

  public void performLogin(String username, String password) {
    setEmailLogin(username);
    setPasswordLogin(password);
    clickMasukButton();
  }

  public void clickRegisterPageButton() {
    registerPageButton.click();
  }

  public void clickLupaPasswordButton(){
    lupaPasswordButton.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.urlContains("https://magang.dikahadir.com/absen/reset-password-request"));       
  }
}
