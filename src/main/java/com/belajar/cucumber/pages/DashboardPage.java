package com.belajar.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage {
  private WebDriver driver;

  public DashboardPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getCurrentURL() {
    return driver.getCurrentUrl();
  }
}
