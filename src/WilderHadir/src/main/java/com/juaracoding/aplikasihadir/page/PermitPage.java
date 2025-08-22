package com.juaracoding.aplikasihadir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PermitPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // URL
    public static final String URL = "https://magang.dikahadir.com/apps/absent/permit";

    // Locator untuk tab
    private final By tabPulangCepat = By.xpath("//button[text()='Pulang Cepat']");
    // [PERUBAHAN] Menambahkan locator untuk tab Terlambat
    private final By tabTerlambat = By.xpath("//button[text()='Terlambat']");

    // Locator untuk list izin pulang cepat
    private final By listTitlePulangCepat = By.xpath("//p[contains(text(),'List Pulang Cepat')]");
    // [PENAMBAHAN] Locator untuk list izin terlambat
    private final By listTitleTerlambat = By.xpath("//p[contains(text(),'List Izin Terlambat')]");
    private final By totalData = By.xpath("//p[contains(text(),'Total :')]");
    private final By permitCardsPulangCepat = By.xpath("//div[contains(@class,'MuiCard-root') and .//p[contains(text(),'Pulang Cepat')]]");
    // [PENAMBAHAN] Locator untuk kartu izin terlambat
    private final By permitCardsTerlambat = By.xpath("//div[contains(@class,'MuiCard-root') and .//p[contains(text(),'Jam Terlambat')]]");
    private final By buttonAjukanPulangCepat = By.xpath("//button[contains(text(),'Ajukan Pulang Cepat')]");
    // [PENAMBAHAN] Locator untuk tombol ajukan izin terlambat
    private final By buttonAjukanTerlambat = By.xpath("//button[contains(text(),'Ajukan Izin Terlambat')]");
    
    // Locator untuk header halaman
    private final By pageHeader = By.xpath("//p[normalize-space(.)='Halaman Izin']");       
    
    // Locator untuk tombol kembali
    private final By buttonKembali = By.xpath("//button[.//p[contains(text(),'Kembali')]]");

    // Locator untuk infinite scroll container
    private final By infiniteScrollContainer = By.xpath("//div[contains(@class,'infinite-scroll-component')]");

    public PermitPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void goToPage() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
    }
    
    public boolean isPageLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickTabPulangCepat() {
        try {
            WebElement pulangCepatTab = wait.until(ExpectedConditions.elementToBeClickable(tabPulangCepat));
            pulangCepatTab.click();
            // Tunggu judul list muncul
            wait.until(ExpectedConditions.visibilityOfElementLocated(listTitlePulangCepat));
        } catch (StaleElementReferenceException e) {
            // Tangani stale element dengan mencoba lagi
            WebElement pulangCepatTab = wait.until(ExpectedConditions.elementToBeClickable(tabPulangCepat));
            pulangCepatTab.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(listTitlePulangCepat));
        }
    }
    
    // [PENAMBAHAN] Method untuk mengklik tab Terlambat
    public void clickTabTerlambat() {
        try {
            WebElement terlambatTab = wait.until(ExpectedConditions.elementToBeClickable(tabTerlambat));
            terlambatTab.click();
            // Tunggu judul list muncul
            wait.until(ExpectedConditions.visibilityOfElementLocated(listTitleTerlambat));
        } catch (StaleElementReferenceException e) {
            WebElement terlambatTab = wait.until(ExpectedConditions.elementToBeClickable(tabTerlambat));
            terlambatTab.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(listTitleTerlambat));
        }
    }
    
    public void clickKembali() {
        try {
            WebElement kembaliBtn = wait.until(ExpectedConditions.elementToBeClickable(buttonKembali));
            kembaliBtn.click();
        } catch (StaleElementReferenceException e) {
            WebElement kembaliBtn = wait.until(ExpectedConditions.elementToBeClickable(buttonKembali));
            kembaliBtn.click();
        }
    }

    public boolean isListPulangCepatDisplayed() {
        try {
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(listTitlePulangCepat));
            return title.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    // [PENAMBAHAN] Method untuk memeriksa apakah list terlambat ditampilkan
    public boolean isListTerlambatDisplayed() {
        try {
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(listTitleTerlambat));
            return title.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public int getTotalData() {
        try {
            WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(totalData));
            String totalText = totalElement.getText();
            return Integer.parseInt(totalText.replaceAll("[^0-9]", ""));
        } catch (Exception e) {
            return -1;
        }
    }

    // [PERUBAHAN] Method untuk mendapatkan jumlah kartu dengan parameter jenis izin
    public int getPermitCardCount(String permitType) {
        try {
            // Scroll untuk memuat lebih banyak data jika menggunakan infinite scroll
            scrollToLoadMoreCards();
            
            List<WebElement> cards;
            if (permitType.equals("Pulang Cepat")) {
                cards = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(permitCardsPulangCepat));
            } else {
                cards = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(permitCardsTerlambat));
            }
            return cards.size();
        } catch (Exception e) {
            return 0;
        }
    }

    private void scrollToLoadMoreCards() {
        try {
            // Jika menggunakan infinite scroll, coba scroll untuk memuat lebih banyak data
            WebElement scrollContainer = driver.findElement(infiniteScrollContainer);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            
            // Scroll ke bawah container
            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollContainer);
            
            // Tunggu sebentar untuk loading data
            Thread.sleep(2000);
            
            // Scroll lagi untuk memastikan
            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollContainer);
            
            // Tunggu lagi
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error scrolling to load more cards: " + e.getMessage());
        }
    }

    public boolean isAjukanPulangCepatButtonDisplayed() {
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAjukanPulangCepat));
            return button.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    // [PENAMBAHAN] Method untuk memeriksa tombol ajukan terlambat
    public boolean isAjukanTerlambatButtonDisplayed() {
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAjukanTerlambat));
            return button.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isTabPulangCepatActive() {
        try {
            WebElement tab = driver.findElement(tabPulangCepat);
            return tab.getAttribute("class").contains("Mui-selected");
        } catch (Exception e) {
            return false;
        }
    }
    
    // [PENAMBAHAN] Method untuk memeriksa apakah tab terlambat aktif
    public boolean isTabTerlambatActive() {
        try {
            WebElement tab = driver.findElement(tabTerlambat);
            return tab.getAttribute("class").contains("Mui-selected");
        } catch (Exception e) {
            return false;
        }
    }

    // [PERUBAHAN] Method untuk mendapatkan data izin dengan parameter jenis izin
    public List<PermitData> getPermitDataList(String permitType) {
        List<PermitData> permitDataList = new ArrayList<>();
        
        try {
            // Scroll untuk memuat lebih banyak data
            scrollToLoadMoreCards();
            
            List<WebElement> cards;
            if (permitType.equals("Pulang Cepat")) {
                cards = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(permitCardsPulangCepat));
            } else {
                cards = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(permitCardsTerlambat));
            }
            
            for (WebElement card : cards) {
                try {
                    PermitData permitData = new PermitData();
                    // [PERUBAHAN] Menambahkan jenis izin ke data
                    permitData.permitType = permitType;
                    
                    // Extract nama
                    permitData.nama = card.findElement(By.xpath(".//p[contains(@class,'css-7s79m')]")).getText();
                    
                    // Extract label and value pairs
                    List<WebElement> labels = card.findElements(By.xpath(".//div[contains(@class,'css-d2rcfq')]//p"));
                    List<WebElement> values = card.findElements(By.xpath(".//div[contains(@class,'css-1sa3tdi')]//p"));
                    
                    for (int i = 0; i < labels.size(); i++) {
                        String label = labels.get(i).getText().replace(":", "").trim();
                        String value = values.get(i).getText().replace(":", "").trim();
                        
                        switch (label) {
                            case "Pulang Cepat":
                            case "Jam Terlambat":
                                permitData.waktu = value;
                                break;
                            case "Status":
                                permitData.status = value;
                                break;
                            case "Catatan":
                                permitData.catatan = value;
                                break;
                            case "Alasan Ditolak":
                                permitData.alasanDitolak = value;
                                break;
                            case "Tanggal Dibuat":
                                permitData.tanggalDibuat = value;
                                break;
                        }
                    }
                    
                    permitDataList.add(permitData);
                } catch (StaleElementReferenceException e) {
                    // Skip card yang stale dan lanjut ke berikutnya
                    System.out.println("Melewati kartu yang stale: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error extracting permit data: " + e.getMessage());
        }
        
        return permitDataList;
    }

    // [PERUBAHAN] Method untuk mencetak data dengan parameter jenis izin
    public void printListData(String permitType) {
        List<PermitData> permitDataList = getPermitDataList(permitType);
        
        if (permitDataList.isEmpty()) {
            System.out.println("Tidak ada data izin " + permitType.toLowerCase());
            return;
        }
        
        System.out.println("Daftar Izin " + permitType + ":");
        System.out.println("=========================");
        System.out.println("Total Data: " + getTotalData());
        System.out.println("Jumlah Kartu Ditampilkan: " + permitDataList.size());
        System.out.println("=========================");
        
        for (int i = 0; i < permitDataList.size(); i++) {
            PermitData data = permitDataList.get(i);
            
            System.out.println("Data ke-" + (i + 1) + ":");
            System.out.println("  Nama: " + data.nama);
            // [PERUBAHAN] Menampilkan label yang sesuai dengan jenis izin
            System.out.println("  " + (data.permitType.equals("Pulang Cepat") ? "Pulang Cepat" : "Jam Terlambat") + ": " + data.waktu);
            System.out.println("  Status: " + data.status);
            System.out.println("  Catatan: " + data.catatan);
            System.out.println("  Alasan Ditolak: " + data.alasanDitolak);
            System.out.println("  Tanggal Dibuat: " + data.tanggalDibuat);
            System.out.println("-------------------------");
        }
    }

    // [PERUBAHAN] Menambahkan field permitType ke class PermitData
    public static class PermitData {
        public String permitType;
        public String nama;
        public String waktu;
        public String status;
        public String catatan;
        public String alasanDitolak;
        public String tanggalDibuat;
    }
}