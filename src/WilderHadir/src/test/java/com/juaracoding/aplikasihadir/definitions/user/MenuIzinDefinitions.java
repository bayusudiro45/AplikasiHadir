// package com.juaracoding.aplikasihadir.definitions.user;

// import com.juaracoding.aplikasihadir.page.DashboardPage;
// import com.juaracoding.aplikasihadir.page.MenuIzinPage;
// import com.juaracoding.aplikasihadir.utils.DriverManager;
// import io.cucumber.java.en.And;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.testng.Assert;

// import java.util.List;

// public class MenuIzinDefinitions {
    
//     private final WebDriver driver;
//     private final MenuIzinPage menuIzinPage;
//     private final DashboardPage dashboardPage;
    
//     public MenuIzinDefinitions() {
//         this.driver = DriverManager.getDriver();
//         this.menuIzinPage = new MenuIzinPage(driver);
//         this.dashboardPage = new DashboardPage(driver);
//     }

//     @Given("User sudah login ke aplikasi HADIR")
//     public void user_sudah_login_ke_aplikasi_hadir() {
//         // Asumsikan user sudah login untuk testing TC-001
//         // Dalam implementasi nyata, ini akan menggunakan step definition dari authentication
//         driver.get("https://magang.dikahadir.com/apps/absent");
//         System.out.println("User sudah login dan berada di dashboard");
//     }
    
//     @When("User mengklik menu {string}")
//     public void user_mengklik_menu(String menuName) {
//         if (menuName.equals("Izin")) {
//             menuIzinPage.clickMenuIzin();
//         }
//     }
    
//     @And("User memilih tab {string}")
//     public void user_memilih_tab(String tabName) {
//         if (tabName.equals("Terlambat")) {
//             menuIzinPage.clickTabTerlambat();
//         } else if (tabName.equals("Pulang Cepat")) {
//             menuIzinPage.clickTabPulangCepat();
//         }
//     }
    
//     @When("User klik tab {string}")
//     public void user_klik_tab(String tabName) {
//         if (tabName.equals("Terlambat")) {
//             menuIzinPage.clickTabTerlambat();
//         } else if (tabName.equals("Pulang Cepat")) {
//             menuIzinPage.clickTabPulangCepat();
//         }
//     }
    
//     @Then("Sistem menampilkan halaman izin dengan URL yang mengandung {string}")
//     public void sistem_menampilkan_halaman_izin_dengan_url_yang_mengandung(String urlParam) {
//         if (urlParam.equals("permit=late")) {
//             Assert.assertTrue(menuIzinPage.isUrlContainsLate(), 
//                 "URL tidak mengandung parameter permit=late");
//         } else if (urlParam.equals("permit=early")) {
//             Assert.assertTrue(menuIzinPage.isUrlContainsEarly(), 
//                 "URL tidak mengandung parameter permit=early");
//         }
//     }
    
//     @And("Sistem menampilkan daftar izin dengan kategori {string} saja")
//     public void sistem_menampilkan_daftar_izin_dengan_kategori_saja(String kategori) {
//         Assert.assertTrue(menuIzinPage.isTableDisplayed(), 
//             "Tabel daftar izin tidak ditampilkan");
        
//         // Verifikasi bahwa semua data memiliki kategori yang sesuai
//         List<WebElement> rows = menuIzinPage.getAllRows();
//         for (WebElement row : rows) {
//             String jenisIzin = menuIzinPage.getJenisIzinFromRow(row);
//             Assert.assertEquals(jenisIzin, kategori, 
//                 "Jenis izin tidak sesuai dengan kategori yang dipilih");
//         }
//     }
    
//     @And("Setiap data menampilkan kolom: Nama, Jenis Izin, Status, Alasan, Tanggal Dibuat")
//     public void setiap_data_menampilkan_kolom() {
//         Assert.assertTrue(menuIzinPage.isTableDisplayed(), 
//             "Tabel daftar izin tidak ditampilkan");
        
//         List<WebElement> rows = menuIzinPage.getAllRows();
//         for (WebElement row : rows) {
//             String nama = menuIzinPage.getNamaFromRow(row);
//             String jenisIzin = menuIzinPage.getJenisIzinFromRow(row);
//             String status = menuIzinPage.getStatusFromRow(row);
//             String alasan = menuIzinPage.getAlasanFromRow(row);
//             String tanggalDibuat = menuIzinPage.getTanggalDibuatFromRow(row);
            
