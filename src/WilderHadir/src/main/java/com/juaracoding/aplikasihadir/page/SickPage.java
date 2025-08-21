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

// [PENAMBAHAN] File baru untuk halaman Sakit
public class SickPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // URL
    public static final String URL = "https://magang.dikahadir.com/apps/absent/sick";

    // Locator untuk header halaman sakit
    private final By pageHeader = By.xpath("//p[normalize-space(.)='Halaman Sakit']");
    
    // Locator untuk tombol kembali
    private final By buttonKembali = By.xpath("//button[.//p[contains(text(),'Kembali')]]");
    
    // Locator untuk list request sakit
    private final By listTitleSick = By.xpath("//p[contains(text(),'List Request Sakit')]");
    private final By totalData = By.xpath("//p[contains(text(),'Total :')]");
    private final By sickCards = By.xpath("//div[contains(@class,'MuiCard-root')]");
    
    // Locator untuk tombol Ajukan Sakit
    private final By buttonAjukanSakit = By.xpath("//button[contains(text(),'Ajukan Sakit')]");
    
    // Locator untuk infinite scroll container
    private final By infiniteScrollContainer = By.xpath("//div[contains(@class,'infinite-scroll-component')]");

    public SickPage(WebDriver driver) {
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
    
    public void clickKembali() {
        try {
            WebElement kembaliBtn = wait.until(ExpectedConditions.elementToBeClickable(buttonKembali));
            kembaliBtn.click();
        } catch (StaleElementReferenceException e) {
            WebElement kembaliBtn = wait.until(ExpectedConditions.elementToBeClickable(buttonKembali));
            kembaliBtn.click();
        }
    }

    public boolean isListSickDisplayed() {
        try {
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(listTitleSick));
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

    public int getSickCardCount() {
        try {
            // Scroll untuk memuat lebih banyak data jika menggunakan infinite scroll
            scrollToLoadMoreCards();
            
            List<WebElement> cards = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sickCards));
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

    public boolean isAjukanSakitButtonDisplayed() {
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAjukanSakit));
            return button.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    // [PENAMBAHAN] Method untuk mendapatkan data sakit
    public List<SickData> getSickDataList() {
        List<SickData> sickDataList = new ArrayList<>();
        
        try {
            // Scroll untuk memuat lebih banyak data
            scrollToLoadMoreCards();
            
            List<WebElement> cards = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sickCards));
            
            for (WebElement card : cards) {
                try {
                    SickData sickData = new SickData();
                    
                    // Extract nama
                    sickData.nama = card.findElement(By.xpath(".//p[contains(@class,'css-14qdkt4')]")).getText();
                    
                    // Extract detail sakit
                    List<WebElement> details = card.findElements(By.xpath(".//p[contains(@class,'css-1mjl2y9')]"));
                    
                    for (WebElement detail : details) {
                        String text = detail.getText();
                        if (text.startsWith("Dari tanggal :")) {
                            sickData.dariTanggal = text.replace("Dari tanggal :", "").trim();
                        } else if (text.startsWith("Sampai Tanggal :")) {
                            sickData.sampaiTanggal = text.replace("Sampai Tanggal :", "").trim();
                        } else if (text.startsWith("Tanggal Pengajuan :")) {
                            sickData.tanggalPengajuan = text.replace("Tanggal Pengajuan :", "").trim();
                        }
                    }
                    
                    sickDataList.add(sickData);
                } catch (StaleElementReferenceException e) {
                    // Skip card yang stale dan lanjut ke berikutnya
                    System.out.println("Melewati kartu yang stale: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error extracting sick data: " + e.getMessage());
        }
        
        return sickDataList;
    }

    // [PENAMBAHAN] Method untuk mencetak data list request sakit
    public void printListData() {
        List<SickData> sickDataList = getSickDataList();
        
        if (sickDataList.isEmpty()) {
            System.out.println("Tidak ada data request sakit");
            return;
        }
        
        System.out.println("Daftar Request Sakit:");
        System.out.println("=========================");
        System.out.println("Total Data: " + getTotalData());
        System.out.println("Jumlah Kartu Ditampilkan: " + sickDataList.size());
        System.out.println("=========================");
        
        for (int i = 0; i < sickDataList.size(); i++) {
            SickData data = sickDataList.get(i);
            
            System.out.println("Data ke-" + (i + 1) + ":");
            System.out.println("  Nama: " + data.nama);
            System.out.println("  Dari Tanggal: " + data.dariTanggal);
            System.out.println("  Sampai Tanggal: " + data.sampaiTanggal);
            System.out.println("  Tanggal Pengajuan: " + data.tanggalPengajuan);
            System.out.println("-------------------------");
        }
    }

    // [PENAMBAHAN] Class untuk menyimpan data sakit
    public static class SickData {
        public String nama;
        public String dariTanggal;
        public String sampaiTanggal;
        public String tanggalPengajuan;
    }
}