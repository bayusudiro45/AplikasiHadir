package com.belajar.cucumber.pages;

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

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]")
    private WebElement jamKeluarButton;

    @FindBy(id = "is_wfh")
    private WebElement pilihTipeAbsen;

    @FindBy(xpath = "//button[normalize-space()='Ajukan']")
    private WebElement ajukanButton;

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-1ub5lza")
    private WebElement total;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[4]")
    private WebElement tipeAbsen;

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1bwr8un'])[1]")
    private WebElement pesanError;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetButton;

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

    public void clickJamKeluarButton(){
        jamKeluarButton.click();
    }

    public void clickPilihTipeAbsen(){
        pilihTipeAbsen.click();
    }

    public void clickAjukanButton(){
        ajukanButton.click();
    }

    public int getTotal(){
        String fullText = total.getText();
        String[] parts = fullText.split(" ");
        String numberString = parts[parts.length - 1]; // "210"
        return Integer.parseInt(numberString);
    }

    public String getTipeAbsen(){
        String fullText =tipeAbsen.getText();
        String[] parts = fullText.split(" ");
        return parts[parts.length - 1]; 
    }
    
    public String getPesanError(){
        return pesanError.getText();
    }

    public void clickResetButton(){
        resetButton.click();
    }
}
