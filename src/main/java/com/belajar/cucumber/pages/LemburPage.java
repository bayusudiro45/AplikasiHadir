package com.belajar.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LemburPage {

    private WebDriver driver;
    private By buttonKembali = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/a[1]/button[1]/p[1]");




    public LemburPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setButtonKembali(){
        WebElement button = driver.findElement(buttonKembali);
        button.click();
    }




}