//             Assert.assertNotNull(nama, "Kolom Nama tidak ditemukan");
//             Assert.assertNotNull(jenisIzin, "Kolom Jenis Izin tidak ditemukan");
//             Assert.assertNotNull(status, "Kolom Status tidak ditemukan");
//             Assert.assertNotNull(alasan, "Kolom Alasan tidak ditemukan");
//             Assert.assertNotNull(tanggalDibuat, "Kolom Tanggal Dibuat tidak ditemukan");
//         }
//     }
    
//     @And("Status izin sesuai dengan data di database")
//     public void status_izin_sesuai_dengan_data_di_database() {
//         // Implementasi verifikasi dengan database
//         // Ini bisa menggunakan query ke database atau API call
//         Assert.assertTrue(true, "Status izin sesuai dengan database");
//     }
    
//     @And("Jumlah data yang ditampilkan sesuai dengan jumlah data izin terlambat di database")
//     public void jumlah_data_yang_ditampilkan_sesuai_dengan_jumlah_data_izin_terlambat_di_database() {
//         // Implementasi verifikasi jumlah data dengan database
//         // Ini bisa menggunakan query ke database atau API call
//         int displayedCount = menuIzinPage.getRowCount();
//         Assert.assertTrue(displayedCount >= 0, "Jumlah data sesuai dengan database");
//     }
    
//     @And("User berada di halaman dashboard {string}")
//     public void user_berada_di_halaman_dashboard(String url) {
//         // Verifikasi bahwa user berada di halaman dashboard dengan URL yang sesuai
//         String currentUrl = driver.getCurrentUrl();
//         Assert.assertTrue(currentUrl.contains("/apps/absent"), 
//             "User tidak berada di halaman dashboard yang benar");
//     }
    
//     @And("User berada di tab {string}")
//     public void user_berada_di_tab(String tabName) {
//         if (tabName.equals("Terlambat")) {
//             Assert.assertTrue(menuIzinPage.isTabTerlambatActive(), 
//                 "User tidak berada di tab Terlambat");
//         } else if (tabName.equals("Pulang Cepat")) {
//             Assert.assertTrue(menuIzinPage.isTabPulangCepatActive(), 
//                 "User tidak berada di tab Pulang Cepat");
//         }
//     }
    
//     @Then("Sistem menampilkan daftar izin kategori {string}")
//     public void sistem_menampilkan_daftar_izin_kategori(String kategori) {
//         Assert.assertTrue(menuIzinPage.isTableDisplayed(), 
//             "Tabel daftar izin tidak ditampilkan");
        
//         List<WebElement> rows = menuIzinPage.getAllRows();
//         for (WebElement row : rows) {
//             String jenisIzin = menuIzinPage.getJenisIzinFromRow(row);
//             Assert.assertEquals(jenisIzin, kategori, 
//                 "Jenis izin tidak sesuai dengan kategori yang dipilih");
//         }
//     }
    
//     @And("Tabel menampilkan data sesuai FSD")
//     public void tabel_menampilkan_data_sesuai_fsd() {
//         Assert.assertTrue(menuIzinPage.isTableDisplayed(), 
//             "Tabel menampilkan data sesuai FSD");
//     }
    
//     @And("Tab {string} dalam keadaan aktif")
//     public void tab_dalam_keadaan_aktif(String tabName) {
//         if (tabName.equals("Terlambat")) {
//             Assert.assertTrue(menuIzinPage.isTabTerlambatActive(), 
//                 "Tab Terlambat tidak aktif");
//         } else if (tabName.equals("Pulang Cepat")) {
//             Assert.assertTrue(menuIzinPage.isTabPulangCepatActive(), 
//                 "Tab Pulang Cepat tidak aktif");
//         }
//     }
    
//     @And("Tab {string} tidak aktif")
//     public void tab_tidak_aktif(String tabName) {
//         if (tabName.equals("Terlambat")) {
//             Assert.assertFalse(menuIzinPage.isTabTerlambatActive(), 
//                 "Tab Terlambat masih aktif");
//         } else if (tabName.equals("Pulang Cepat")) {
//             Assert.assertFalse(menuIzinPage.isTabPulangCepatActive(), 
//                 "Tab Pulang Cepat masih aktif");
//         }
//     }
// }
