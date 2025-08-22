package com.juaracoding.aplikasihadir.page;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1qamc72']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement errorElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
            );
            return errorElement.getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void waitReady() {
        System.out.println("Menunggu halaman login dimuat...");
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        System.out.println("Halaman login berhasil dimuat.");
    }


}
