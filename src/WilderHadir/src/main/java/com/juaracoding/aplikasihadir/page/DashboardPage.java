package com.juaracoding.aplikasihadir.page;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locator greeting setelah login sukses
    private final By haveANiceDay = By.xpath("//p[normalize-space()='Have a nice day !']");
    private final By greetingHai = By.xpath("//p[starts-with(normalize-space(),'Hai, ')]");

    // Locator untuk menu izin
    private final By menuIzin = By.xpath("//a[.//p[text()='Izin']]");

    // [PENAMBAHAN] Locator untuk menu Sakit
    private final By menuSakit = By.xpath("//a[.//p[text()='Sakit']]");

    // Locator untuk button yang mungkin menutupi menu
    private final By possibleOverlayButton = By.xpath("//button[contains(@class, 'MuiButton-containedPrimary')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitUntilLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(haveANiceDay));
        wait.until(ExpectedConditions.visibilityOfElementLocated(greetingHai));
    }

    public boolean isAt() {
        try {
            waitUntilLoaded();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getGreetingText() {
        return driver.findElement(greetingHai).getText().trim();
    }

    public void clickMenuIzin() {
        try {
            // Tunggu hingga menu izin dapat diklik
            WebElement izinMenu = wait.until(ExpectedConditions.elementToBeClickable(menuIzin));
            
            // Coba untuk menutup elemen yang mungkin menutupi jika ada
            tryToCloseOverlay();
            
            // Gunakan JavaScript click untuk menghindari masalah element intercepted
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", izinMenu);
            
            // Tunggu hingga halaman izin dimuat
            wait.until(ExpectedConditions.urlContains("/permit"));
        } catch (StaleElementReferenceException e) {
            // Tangani stale element dengan mencoba lagi
            WebElement izinMenu = wait.until(ExpectedConditions.elementToBeClickable(menuIzin));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", izinMenu);
            wait.until(ExpectedConditions.urlContains("/permit"));
        }
    }

    // [PENAMBAHAN] Method untuk mengklik menu Sakit
    public void clickMenuSakit() {
        try {
            // Tunggu hingga menu sakit dapat diklik
            WebElement sakitMenu = wait.until(ExpectedConditions.elementToBeClickable(menuSakit));
            
            // Coba untuk menutup elemen yang mungkin menutupi jika ada
            tryToCloseOverlay();
            
            // Gunakan JavaScript click untuk menghindari masalah element intercepted
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", sakitMenu);
            
            // Tunggu hingga halaman sakit dimuat
            wait.until(ExpectedConditions.urlContains("/sick"));
        } catch (StaleElementReferenceException e) {
            // Tangani stale element dengan mencoba lagi
            WebElement sakitMenu = wait.until(ExpectedConditions.elementToBeClickable(menuSakit));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", sakitMenu);
            wait.until(ExpectedConditions.urlContains("/sick"));
        }
    }
    
    private void tryToCloseOverlay() {
        try {
            // Coba untuk menutup elemen yang mungkin menutupi menu
            WebElement overlayButton = driver.findElement(possibleOverlayButton);
            if (overlayButton.isDisplayed()) {
                // Coba untuk menutup dengan menekan ESC atau mengklik area lain
                Actions actions = new Actions(driver);
                actions.moveByOffset(10, 10).click().perform();
                Thread.sleep(500); // Tunggu sebentar
            }
        } catch (Exception e) {
            // Ignore jika tidak ditemukan elemen yang menutupi
            System.out.println("No overlay element found: " + e.getMessage());
        }
    }
}
