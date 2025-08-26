package com.belajar.cucumber.definitions.authentications;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.belajar.cucumber.definitions.providers.AuthProviders;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hook {
  public static AuthProviders driver;

  @After
  public void tearDown(Scenario scenario){
    final byte[] screenshot = ((TakesScreenshot) driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png", scenario.getName());  
    if (driver != null) {
        driver.close();
        driver = null; // Optional: clear the reference
    }
  } 
}
