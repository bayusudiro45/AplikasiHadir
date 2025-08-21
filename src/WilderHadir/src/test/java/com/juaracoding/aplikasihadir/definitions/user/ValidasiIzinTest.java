// package com.juaracoding.aplikasihadir.definitions.user;

// import java.time.Duration;

// import org.openqa.selenium.By;
// //import org.openqa.selenium.JavascriptExecutor;
// //import org.openqa.selenium.TimeoutException;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// //import org.openqa.selenium.WebDriver;
// import org.testng.Assert;
// import org.testng.annotations.Test;

// import com.juaracoding.aplikasihadir.page.LoginPage;
// import com.juaracoding.aplikasihadir.utils.DriverManager;
// import com.juaracoding.aplikasihadir.utils.MenuHelper;

// public class ValidasiIzinTest {

//     @Test
//     public void testMasukKeHalamanIzin() {
//         WebDriver driver = DriverManager.getDriver();
//         driver.get("https://magang.dikahadir.com/absen/login");

//         // Step 1: Login
//         LoginPage loginPage = new LoginPage(driver);
//         loginPage.login("hadirsqa1@gmail.com", "SQA@Hadir12345");

//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//         wait.until(ExpectedConditions.urlContains("/apps/absent"));

//         // Step 2: Klik menu "Izin" menggunakan helper
//         MenuHelper.clickMenuByText(driver, "Izin");

//         // Step 3: Tunggu halaman izin termuat
//         wait.until(ExpectedConditions.urlContains("/apps/absent/permit"));

//         // Step 4: Validasi elemen khas halaman izin
//         WebElement tombolAjukan = wait.until(ExpectedConditions.visibilityOfElementLocated(
//             By.xpath("//button[contains(text(),'Ajukan Izin Terlambat')]")
//         ));
//         Assert.assertTrue(tombolAjukan.isDisplayed(), "Tombol Ajukan Izin tidak muncul");

//         DriverManager.quitDriver();
//     }
// }
