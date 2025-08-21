package com.belajar.cucumber.definitions.providers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.belajar.cucumber.pages.DashboardPage;
import org.openqa.selenium.WebDriver;

import com.belajar.cucumber.pages.LoginPage;
import com.belajar.cucumber.utils.DriverManager;

public class AuthProviders {
  private DriverManager driverManager;
  private WebDriver driver;
  private LoginPage loginPage;

  private DashboardPage dashboardPage;

  public void preTest() {
    driverManager = new DriverManager();
    driver = driverManager.getDriver();
    loginPage = new LoginPage(driver);
    driver.get("https://magang.dikahadir.com/absen/login");
  }

  public void preConRegister(){
    loginPage.clickRegisterButton();
  }

  public void preConditionLogin() {
    loginPage.performLogin();
  }

  public WebDriver getDriver() {
    return driverManager.getDriver();
  }

  public LoginPage loginPage() {
    return loginPage;
  }

  public DashboardPage dashboardPage(){
    dashboardPage = new DashboardPage(driver);
    return dashboardPage;
  }

  public void close() {
    driverManager.quitDriver();
  }

  private static final List<String> VALID_IDS = Arrays.asList(
        "F1240001", "D6240005", "D7240031", "D8240010", "D7240029", 
        "D7240028", "D7240027", "D6240004", "D8240008", "D7240023",
        "D7240022", "D7240021", "D7240020", "D7240019", "D8240007",
        "D6240003", "D7240018", "D9240001", "D7240017", "D7240016",
        "D7240015", "D7240014", "D6240002", "D7240013", "D7240012",
        "D7240011", "D7240010", "D1111111", "D7240009", "D7240008",
        "D6240221", "D6240215", "F1100003", "D7240007", "D7240006",
        "D6240001", "D7240005", "D7240004", "D7240003", "D7240002",
        "D7240054", "D8240001", "D8240100", "D8231780", "F1100002",
        "D7230002", "D7230001", "D8200056", "D6180244", "D8200056",
        "D8230014", "D8230013", "D8230009", "D6230561", "D7232029",
        "D7232001", "D7231985", "D7231984", "D7231983", "D7231978",
        "D7231976", "D6230555", "D6230554", "D6230553", "D7231954",
        "D6230551", "D7231946", "D7231924", "D8231347", "D6230547"
    );

    public static String getRandomValidId() {
        Random randomID = new Random();
        return VALID_IDS.get(randomID.nextInt(VALID_IDS.size()));
    }
}
