// package com.juaracoding.aplikasihadir.definitions.user;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;
// import org.testng.annotations.Test;

// import com.juaracoding.aplikasihadir.page.LoginPage;
// import com.juaracoding.aplikasihadir.page.user.IzinPage;
// import com.juaracoding.aplikasihadir.utils.DriverManager;

// public class IzinTest {

//     @Test
//     public void testValidasiHalamanIzin() {
//         WebDriver driver = DriverManager.getDriver();
//         driver.get("https://magang.dikahadir.com/absen/login");

//          // Login
//         LoginPage loginPage = new LoginPage(driver);
//         loginPage.login("hadirsqa1@gmail.com", "SQA@Hadir12345");
//         WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
//         wait.until(ExpectedConditions.urlContains("/apps/absent"));

//         // Navigasi ke halaman Izin
//         IzinPage izinPage = new IzinPage(driver);
//         izinPage.bukaHalamanIzin();

//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Ajukan Izin Terlambat')]")));

//         // Validasi elemen
//         Assert.assertTrue(izinPage.getTombolAjukanIzin().isDisplayed(), "Tombol Ajukan Izin tidak muncul");
//         Assert.assertTrue(izinPage.getStatusMenungguApproval().size() > 0, "Status Menunggu Approval tidak ditemukan");
//         Assert.assertTrue(izinPage.getAlasan("ban bocor").isDisplayed(), "Alasan 'ban bocor' tidak ditemukan");
//         Assert.assertTrue(izinPage.getTanggal("02-07-2025").isDisplayed(), "Tanggal '02-07-2025' tidak ditemukan");

//         DriverManager.quitDriver();
//     }

// }

