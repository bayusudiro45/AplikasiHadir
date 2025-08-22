// package com.juaracoding.aplikasihadir.page;

// import java.time.Duration;
// import java.util.List;
// import org.openqa.selenium.*;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

// public class MenuIzinPage {
    
//     private final WebDriver driver;
//     private final WebDriverWait wait;
    
//     // Locators for Menu Izin page
//     private final By menuIzin = By.xpath("//a[.//p[text()='Izin']]");
//     private final By tabTerlambat = By.xpath("//a[contains(@href,'permit=late')]");
//     private final By tabPulangCepat = By.xpath("//a[contains(@href,'permit=early')]");
//     // private final By urlContainsLate = By.xpath("//a[contains(@href,'permit=late')]");
//     // private final By urlContainsEarly = By.xpath("//a[contains(@href,'permit=early')]");
    
//     // Table locators
//     private final By tableIzin = By.xpath("//table[@class='table']");
//     private final By tableRows = By.xpath("//table[@class='table']/tbody/tr");
//     // private final By namaColumn = By.xpath("//table[@class='table']/tbody/tr/td[1]");
//     // private final By jenisIzinColumn = By.xpath("//table[@class='table']/tbody/tr/td[2]");
//     // private final By statusColumn = By.xpath("//table[@class='table']/tbody/tr/td[3]");
//     // private final By alasanColumn = By.xpath("//table[@class='table']/tbody/tr/td[4]");
//     // private final By tanggalDibuatColumn = By.xpath("//table[@class='table']/tbody/tr/td[5]");
    
//     public MenuIzinPage(WebDriver driver) {
//         this.driver = driver;
//         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//     }
    
//     public void clickMenuIzin() {
//         WebElement izinMenu = wait.until(ExpectedConditions.elementToBeClickable(menuIzin));
//         izinMenu.click();
//     }
    
//     public void clickTabTerlambat() {
//         WebElement terlambatTab = wait.until(ExpectedConditions.elementToBeClickable(tabTerlambat));
//         terlambatTab.click();
//     }
    
//     public void clickTabPulangCepat() {
//         WebElement pulangCepatTab = wait.until(ExpectedConditions.elementToBeClickable(tabPulangCepat));
//         pulangCepatTab.click();
//     }
    
//     public boolean isUrlContainsLate() {
//         return driver.getCurrentUrl().contains("permit=late");
//     }
    
//     public boolean isUrlContainsEarly() {
//         return driver.getCurrentUrl().contains("permit=early");
//     }
    
//     public boolean isTableDisplayed() {
//         try {
//             WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(tableIzin));
//             return table.isDisplayed();
//         } catch (TimeoutException e) {
//             return false;
//         }
//     }
    
//     public int getRowCount() {
//         List<WebElement> rows = driver.findElements(tableRows);
//         return rows.size();
//     }
    
//     public List<WebElement> getAllRows() {
//         return driver.findElements(tableRows);
//     }
    
//     public String getNamaFromRow(WebElement row) {
//         return row.findElement(By.xpath("./td[1]")).getText().trim();
//     }
    
//     public String getJenisIzinFromRow(WebElement row) {
//         return row.findElement(By.xpath("./td[2]")).getText().trim();
//     }
    
//     public String getStatusFromRow(WebElement row) {
//         return row.findElement(By.xpath("./td[3]")).getText().trim();
//     }
    
//     public String getAlasanFromRow(WebElement row) {
//         return row.findElement(By.xpath("./td[4]")).getText().trim();
//     }
    
//     public String getTanggalDibuatFromRow(WebElement row) {
//         return row.findElement(By.xpath("./td[5]")).getText().trim();
//     }
    
//     public boolean isTabTerlambatActive() {
//         WebElement tab = driver.findElement(tabTerlambat);
//         return tab.getAttribute("class").contains("active");
//     }
    
//     public boolean isTabPulangCepatActive() {
//         WebElement tab = driver.findElement(tabPulangCepat);
//         return tab.getAttribute("class").contains("active");
//     }
    
//     public void waitForPageLoad() {
//         wait.until(ExpectedConditions.visibilityOfElementLocated(tableIzin));
//     }
// }
