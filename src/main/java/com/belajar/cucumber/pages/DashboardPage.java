package com.belajar.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt='Lembur']")
    private WebElement lemburButton;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1lkqrnd'][normalize-space()='Cuti']")
    private WebElement cutiButton;

    @FindBy(xpath = "//p[normalize-space()='Absensi']")
    private WebElement absenButton;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void clickLemburButton() {
        lemburButton.click();
    }

    public void clickCutiButton() {
        cutiButton.click();
    }

    public void clickAbsenButton(){
        absenButton.click();
    }
}
