package com.belajar.cucumber.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CutiPage {

    private WebDriver driver;

    private By buttonAjukanCuti = By.xpath("//button[normalize-space()='Ajukan Cuti']");
    private By buttonInfoCuti = By.xpath("//button[normalize-space(text())='Info Cuti']");
    private By ListDataCuti = By.xpath("//span[contains(@class,'css-ikswwf')]");
    private By buttonAjukan = By.xpath("//button[normalize-space()='Ajukan']");
    private By messageError = By.xpath("//div[contains(@class,'MuiSnackbarContent-message')]");
    private By notifikasiError = By.xpath("//div[contains(@class,'MuiSnackbarContent-root')]");
    private By closeNotifikasiError = By.xpath("//button[@aria-label='close']");
    private By leaveTypeDropdown = By.xpath("//div[@id='leave_type_id']");
    private By pilihTahun = By.cssSelector("span.rdrYearPicker select");
    private By pilihBulan = By.cssSelector("span.rdrMonthPicker select");
    private By buttonSimpan = By.xpath("//button[normalize-space()='Simpan']");
    private By catatan = By.xpath("//textarea[@id='notes']");

    public CutiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickAjukanCuti() {
        WebElement button = driver.findElement(buttonAjukanCuti);
        button.click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void clickInfoCuti() {
        WebElement button = driver.findElement(buttonInfoCuti);
        button.click();
    }

    public boolean isListDataCutiDisplayed() {
        WebElement element = driver.findElement(ListDataCuti);
        return element.isDisplayed();
    }

    public void clickAjukan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Ajukan']")));
        WebElement button = driver.findElement(buttonAjukan);
        button.click();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return driver.findElement(messageError).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isNotificationDisplayed() {
        try {
            return driver.findElement(notifikasiError).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void closeNotification() {
        driver.findElement(closeNotifikasiError).click();
    }

    public void selectLeaveType(String leaveType) {
        driver.findElement(leaveTypeDropdown).click();
        By option = By.xpath("//li[contains(text(),'" + leaveType + "')]");
        WebElement optionElement = driver.findElement(option);
        optionElement.click();
    }

    public void clickDivElement() {
        try {
            WebElement divElement = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", divElement);
            System.out.println("Element clicked successfully with JavaScript");
        } catch (Exception e) {
            System.err.println("Error clicking element: " + e.getMessage());
        }
    }

    public WebElement setpilihTahun() {
        return driver.findElement(pilihTahun);
    }

    public WebElement setpilihBulan() {
        return driver.findElement(pilihBulan);
    }

    public void pilihTanggal(String tanggal) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tanggalElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='" + tanggal + "' and not(@tabindex='-1')]")
        ));

        try {
            tanggalElement.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tanggalElement);
        }
    }

    public void clickButtonSimpan() {
        WebElement button = driver.findElement(buttonSimpan);
        button.click();
    }

    public void setCatatan(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputCatatan = wait.until(ExpectedConditions.visibilityOfElementLocated(catatan));
        inputCatatan.sendKeys(message);
    }

}