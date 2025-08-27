package com.belajar.cucumber.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragnDrop {
    private WebDriver driver;
    private Actions builder;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    private WebElement pilihTahunBulan;

    @FindBy(xpath = "//button[@title='Next month']//*[name()='svg']")
    private WebElement nextMonthButton;

    private String dateXpath = "//button[normalize-space()='%s']";
    public WebElement getDateButton(String date) {
        return driver.findElement(By.xpath(String.format(dateXpath, date)));
    }

    private String jamXpath = "/html/body/div[3]/div[2]/div/div/div/div[2]/div/div[4]/span[%d]";
    public WebElement getJam(int jam) {
        return driver.findElement(By.xpath(String.format(jamXpath, jam)));
    }

    private String menitXpath = "/html/body/div[3]/div[2]/div/div/div/div[2]/div/div[3]";

    public DragnDrop(WebDriver driver) {
        this.driver = driver;
        builder = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

     public void clickMinute(WebDriver driver, int minute) {
        WebElement pointer = driver.findElement(By.cssSelector(".MuiClockPointer-root"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int degrees = minute*6;
        js.executeScript("arguments[0].style.transform = 'rotateZ(" + degrees + "deg)';", pointer);
        Actions actions = new Actions(driver);
        actions.moveToElement(pointer).click().perform();
    }

    public void pilihTanggalJam(String year, String month, String date, Integer hour, Integer minute){
        pilihTahunBulan.click();
        WebElement yearButton = getDateButton(year);
        yearButton.click();
        while (!pilihTahunBulan.getText().equalsIgnoreCase(month + " " + year)) {
            nextMonthButton.click();
        }  
        WebElement dateButton = getDateButton(date);
        dateButton.click();

        builder.dragAndDrop(getJam(1), getJam(hour+1)).perform();
        clickMinute(driver, minute);
    }

}
