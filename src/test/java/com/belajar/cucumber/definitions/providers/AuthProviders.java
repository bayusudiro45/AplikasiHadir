package com.belajar.cucumber.definitions.providers;

import org.openqa.selenium.WebDriver;

import com.belajar.cucumber.pages.LoginPage;
import com.belajar.cucumber.utils.DriverManager;

public class AuthProviders {
  private DriverManager driverManager;
  private WebDriver driver;
  private LoginPage loginPage;

  public void preTest() {
    driverManager = new DriverManager();
    driver = driverManager.getDriver();
    loginPage = new LoginPage(driver);
    driver.get("https://magang.dikahadir.com/absen/login");
  }

  public void preCondition() {
    loginPage.performLogin();
  }

  public WebDriver getDriver() {
    return driverManager.getDriver();
  }

  public LoginPage loginPage() {
    return loginPage;
  }

  public void close() {
    driverManager.quitDriver();
  }
}
