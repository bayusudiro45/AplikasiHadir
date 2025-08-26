package com.belajar.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoreksiAbsenPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[normalize-space()='Ajukan Koreksi']")
    private WebElement ajukanKoreksiButton;

    @FindBy(xpath = "//div[@class='MuiBox-root css-pampsj']//div[1]//div[1]//div[1]//div[1]//button[1]//*[name()='svg']")
    private WebElement jamMasukButton;

    public KoreksiAbsenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
  
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void clickAjukanKoreksiButton(){
        ajukanKoreksiButton.click();
    }

    public void clickJamMasukButton(){
        jamMasukButton.click();
    }

}
